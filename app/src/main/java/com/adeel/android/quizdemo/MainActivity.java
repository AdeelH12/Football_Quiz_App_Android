package com.adeel.android.quizdemo;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView mAnswerTextView;
    Button mTrueButton, mFalseButton;
    int mIndex = 0;
    int mQuestion;
    ProgressBar mProgressBar;
    TextView scoreText;
    int mScore;


    //TODO: Uncomment to create question bank
    private TrueFalse[] mQuestionBank = new TrueFalse[]{
            new TrueFalse(R.string.question_1, true),
            new TrueFalse(R.string.question_2, false),
            new TrueFalse(R.string.question_3, true),
            new TrueFalse(R.string.question_4, true),
            new TrueFalse(R.string.question_5, false),
            new TrueFalse(R.string.question_6, false)
    };

    final int PROGRESS_BAR_INCREMENT = (int) Math.ceil(100/mQuestionBank.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
        mAnswerTextView = (TextView) findViewById(R.id.textView);
        mTrueButton = (Button) findViewById(R.id.truebtn);
        mFalseButton = (Button) findViewById(R.id.falsebtn);
        scoreText = (TextView) findViewById(R.id.textView2);

        //when the buttons are clicked it should move you on to the next question

        mQuestion = mQuestionBank[mIndex].getQuestionId();

        mAnswerTextView.setText(mQuestion);

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userSelection(true);

                updateQuestion();



                updateScore();


            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userSelection(false);

                updateQuestion();

                //Do something here... So when the user presses false it compares the answer and displays a toast

                //Only increment the score if the user presses false and the answer is false..


                updateScore();

            }
        });


    }

    private void updateQuestion() {

//        Random mRand = new Random();
//
//        mIndex = mRand.nextInt(6);


        mIndex = (mIndex + 1) % mQuestionBank.length;


        if(mIndex == 0){


            AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
            alertDialog.setTitle("Game Over");
            alertDialog.setCancelable(false);
            alertDialog.setMessage("Game Over");
            alertDialog.setPositiveButton("Close Application", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    finish();

                }
            }).show();
        }




        mQuestion = mQuestionBank[mIndex].getQuestionId();

        mAnswerTextView.setText(mQuestion);

        mProgressBar.incrementProgressBy(PROGRESS_BAR_INCREMENT);




    }

    private void updateScore(){

        scoreText.setText("Score" + mScore + " /" + mQuestionBank.length);

    }




    private void userSelection(boolean trueOrFalse){

        boolean correctAnswer = mQuestionBank[mIndex].isAnswer();

        if(trueOrFalse == correctAnswer){


            Toast.makeText(getApplicationContext(), R.string.correct_toast, Toast.LENGTH_SHORT).show();
            mScore++;

        }else{

            Toast.makeText(getApplicationContext(), R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
        }

    }


}
