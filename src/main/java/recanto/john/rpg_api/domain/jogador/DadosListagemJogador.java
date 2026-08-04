package recanto.john.rpg_api.domain.jogador;

public record DadosListagemJogador(
        String nome
) {
    public DadosListagemJogador(Jogador jogador) {
        this(jogador.getNome());
    }
}
