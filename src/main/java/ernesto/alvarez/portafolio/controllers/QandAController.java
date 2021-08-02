package ernesto.alvarez.portafolio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ernesto.alvarez.portafolio.model.qanda.GameFacade;

/**
 * QandAController
 */
@Controller
public class QandAController {

    @Autowired
    private ApplicationContext context;

    @GetMapping("/game")
    public String game(@RequestParam String game, Model model) {
        GameFacade qanda = context.getBean(GameFacade.class);
        model.addAttribute("game", game);
        model.addAttribute("question", qanda.getActualQuestion());
        model.addAttribute("answers", qanda.getAnswers());
        return "qanda";
    }

    @GetMapping("/game/{id}")
    public String select(@PathVariable int id, Model model) {
        GameFacade qanda = context.getBean(GameFacade.class);
        qanda.selectTheAnswer(id);
        model.addAttribute("question", qanda.getActualQuestion());
        model.addAttribute("answers", qanda.getAnswers());
        return "qanda";
    }

    @PostMapping("/game/reset")
    public String reset(Model model) {
        GameFacade qanda = context.getBean(GameFacade.class);
        qanda.reset();

        model.addAttribute("question", qanda.getActualQuestion());
        model.addAttribute("answers", qanda.getAnswers());
        return "qanda";
    }
}
