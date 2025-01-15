package alura.api.foro.domain.topico.usuarios;

import alura.api.foro.domain.topico.DTO.DatosRegistroTopico;
import alura.api.foro.domain.topico.DTO.DatosRespuestaTopico;
import alura.api.foro.domain.topico.Topico;
import alura.api.foro.domain.topico.TopicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class RegistroTopico {

    @Autowired
    private TopicoRepository topicoRepository;

    public ResponseEntity registrar(DatosRegistroTopico datosRegistroTopico, UriComponentsBuilder uriComponentsBuilder) {
        boolean existeTopico = topicoRepository.existsByTituloAndMensaje(
                datosRegistroTopico.titulo(),
                datosRegistroTopico.mensaje()
        );

        if (existeTopico) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body("Este tópico ya está en la base de datos");
        }

        // Guardar el nuevo tópico
        var topico = new Topico(datosRegistroTopico);
        topicoRepository.save(topico);

        // Crear respuesta
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(
                topico.getId(),
                topico.getTitulo(),
                topico.getNombreCurso(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getUltimaActualizacion()
        );
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }
}
