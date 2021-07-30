package ernesto.alvarez.portafolio.model.qanda;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ernesto.alvarez.portafolio.model.qanda.Questions.Question;

public class QuestionParser {

    private Questions questions;

    public QuestionParser(TypeOfQandA language) {

        ObjectMapper mapper = new ObjectMapper();

        try {
            questions = mapper.readValue(Paths.get(language.getPath()).toFile(), Questions.class);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getQuestion(int number) {
        Map<String, Question> aux = questions.getQuestions();
        Question q = aux.get(Integer.toString(number));

        return q.getQuestion();

    }
}
