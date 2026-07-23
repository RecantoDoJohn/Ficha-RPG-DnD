package recanto.john.rpg_api.domain.personagem;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;
import recanto.john.rpg_api.domain.entidade.DadosCadastroEntidade;
import recanto.john.rpg_api.domain.entidade.Entidade;
import recanto.john.rpg_api.domain.mesa.Mesa;

@Table(name = "Personagens")
@Entity(name = "Personagem")
@NoArgsConstructor
public class Personagem extends Entidade {

    @ManyToOne
    @JoinColumn(name = "mesa_id")
    private Mesa mesa;

    public Personagem(@Valid DadosCadastroEntidade dados) {
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
