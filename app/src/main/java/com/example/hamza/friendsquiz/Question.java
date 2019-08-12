package com.example.hamza.friendsquiz;

public class Question {


        public static final String DIFFICULTY_EASY="easy";
        public static final String DIFFICULTY_MEDUIM="meduim";
        public static final String DIFFICULTY_HARD="hard";
        private  String question;
        private  String option1;
        private  String option2;
        private  String option3;
        private  int questionAns;
        private String difficulity;


        public Question(){}



        public Question(String question, String option1, String option2, String option3, int questionAns, String diffuculty) {
            this.question = question;
            this.option1 = option1;
            this.option2 = option2;
            this.option3 = option3;
            this.questionAns = questionAns;
            this.difficulity=diffuculty;

        }

        public String getQuestion() {
            return question;
        }

        public  void  setQuestion(String question) {
            this.question = question;
        }

        public String getOption1() {
            return option1;
        }

        public void setOption1(String option1) {
            this.option1 = option1;
        }

        public String getOption2() {
            return option2;
        }

        public void setOption2(String option2) {
            this.option2 = option2;
        }

        public String getOption3() {
            return option3;
        }

        public void setOption3(String option3) {
            this.option3 = option3;
        }

        public int getQuestionAns() {
            return questionAns;
        }

        public void setQuestionAns(int questionAns) {
            this.questionAns = questionAns;
        }
        public String getDifficulity() {
            return difficulity;
        }

        public void setDifficulity(String difficulity) {
            this.difficulity = difficulity;
        }
        public static String[] getAllDificultyLevels(){
            return new String[]{
                    DIFFICULTY_EASY,
                    DIFFICULTY_MEDUIM,
                    DIFFICULTY_HARD
            };
        }
    }


