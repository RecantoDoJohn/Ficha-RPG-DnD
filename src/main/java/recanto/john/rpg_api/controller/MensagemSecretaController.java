package recanto.john.rpg_api.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import recanto.john.rpg_api.domain.entidade.DadosListagemEntidade;
import recanto.john.rpg_api.domain.mensagem.MensagemSecreta;

@RestController
@RequestMapping("/mensagem")
public class MensagemSecretaController {

    @Autowired
    private SimpMessagingTemplate simpMessage;

    @PostMapping
    public ResponseEntity<?> enviarMensagem(@RequestBody @Valid MensagemSecreta mensagem) {
        simpMessage.convertAndSend("/topic/mensagem/" + mensagem.idPersonagem(), mensagem);
        return ResponseEntity.ok().body(mensagem);
    }
}
