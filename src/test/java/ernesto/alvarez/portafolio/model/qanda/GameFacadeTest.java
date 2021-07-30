package ernesto.alvarez.portafolio.model.qanda;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GameFacadeTest {

    @Autowired
    private ObjectProvider<GameFacade> gameFacadeProvider;

    @Test
    void testFirstQuestionPython() {
        GameFacade game = gameFacadeProvider.getObject(TypeOfQandA.PYTHON);

        assertEquals("What's the syntax to create a non empty key:value dictionary?", game.getActualQuestion());
    }

}
