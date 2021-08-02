package ernesto.alvarez.portafolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * QandAController
 */
@Controller
public class QandAController {

    @GetMapping("/game")
    public String game() {
        return "qanda";
    }
}
