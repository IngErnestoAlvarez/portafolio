package ernesto.alvarez.portafolio.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class Decider {

    private String name;

    public Decider(@Value("${decider.name}") String name) {
        this.name = name;
    }

    public boolean isCorrectTheName(String name) {
        if (name.equals(this.name))
            return true;
        return false;
    }

    public String getName() {
        return name;
    }

}
