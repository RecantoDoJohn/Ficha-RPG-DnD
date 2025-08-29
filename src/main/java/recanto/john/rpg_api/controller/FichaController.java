package recanto.john.rpg_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FichaController {

    @RequestMapping("/ficha")
    public String ficha() {
        return "fichaPlayer";
    }
}
