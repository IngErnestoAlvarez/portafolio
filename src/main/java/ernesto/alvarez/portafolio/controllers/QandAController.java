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
    private static final String PYTHON_BEAN = "python";

    @GetMapping("/game")
    public String game(@RequestParam String game, Model model) {
        GameFacade qanda = context.getBean(PYTHON_BEAN, GameFacade.class);
        model.addAttribute("game", game);
        model.addAttribute(QUESTION_ATTR, qanda.getActualQuestion());
        model.addAttribute(ANSWERS_ATTR, qanda.getAnswers());
        return QANDA_FILE;
    }

    @GetMapping("/game/{id}")
    public String select(@PathVariable int id, Model model) {
        GameFacade qanda = context.getBean(PYTHON_BEAN, GameFacade.class);
        qanda.selectTheAnswer(id);

        if (!qanda.areThereAnyMoreQuestions()) {
            return "redirect:score";
        }

        model.addAttribute(QUESTION_ATTR, qanda.getActualQuestion());
        model.addAttribute(ANSWERS_ATTR, qanda.getAnswers());
        return QANDA_FILE;
    }

    @PostMapping("/game")
    public String reset(Model model) {
        GameFacade qanda = context.getBean(PYTHON_BEAN, GameFacade.class);
        qanda.reset();

        model.addAttribute(QUESTION_ATTR, qanda.getActualQuestion());
        model.addAttribute(ANSWERS_ATTR, qanda.getAnswers());
        return QANDA_FILE;
    }

    @GetMapping("/game/score")
    public String score(Model model) {
        GameFacade qanda = context.getBean(PYTHON_BEAN, GameFacade.class);

        model.addAttribute("score", qanda.getScore());

        qanda.reset();
        return "score";
    }

    @PostMapping("/game/login")
    public String login(@RequestParam String name, @RequestParam int score, Model model) {
        GameFacade qanda = context.getBean(PYTHON_BEAN, GameFacade.class);
        qanda.createUser(name, score);

        model.addAttribute("users", qanda.getUsers());

        return "scores";
    }
}
