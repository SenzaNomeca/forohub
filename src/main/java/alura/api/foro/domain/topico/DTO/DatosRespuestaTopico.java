package alura.api.foro.domain.topico.DTO;

import java.time.LocalDateTime;

public record DatosRespuestaTopico(
        Long id,
        String titulo,
        String nombreCurso,
        String mensaje,
        LocalDateTime fechaDeCreacion,
        LocalDateTime fechaDeUltimaActualizacion
) {

}
