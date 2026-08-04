package recanto.john.rpg_api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import recanto.john.rpg_api.domain.jogador.*;

import java.net.URI;

@RequestMapping("/jogador")
@RestController
public class JogadorController {

    @Autowired
    private JogadorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoJogador> cadastrar(@RequestBody @Valid DadosCadastroJogador dados, UriComponentsBuilder uriBuilder) {
        Jogador jogador = new Jogador(dados);
        repository.save(jogador);
        URI uri = uriBuilder.path("jogador/{id}").buildAndExpand(jogador.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoJogador(jogador));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemJogador>> listar(@PageableDefault(size = 10, sort = "nome") Pageable page) {
        Page<DadosListagemJogador> pageListJog = repository.findAll(page).map(DadosListagemJogador::new);
        return ResponseEntity.ok().body(pageListJog);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoJogador> detalhar(@PathVariable Long id) {
        Jogador jogador = repository.getReferenceById(id);

        return ResponseEntity.ok().body(new DadosDetalhamentoJogador(jogador));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<?> atualizar(@RequestBody @Valid DadosAtualizarJogador dados) {
        Jogador jogador = repository.getReferenceById(dados.id());
        jogador.atualizarInfos(dados);

        return ResponseEntity.ok(new DadosDetalhamentoJogador(jogador));
    }
}
