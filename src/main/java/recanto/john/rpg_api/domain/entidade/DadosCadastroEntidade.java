package recanto.john.rpg_api.domain.entidade;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import recanto.john.rpg_api.domain.personagem.Racas;

public record DadosCadastroEntidade(
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
