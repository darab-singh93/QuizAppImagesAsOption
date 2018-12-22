package com.la.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    TextView mGrade, mFinalScore;
    Button mRetryButton;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        mGrade = (TextView) findViewById(R.id.grade);
        mFinalScore = (TextView) findViewById(R.id.outOf);
        mRetryButton = (Button) findViewById(R.id.retry);


        int score = getIntent().getIntExtra("SCORE", 0);

        mFinalScore.setText("You scored " + score + " out of " + QuizBook.questions.length);

        if (score == 9) {
            mGrade.setText("Outstanding");
        } else if (score == 8) {
            mGrade.setText("Very Good");
        } else if (score == 7) {
            mGrade.setText("Good");
        } else {
            mGrade.setText("Need to Improve");
        }

        mRetryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResultsActivity.this, QuizActivity.class));
                ResultsActivity.this.finish();
            }
        });

    }
}
