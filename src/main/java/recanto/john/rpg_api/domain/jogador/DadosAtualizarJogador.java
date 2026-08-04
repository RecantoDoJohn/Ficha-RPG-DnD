package recanto.john.rpg_api.domain.jogador;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarJogador(
        @NotNull
        Long id,
        String nome
) {
}
