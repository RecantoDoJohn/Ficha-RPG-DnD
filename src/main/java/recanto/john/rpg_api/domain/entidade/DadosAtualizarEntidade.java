package recanto.john.rpg_api.domain.entidade;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarEntidade(
        @NotNull
        long id,
        Integer pontosVida,
        Integer nivel,
        Integer classeArmdura,
        Integer forca,
        Integer destreza,
        Integer constituicao,
        Integer inteligencia,
        Integer sabedoria,
        Integer carisma
) {
}
