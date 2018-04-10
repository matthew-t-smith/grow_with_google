package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int aScore = 0;
    int bScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(aScore);
        displayForTeamB(bScore);
    }

    public void score(View view) {
        switch(view.getId()) {
            case R.id.team_a_3:
                aScore = aScore + 3;
            break;

            case R.id.team_a_2:
                aScore = aScore + 2;
            break;

            case R.id.team_a_1:
                aScore = aScore + 1;
            break;

            case R.id.team_b_3:
                bScore = bScore + 3;
                break;

            case R.id.team_b_2:
                bScore = bScore + 2;
                break;

            case R.id.team_b_1:
                bScore = bScore + 1;
                break;
        };
        displayForTeamA(aScore);
        displayForTeamB(bScore);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    public void resetDisplay(View view) {
        aScore = 0;
        bScore = 0;
        displayForTeamA(aScore);
        displayForTeamB(bScore);
    }
}
