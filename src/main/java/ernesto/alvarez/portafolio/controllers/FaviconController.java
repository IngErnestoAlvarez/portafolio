package ernesto.alvarez.portafolio.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * FaviconController
 */
@Controller
public class FaviconController {

    @GetMapping("favicon.ico")
    @ResponseBody
    public void ret() {
        // Overriding favicon get method
    }
}
