package ernesto.alvarez.portafolio.model.qanda;

import java.util.List;
import java.util.stream.Collectors;

public class Questions {

    private List<Question> allQuestions;

    public static class Question {

        private String myQuestion;
        List<Answer> answers;

        public static class Answer {
            private Boolean correct;
            private String theAnswer;

            public Answer() {
            }

            public Answer(boolean correct, String answer) {
                this.correct = Boolean.valueOf(correct);
                this.theAnswer = answer;
            }

            public Boolean getCorrect() {
                return correct;
            }

            public void setCorrect(Boolean correct) {
                this.correct = correct;
            }

            public String getAnswer() {
                return theAnswer;
            }

        }

        public String getQuestion() {
            return myQuestion;
        }

        public Answer getAnswer(int number) {
            return answers.get(number);
        }

        public void setQuestion(String question) {
            this.myQuestion = question;
        }

        public void setAnswers(List<Answer> answers) {
            this.answers = answers;
        }

        public List<String> getAnswers() {
            return this.answers.stream().map(s -> s.getAnswer()).collect(Collectors.toList());
        }
    }

    public List<Question> getQuestions() {
        return allQuestions;
    }

    public void setQuestions(List<Question> questions) {
        this.allQuestions = questions;
    }

}
