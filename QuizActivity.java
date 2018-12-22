package com.la.myapplication;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity {

    private static final String TAG = "QuizActivity";
    private TextView mScoreView, mQuestion;
    private ImageView mOption1, mOption2, mOption3, mOption4;
    private int mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;
    Intent i;
    ArrayList<Integer> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mScoreView = findViewById(R.id.points);
        mOption1 = findViewById(R.id.mOption1);
        mOption2 = findViewById(R.id.mOption2);
        mOption3 = findViewById(R.id.mOption3);
        mOption4 = findViewById(R.id.mOption4);
        mQuestion = findViewById(R.id.question);
        list = new ArrayList<>();
        makeQuietions();

        updateQuestion(mQuestionNumber);
        i = new Intent(this, ResultsActivity.class);

        mOption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: mOption1.getTag()" + mOption1.getTag() + " mAnswer =" + mAnswer);
                if (mOption1.getTag().equals(mAnswer)) {
                    mScore++;
                    updateScore(mScore);
                    i.putExtra("SCORE", mScore);
                    updateQuestion(mQuestionNumber);
                } else {
//                    gameOver();
                    Toast.makeText(QuizActivity.this, "Wrong Answer!!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mOption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: mOption2.getTag()" + mOption2.getTag() + " mAnswer =" + mAnswer);
                if (mOption2.getTag().equals(mAnswer)) {
                    mScore++;
                    updateScore(mScore);
                    i.putExtra("SCORE", mScore);
                    updateQuestion(mQuestionNumber);

                } else {
                    Toast.makeText(QuizActivity.this, "Wrong Answer!!", Toast.LENGTH_SHORT).show();
//                    gameOver();
                }
            }
        });

        mOption3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: mOption3.getTag()" + mOption3.getTag() + " mAnswer =" + mAnswer);
                if (mOption3.getTag().equals(mAnswer)) {
                    mScore++;
                    updateScore(mScore);
                    i.putExtra("SCORE", mScore);
                    updateQuestion(mQuestionNumber);

                } else {
                    Toast.makeText(QuizActivity.this, "Wrong Answer!!", Toast.LENGTH_SHORT).show();
//                    gameOver();
                }
            }
        });

        mOption4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: mOption4.getTag()" + mOption4.getTag() + " mAnswer =" + mAnswer);
                if (mOption4.getTag().equals(mAnswer)) {
                    mScore++;
                    updateScore(mScore);
                    i.putExtra("SCORE", mScore);
                    updateQuestion(mQuestionNumber);

                } else {
                    Toast.makeText(QuizActivity.this, "Wrong Answer!!", Toast.LENGTH_SHORT).show();
//                    gameOver();
                }
            }
        });
    }

    private void gameOver() {
        startActivity(i);
    }


    private void makeQuietions() {
        /*0*/
        list.add(R.drawable.apple);
        /*1*/
        list.add(R.drawable.audi);
        /*2*/
        list.add(R.drawable.fb);
        /*3*/
        list.add(R.drawable.microsoft);
        /*4*/
        list.add(R.drawable.farrari);
        /*5*/
        list.add(R.drawable.google);
        /*6*/
        list.add(R.drawable.linked);
        /*7*/
        list.add(R.drawable.coca);
        /*8*/
        list.add(R.drawable.wipro);
        /*9*/
        list.add(R.drawable.bugatti);
    }

    private void updateQuestion(int QNO) {
        int sq[][] = {
                {5, 8, 0, 2},  //0
                {1, 3, 2, 7},  //1
                {2, 3, 6, 8},  //2
                {7, 4, 0, 1},  //3
                {1, 3, 4, 7},  //4
                {9, 2, 8, 4},  //5
                {1, 5, 3, 0},  //6
                {1, 5, 3, 0},  //7
                {2, 8, 3, 6},  //8
        };

        try {
            mQuestion.setText(QuizBook.questions[QNO]);
            mOption1.setImageResource(list.get(sq[QNO][0]));
            mOption1.setTag(list.get(sq[QNO][0]));
            mOption2.setImageResource(list.get(sq[QNO][1]));
            mOption2.setTag(list.get(sq[QNO][1]));
            mOption3.setImageResource(list.get(sq[QNO][2]));
            mOption3.setTag(list.get(sq[QNO][2]));
            mOption4.setImageResource(list.get(sq[QNO][3]));
            mOption4.setTag(list.get(sq[QNO][3]));
            mAnswer = QuizBook.answers[QNO];

            mQuestionNumber++;
        } catch (ArrayIndexOutOfBoundsException e) {
            gameOver();
        }
    }

    @SuppressLint("SetTextI18n")
    private void updateScore(int point) {
        mScoreView.setText("" + point);
    }

    @Override
    public void onBackPressed() {
        askToClose();
    }

    private void askToClose() {
        AlertDialog.Builder builder = new AlertDialog.Builder(QuizActivity.this);
        builder.setMessage("Are you sure you want to quit?");
        builder.setCancelable(true);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                finish();
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                dialog.cancel();

            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
