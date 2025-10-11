package recanto.john.rpg_api.domain.entidade;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import recanto.john.rpg_api.domain.personagem.Racas;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode( of = "id")
public abstract class Entidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    protected String nome;
    protected int pontosVida;
    protected int nivel;
    protected int classeArmdura;

    // status
    protected int forca;
    protected int destreza;
    protected int constituicao;
    protected int inteligencia;
    protected int sabedoria;
    protected int carisma;

    @Enumerated(EnumType.STRING)
    protected Racas raca;
}
