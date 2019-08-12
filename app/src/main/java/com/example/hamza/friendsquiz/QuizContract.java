package com.example.hamza.friendsquiz;

import android.provider.BaseColumns;

public class QuizContract {

    private  QuizContract(){}
    public static class QuestionTable implements BaseColumns {
        public static final String TABLE_NAME="Quiz_question";
        public static final String COLUMN_QUESTION="question";
        public static final String COLUMN_OPTION1="OPTION1";
        public static final String COLUMN_OPTION2="OPTION2";
        public static final String COLUMN_OPTION3="OPTION3";
        public static final String COLUMN_ANSWER_NR="Answer_num";
        public static final String COLUMN_DIFFICULTY="diffculty";

    }
}
