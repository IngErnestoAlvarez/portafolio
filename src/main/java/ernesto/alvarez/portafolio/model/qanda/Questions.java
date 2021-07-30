package ernesto.alvarez.portafolio.model.qanda;

import java.util.Map;

public class Questions {

    public static class Question {

        public static class Answer {
            private Boolean correct;
            private String answer;

            public Answer() {
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

        private String question;
        private Answer answer1;
        private Answer answer2;
        private Answer answer3;
        private Answer answer4;

        public Question() {

        }

        public String getQuestion() {
            return question;
        }

        public Answer getAnswer4() {
            return answer4;
        }

        public void setAnswer4(Answer answer4) {
            this.answer4 = answer4;
        }

        public Answer getAnswer3() {
            return answer3;
        }

        public void setAnswer3(Answer answer3) {
            this.answer3 = answer3;
        }

        public Answer getAnswer2() {
            return answer2;
        }

        public void setAnswer2(Answer answer2) {
            this.answer2 = answer2;
        }

        public Answer getAnswer1() {
            return answer1;
        }

        public void setAnswer1(Answer answer1) {
            this.answer1 = answer1;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

    }

    private Map<String, Question> questions;

    public Map<String, Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Map<String, Question> questions) {
        this.questions = questions;
    }

}
