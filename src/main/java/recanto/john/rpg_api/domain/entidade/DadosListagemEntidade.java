package recanto.john.rpg_api.domain.entidade;

import recanto.john.rpg_api.domain.personagem.Personagem;
import recanto.john.rpg_api.domain.personagem.Racas;

public record DadosListagemEntidade(
        long id,
                                      String nome,
                                      int pontosVida,
                                      int nivel,
                                      int classeArmdura,
                                      int forca,
                                      int destreza,
                                      int constituicao,
                                      int inteligencia,
                                      int sabedoria,
                                      int carisma,
                                      Racas raca) {

    public DadosListagemEntidade(Entidade personagem) {
        this(personagem.id, personagem.getNome(), personagem.getPontosVida(), personagem.getNivel(), personagem.getClasseArmdura(), personagem.getForca(), personagem.getDestreza(), personagem.getConstituicao(), personagem.getInteligencia(), personagem.getSabedoria(), personagem.getCarisma(), personagem.getRaca());
    }
}
