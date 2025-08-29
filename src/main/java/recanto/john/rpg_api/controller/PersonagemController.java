package recanto.john.rpg_api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import recanto.john.rpg_api.personagem.DadosCadastroPersonagem;
import recanto.john.rpg_api.personagem.DadosListagemPersonagem;
import recanto.john.rpg_api.personagem.Personagem;
import recanto.john.rpg_api.personagem.PersonagemRepository;

@RestController
@RequestMapping("/personagem")
public class PersonagemController {

    @Autowired
    private PersonagemRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarPersonagem(@RequestBody @Valid DadosCadastroPersonagem dados) {
        repository.save(new Personagem(dados));
    }

    @GetMapping
    public Page<DadosListagemPersonagem> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable page) {
        return repository.findAll(page).map(DadosListagemPersonagem::new);
    }
}
