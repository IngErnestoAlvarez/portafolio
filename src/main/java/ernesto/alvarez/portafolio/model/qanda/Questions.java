package ernesto.alvarez.portafolio.model.qanda;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Questions {

    private List<Question> questions;

    public static class Question {

        private String question;
        List<Answer> answers;

        public static class Answer {
            private Boolean correct;
            private String answer;

            public Answer() {
            }

            public Answer(boolean correct, String answer) {
                this.correct = Boolean.valueOf(correct);
                this.answer = answer;
            }

            public Boolean getCorrect() {
                return correct;
            }

            public void setCorrect(Boolean correct) {
                this.correct = correct;
            }

            public String getAnswer() {
                return answer;
            }

        }

        public Question() {

        }

        public String getQuestion() {
            return question;
        }

        public Answer getAnswer(int number) {
            return answers.get(number);
        }

        public void setQuestion(String question) {
            this.question = question;
        }

        public void setAnswers(List<Answer> answers) {
            this.answers = answers;
        }

        public List<String> getAnswers() {
            return this.answers.stream().map(s -> s.getAnswer()).collect(Collectors.toList());
        }
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

}
