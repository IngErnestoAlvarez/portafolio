package ernesto.alvarez.portafolio.model.qanda;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class GameFacade {
    private QuestionParser qp;

    public GameFacade(TypeOfQandA language) {
        this.qp = new QuestionParser(language);
    }

    public String getActualQuestion() {
        return qp.getQuestion(1);
    }

    public void selectTheAnswer(int answer) {

    }

    public boolean areThereAnyMoreQuestions() {
        return true;
    }
}
