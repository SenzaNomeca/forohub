package alura.api.foro.domain.topico.DTO;

import alura.api.foro.domain.topico.Topico;

import java.time.LocalDateTime;

public record DatosListadoTopico(
        Long id,
        String titulo,
        String nombreCurso,
        String mensaje,
        LocalDateTime fechaDeCreacion,
        LocalDateTime fechaDeUltimaActualizacion


) {
    public DatosListadoTopico(Topico topico){
        this(topico.getId(), topico.getTitulo(), topico.getNombreCurso(), topico.getMensaje(), topico.getFechaCreacion(), topico.getUltimaActualizacion());
    }
}
