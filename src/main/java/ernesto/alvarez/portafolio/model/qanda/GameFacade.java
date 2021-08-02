package ernesto.alvarez.portafolio.model.qanda;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ernesto.alvarez.portafolio.model.UserJDA;
import ernesto.alvarez.portafolio.model.UserRepository;

@Service
@Scope("session")
public class GameFacade {
    private QuestionParser qp;
    private int actualQuestion;
    private int score;

    @Autowired
    private UserRepository userRepo;

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

    }

    public void createUser(String name, int score) {
        UserJDA user = new UserJDA();
        user.setName(name);
        user.setScore(score);
        userRepo.save(user);
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

    public Iterable<UserJDA> getUsers() {
        return userRepo.findAllByOrderByScoreDesc();
    }

}
