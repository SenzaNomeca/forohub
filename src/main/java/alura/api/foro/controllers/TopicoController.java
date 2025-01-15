package alura.api.foro.controllers;

import alura.api.foro.domain.topico.DTO.DatosActualizarTopico;
import alura.api.foro.domain.topico.DTO.DatosListadoTopico;
import alura.api.foro.domain.topico.DTO.DatosRegistroTopico;
import alura.api.foro.domain.topico.DTO.DatosRespuestaTopico;
import alura.api.foro.domain.topico.TopicoRepository;
import alura.api.foro.domain.topico.Topico;
import alura.api.foro.domain.topico.usuarios.RegistroTopico;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private RegistroTopico registroTopico;


    @PostMapping
    public ResponseEntity<?> registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
                                          UriComponentsBuilder uriComponentsBuilder){
        return registroTopico.registrar(datosRegistroTopico, uriComponentsBuilder);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listarTopicos(@PageableDefault(size = 5) Pageable paginacion){
        return ResponseEntity.ok(topicoRepository.findAll(paginacion)
                        .map(DatosListadoTopico::new));

    }

    @PutMapping
    @Transactional
    public ResponseEntity<?> actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        try {
            Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
            topico.actualizarTopico(datosActualizarTopico);
            return ResponseEntity.ok(new DatosRespuestaTopico(topico.getId(), topico.getTitulo(),
                    topico.getNombreCurso(), topico.getMensaje(), topico.getFechaCreacion(),
                    topico.getUltimaActualizacion()));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El tópico con el ID proporcionado no existe.");
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> retornaDatosTopicoEspecifico(@PathVariable Long id) {
        try {
            Topico topico = topicoRepository.getReferenceById(id);
            var datosTopico = new DatosRespuestaTopico(topico.getId(), topico.getTitulo(),
                    topico.getNombreCurso(), topico.getMensaje(), topico.getFechaCreacion(),
                    topico.getUltimaActualizacion());
            return ResponseEntity.ok(datosTopico);
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tópico con ID " + id + " no encontrado.");
        }
    }
}
