package recanto.john.rpg_api.domain.jogador;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.NoArgsConstructor;
import recanto.john.rpg_api.domain.mesa.Mesa;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name = "Jogadores")
@Entity(name = "Jogador")
@Getter
@NoArgsConstructor
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    @ManyToMany
    @JoinTable(
            name = "jogador_mesa",
            joinColumns = @JoinColumn(name = "jogador_id"),
            inverseJoinColumns = @JoinColumn(name = "mesa_id")
            )
    private Set<Mesa> mesas = new HashSet<>();

    public Jogador(@Valid DadosCadastroJogador dados) {
        this.nome = dados.nome();
    }

    public void atualizarInfos(@Valid DadosAtualizarJogador dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }
    }
}
