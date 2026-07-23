package recanto.john.rpg_api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import recanto.john.rpg_api.domain.mesa.DadosCadastroMesa;
import recanto.john.rpg_api.domain.mesa.DadosDetalhamentoMesa;
import recanto.john.rpg_api.domain.mesa.Mesa;
import recanto.john.rpg_api.domain.mesa.MesaRepository;

import java.net.URI;

@RestController
@RequestMapping("/mesa")
public class MesaController {

    @Autowired
    private MesaRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> criarMesa(@Valid @RequestBody DadosCadastroMesa dados, UriComponentsBuilder uriBuilder) {
        Mesa mesa = new Mesa(dados);
        repository.save(mesa);
        URI uri = uriBuilder.path("mesa/{id}").buildAndExpand(mesa.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoMesa(mesa));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> detalhaMesa(@PathVariable Long id) {
        Mesa mesa = repository.getReferenceById(id);

        return ResponseEntity.ok().body(new DadosDetalhamentoMesa(mesa));
    }
}
