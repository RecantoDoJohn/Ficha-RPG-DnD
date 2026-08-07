package recanto.john.rpg_api.domain.mensagem;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MensagemSecreta(
        @NotNull
        Long idPersonagem,
        @NotBlank
        String mensagem
) {
}
