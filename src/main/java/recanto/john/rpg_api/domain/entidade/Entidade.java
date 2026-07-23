package recanto.john.rpg_api.domain.entidade;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import recanto.john.rpg_api.domain.personagem.Racas;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode( of = "id")
public abstract class Entidade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    protected String nome;
    protected Integer pontosVida;
    protected Integer nivel;
    protected Integer classeArmdura;

    // status
    protected Integer forca;
    protected Integer destreza;
    protected Integer constituicao;
    protected Integer inteligencia;
    protected Integer sabedoria;
    protected Integer carisma;

    @Enumerated(EnumType.STRING)
    protected Racas raca;

    protected Boolean ativo;


    @CreationTimestamp
    @Column(updatable = false)
    protected LocalDateTime createdAt;

    @UpdateTimestamp
    protected LocalDateTime updatedAt;


    public void atualizaInfos(@Valid DadosAtualizarEntidade dados) {
        if (dados.pontosVida() != null) {
            this.pontosVida = dados.pontosVida();
        }
        if (dados.nivel() != null) {
            this.nivel = dados.nivel();
        }
        if (dados.classeArmdura() != null) {
            this.classeArmdura = dados.classeArmdura();
        }
        if (dados.forca() != null) {
            this.forca = dados.forca();
        }
        if (dados.destreza() != null) {
            this.destreza = dados.destreza();
        }
        if (dados.constituicao() != null) {
            this.constituicao = dados.constituicao();
        }
        if (dados.inteligencia() != null) {
            this.inteligencia = dados.inteligencia();
        }
        if (dados.sabedoria() != null) {
            this.sabedoria = dados.sabedoria();
        }
        if (dados.carisma() != null) {
            this.carisma = dados.carisma();
        }
    }
}
