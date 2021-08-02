package ernesto.alvarez.portafolio.model.qanda;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * QandAConfig
 */
@Configuration
public class QandAConfig {

    @Bean("python")
    @Scope("session")
    public GameFacade python() {
        return new GameFacade(TypeOfQandA.PYTHON);
    }
}
