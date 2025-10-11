package recanto.john.rpg_api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import recanto.john.rpg_api.domain.entidade.DadosCadastroEntidade;
import recanto.john.rpg_api.domain.entidade.DadosListagemEntidade;
import recanto.john.rpg_api.domain.personagem.Personagem;
import recanto.john.rpg_api.domain.personagem.PersonagemRepository;

@RestController
@RequestMapping("/personagem")
public class PersonagemController {

    @Autowired
    private PersonagemRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrarPersonagem(@RequestBody @Valid DadosCadastroEntidade dados) {
        repository.save(new Personagem(dados));
//        tem que retornar o id do que foi cadastrado.
        return  ResponseEntity.ok().build();
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
}
