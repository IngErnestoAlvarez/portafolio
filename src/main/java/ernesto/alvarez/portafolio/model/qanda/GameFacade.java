package ernesto.alvarez.portafolio.model.qanda;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
public class GameFacade {
    private QuestionParser qp;
    private int actualQuestion;
    private int score;

    public GameFacade(TypeOfQandA language) {
        this.qp = new QuestionParser(language);
        actualQuestion = 0;
        score = 0;
    }

    public GameFacade() {
        this(TypeOfQandA.PYTHON);
    }

    public String getActualQuestion() {
        return qp.getQuestion(actualQuestion);
    }

    public void selectTheAnswer(int answer) {
        if (qp.isAnswerCorrect(actualQuestion, answer)) {
            score++;
        }

        actualQuestion++;
    }

    public String getAnswer(int answer) {
        return qp.getAnswer(actualQuestion, answer);
    }

    public boolean areThereAnyMoreQuestions() {
        return qp.size() > actualQuestion;
    }

    public int getScore() {
        return score;
    }
}
