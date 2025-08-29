package recanto.john.rpg_api.personagem;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosListagemPersonagem(
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

    public DadosListagemPersonagem(Personagem personagem) {
        this(personagem.getNome(), personagem.getPontosVida(), personagem.getNivel(), personagem.getClasseArmdura(), personagem.getForca(), personagem.getDestreza(), personagem.getConstituicao(), personagem.getInteligencia(), personagem.getSabedoria(), personagem.getCarisma(), personagem.getRaca());
    }
}
