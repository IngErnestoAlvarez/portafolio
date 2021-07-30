package ernesto.alvarez.portafolio.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DeciderTest {

    @Autowired
    private Decider decider;

    @Value("${decider.name}")
    private String realName;

    @Test
    void testDeciderInCorrectNameGiven() {
        String tryThisOne = "JuanPablo";
        if (tryThisOne.equals(realName)) {
            tryThisOne = "Pedro";
        }
        assertFalse(decider.isCorrectTheName(tryThisOne));
    }

    @Test
    void testDeciderCorrectNameGiven() {

        assertTrue(decider.isCorrectTheName(realName));
    }

}
