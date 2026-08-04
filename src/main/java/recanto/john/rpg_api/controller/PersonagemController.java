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
import recanto.john.rpg_api.domain.entidade.DadosAtualizarEntidade;
import recanto.john.rpg_api.domain.entidade.DadosCadastroEntidade;
import recanto.john.rpg_api.domain.entidade.DadosListagemEntidade;
import recanto.john.rpg_api.domain.entidade.Entidade;
import recanto.john.rpg_api.domain.personagem.Personagem;
import recanto.john.rpg_api.domain.personagem.PersonagemRepository;

import java.net.URI;

@RestController
@RequestMapping("/personagem")
public class PersonagemController {

    @Autowired
    private PersonagemRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrarPersonagem(@RequestBody @Valid DadosCadastroEntidade dados, UriComponentsBuilder uriBuilder) {
        Personagem personagem = new Personagem(dados);
        repository.save(personagem);
        URI uri = uriBuilder.path("/personagem/{id}").buildAndExpand(personagem.getId()).toUri();
        return  ResponseEntity.created(uri).body(new DadosListagemEntidade(personagem));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemEntidade>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable page) {
        Page<DadosListagemEntidade> pageListPer = repository.findAll(page).map(DadosListagemEntidade::new);
        return ResponseEntity.ok(pageListPer);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosListagemEntidade> detalhar(@PathVariable long id) {
        Personagem personagem = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosListagemEntidade(personagem));
    }


    @PutMapping
    @Transactional
    public ResponseEntity<?> atualizar(@RequestBody @Valid DadosAtualizarEntidade dados) {
        var personagem = repository.getReferenceById(dados.id());
        personagem.atualizaInfos(dados);

        return ResponseEntity.ok(new DadosListagemEntidade( (Entidade) personagem));
    }
}
