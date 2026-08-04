package recanto.john.rpg_api.domain.jogador;

import recanto.john.rpg_api.domain.mesa.Mesa;

import java.util.Set;

public record DadosDetalhamentoJogador(
        String nome,
        Set<Mesa> mesas
) {
    public DadosDetalhamentoJogador(Jogador jogador) {
        this(jogador.getNome(), jogador.getMesas());
    }
}
