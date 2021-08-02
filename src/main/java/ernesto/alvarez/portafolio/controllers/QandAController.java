package ernesto.alvarez.portafolio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ernesto.alvarez.portafolio.model.qanda.GameFacade;

/**
 * QandAController
 */
@Controller
public class QandAController {

    @Autowired
    GameFacade qanda;

    @GetMapping("/game")
    public String game(@RequestParam String game, Model model) {
        model.addAttribute("game", game);
        model.addAttribute("question", qanda.getActualQuestion());
        model.addAttribute("answers", qanda.getAnswers());
        return "qanda";
    }
}
