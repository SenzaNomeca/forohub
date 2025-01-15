package alura.api.foro.domain.topico.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotNull
        @NotBlank
        @NotEmpty
        String mensaje,
        @NotNull
        @NotBlank
        @NotEmpty
        String nombreCurso,
        @NotNull
        @NotBlank
        @NotEmpty
        String titulo
) {
}
