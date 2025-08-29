package recanto.john.rpg_api.personagem;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroPersonagem(
        @NotBlank
        String nome,
        @NotNull
        int pontosVida,
        @NotNull
        int nivel,
        @NotNull
        int classeArmdura,
        @NotNull
        int forca,
        @NotNull
        int destreza,
        @NotNull
        int constituicao,
        @NotNull
        int inteligencia,
        @NotNull
        int sabedoria,
        @NotNull
        int carisma,
        @NotNull
        Racas raca
) {

}
