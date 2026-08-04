package recanto.john.rpg_api.domain.mesa;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.NoArgsConstructor;
import recanto.john.rpg_api.domain.jogador.Jogador;
import recanto.john.rpg_api.domain.personagem.Personagem;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name = "Mesas")
@Entity(name = "Mesa")
@Getter
@NoArgsConstructor
public class Mesa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;

    @OneToMany(mappedBy = "mesa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Personagem> personagems = new ArrayList<>();

    @ManyToMany(mappedBy = "mesas")
    private Set<Jogador> jogadores = new HashSet<>();

    public Mesa(@Valid DadosCadastroMesa dados) {
        this.titulo = dados.titulo();
        this.descricao = dados.descricao();
    }
}
