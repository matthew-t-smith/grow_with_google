package com.example.android.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.android.scorekeeper.R;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int aGame = 0;
    int bGame = 0;
    int aSet = 0;
    int bSet = 0;
    int aMatch = 0;
    int bMatch = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForA();
        displayForB();
    }

    public void score(View view) {
        switch(view.getId()) {
            case R.id.a_point:
                aGame += 1;
                if(gameWin(aGame, bGame)) {
                    aGame = 0;
                    bGame = 0;
                    aSet = aSet + 1;
                }
                if(setWin(aSet, bSet)) {
                    aSet = 0;
                    bSet = 0;
                    aMatch = aMatch + 1;
                }
                if(win(aMatch)) {
                    EditText e = (EditText)findViewById(R.id.player_a);
                    String aName = e.getText().toString();
                    displayWin(aName);
                }
            break;

            case R.id.b_point:
                bGame += 1;
                if(gameWin(aGame, bGame)) {
                    aGame = 0;
                    bGame = 0;
                    bSet = bSet + 1;
                }
                if(setWin(aSet, bSet)) {
                    aSet = 0;
                    bSet = 0;
                    bMatch = bMatch + 1;
                }
                if(win(bMatch)) {
                    EditText e = (EditText)findViewById(R.id.player_b);
                    String bName = e.getText().toString();
                    displayWin(bName);
                }
            break;

        };
        displayForA();
        displayForB();
    }

    public boolean gameWin(int a, int b) {
        return (((a-b) > 1 && a > 3) || ((b-a) > 1 && b > 3));
    }

    public boolean setWin(int a, int b) {
        return (((a-b) > 1 && a > 5) || ((b-a) > 1 && b > 5));
    }

    public boolean win(int s) {
        return (s == 2);
    }

    public void displayForA() {
        TextView gameView = (TextView) findViewById(R.id.a_game_score);
        TextView setView = (TextView) findViewById(R.id.a_set_score);
        TextView matchView = (TextView) findViewById(R.id.a_match_score);
        gameView.setText(String.valueOf(aGame));
        setView.setText(String.valueOf(aSet));
        matchView.setText(String.valueOf(aMatch));
    }

    public void displayForB() {
        TextView gameView = (TextView) findViewById(R.id.b_game_score);
        TextView setView = (TextView) findViewById(R.id.b_set_score);
        TextView matchView = (TextView) findViewById(R.id.b_match_score);
        gameView.setText(String.valueOf(bGame));
        setView.setText(String.valueOf(bSet));
        matchView.setText(String.valueOf(bMatch));
    }

    public void displayWin(String name) {
        TextView winnerView = (TextView) findViewById(R.id.winner);
        winnerView.setText(String.valueOf(name + " Wins!"));
    }

    public void resetDisplay(View view) {
        aGame = 0;
        bGame = 0;
        aSet = 0;
        bSet = 0;
        aMatch = 0;
        bMatch = 0;
        displayForA();
        displayForB();
        TextView winnerView = (TextView) findViewById(R.id.winner);
        winnerView.setText(String.valueOf(""));
    }
}
