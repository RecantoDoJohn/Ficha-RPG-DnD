package recanto.john.rpg_api.personagem;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Table(name = "Personagens")
@Entity(name = "Personagem")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode( of = "id")
public class Personagem {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private int pontosVida;
    private int nivel;
    private int classeArmdura;

    // status
    private int forca;
    private int destreza;
    private int constituicao;
    private int inteligencia;
    private int sabedoria;
    private int carisma;

    @Enumerated(EnumType.STRING)
    private Racas raca;

    public Personagem(@Valid DadosCadastroPersonagem dados) {
        this.nome = dados.nome();
        this.pontosVida = dados.pontosVida();
        this.nivel = dados.nivel();
        this.classeArmdura = dados.classeArmdura();
        this.forca = dados.forca();
        this.destreza = dados.destreza();
        this.constituicao = dados.constituicao();
        this.inteligencia = dados.inteligencia();
        this.sabedoria = dados.sabedoria();
        this.carisma = dados.carisma();
        this.raca = dados.raca();
    }
}
