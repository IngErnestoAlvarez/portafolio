package ernesto.alvarez.portafolio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ernesto.alvarez.portafolio.model.Decider;

@Controller
public class GreetingController {

    @Autowired
    Decider decider;

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
            Model model) {
        model.addAttribute("name", name);
        if (decider.isCorrectTheName(name)) {
            return "correct";
        }
        return "greeting";

    }
}
