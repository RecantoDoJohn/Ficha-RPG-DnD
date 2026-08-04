package recanto.john.rpg_api.domain.jogador;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroJogador(
        @NotBlank
        String nome
) {
}
