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

    private static final String QANDA_FILE = "qanda";
    private static final String QUESTION_ATTR = "question";
    private static final String ANSWERS_ATTR = "answers";

    @GetMapping("/game")
    public String game(@RequestParam String game, Model model) {
        GameFacade qanda = context.getBean(GameFacade.class);
        model.addAttribute("game", game);
        model.addAttribute(QUESTION_ATTR, qanda.getActualQuestion());
        model.addAttribute(ANSWERS_ATTR, qanda.getAnswers());
        return QANDA_FILE;
    }

    @GetMapping("/game/{id}")
    public String select(@PathVariable int id, Model model) {
        GameFacade qanda = context.getBean(GameFacade.class);
        qanda.selectTheAnswer(id);
        model.addAttribute(QUESTION_ATTR, qanda.getActualQuestion());
        model.addAttribute(ANSWERS_ATTR, qanda.getAnswers());
        return QANDA_FILE;
    }

    @PostMapping("/game/reset")
    public String reset(Model model) {
        GameFacade qanda = context.getBean(GameFacade.class);
        qanda.reset();

        model.addAttribute(QUESTION_ATTR, qanda.getActualQuestion());
        model.addAttribute(ANSWERS_ATTR, qanda.getAnswers());
        return QANDA_FILE;
    }
}
