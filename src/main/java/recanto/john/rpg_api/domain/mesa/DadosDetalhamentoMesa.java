package recanto.john.rpg_api.domain.mesa;

import recanto.john.rpg_api.domain.personagem.Personagem;

import java.util.List;

public record DadosDetalhamentoMesa(
        String titulo,
        String descricao,
        List<Personagem> personagems
) {
    public DadosDetalhamentoMesa(Mesa mesa) {
        this(mesa.getTitulo(), mesa.getDescricao(), mesa.getPersonagems());
    }
}
