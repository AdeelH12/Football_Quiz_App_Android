package com.adeel.android.quizdemo;

/**
 * Created by adeel on 21/06/2017.
 */

public class TrueFalse {

    private int mQuestionId;

    private boolean mAnswer;

    public TrueFalse(int questionResourceID, boolean trueOrfalse){

        mQuestionId = questionResourceID; // eg R.string.question_1

        mAnswer = trueOrfalse;      //true



    }

    public int getQuestionId() {
        return mQuestionId;
    }

    public void setQuestionId(int questionId) {
        mQuestionId = questionId;
    }

    public boolean isAnswer() {
        return mAnswer;
    }

    public void setAnswer(boolean answer) {
        mAnswer = answer;
    }
}