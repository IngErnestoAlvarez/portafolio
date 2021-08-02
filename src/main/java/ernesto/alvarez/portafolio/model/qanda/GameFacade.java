package ernesto.alvarez.portafolio.model.qanda;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("session")
public class GameFacade {
    private QuestionParser qp;
    private int actualQuestion;
    private int score;

    public GameFacade(TypeOfQandA language) {
        this.qp = new QuestionParser(language);
        reset();
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

        if (!areThereAnyMoreQuestions()) {
            reset();
        }
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

    public List<String> getAnswers() {
        return qp.getAnswers(actualQuestion);
    }

    public void reset() {
        score = 0;
        actualQuestion = 0;
    }
}
