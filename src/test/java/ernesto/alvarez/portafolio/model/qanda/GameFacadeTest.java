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

    @Test
    void testFirstAnswerPython() {
        GameFacade game = gameFacadeProvider.getObject(TypeOfQandA.PYTHON);

        assertEquals("myDict = dict(key1, value1, key2, value2)", game.getAnswer(0));
    }

    @Test
    void testLastAnswerPython() {
        GameFacade game = gameFacadeProvider.getObject(TypeOfQandA.PYTHON);

        assertEquals("myDict = dict(key1 : value1, key2 : value2)", game.getAnswer(3));
    }

    @Test
    void testSelectWrongAnswerPython() {
        GameFacade game = gameFacadeProvider.getObject();

        game.selectTheAnswer(0);

        assertEquals(0, game.getScore());
    }

    @Test
    void testSelectCorrectAnswerPython() {

        GameFacade game = gameFacadeProvider.getObject();

        game.selectTheAnswer(1);

        assertEquals(1, game.getScore());
    }

    @Test
    void changeToSecondQuestionPython() {
        GameFacade game = gameFacadeProvider.getObject();
        assertEquals("What's the syntax to create a non empty key:value dictionary?", game.getActualQuestion());

        game.selectTheAnswer(1);

    }

}
