package recanto.john.rpg_api.domain.mesa;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroMesa(
        @NotBlank
        String titulo,
        @NotBlank
        String descricao
) {
}