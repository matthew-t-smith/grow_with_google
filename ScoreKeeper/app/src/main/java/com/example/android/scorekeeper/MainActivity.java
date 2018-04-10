package com.example.android.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.android.scorekeeper.R;

public class MainActivity extends AppCompatActivity {

    int aGame = 0;
    int bGame = 0;
    int aSet1 = 0;
    int aSet2 = 0;
    int aSet3 = 0;
    int bSet1 = 0;
    int bSet2 = 0;
    int bSet3 = 0;
    int aMatch = 0;
    int bMatch = 0;
    boolean aGameWin = false; /** 60, by 2 */
    boolean aSetWin = false; /** 6 min, by 2 */
    boolean aMatchWin = false; /** best 2 of 3 */
    boolean deuce = false; /** game tied at 40 */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForA(aGame);
        displayForB(bGame);
    }

    public void score(View view) {
        switch(view.getId()) {
            case R.id.a_point:
                switch(aGame) {
                    case 0:
                    case 15:
                        aGame = aGame + 15;
                    break;

                    case 30:
                        aGame = aGame + 10;
                    break;

                    case 40:
                        if(isDeuce(aGame, bGame)) {
                            aGame = aGame + 10;
                            break;
                        }
                        aGameWin = true;
                        gameWin(aGameWin);
                }
                break;

            case R.id.b_point:
                switch(bGame) {
                    case 0:
                    case 15:
                        bGame = bGame + 15;
                        break;

                    case 30:
                        bGame = bGame + 10;
                        break;

                    case 40:
                        if(isDeuce(bGame, bGame)) {
                            bGame = bGame + 10;
                            break;
                        }
                        gameWin(aGameWin);
                }
                break;

        };
        displayForA(aGame);
        displayForB(bGame);
    }

    public boolean isDeuce(int a, int b) {
        if(a == b && a == 40) {
            return true;
        } else {
            return false;
        }
    }

    public void gameWin(boolean a) {
        aGame = 0;
        bGame = 0;
        if(a) {
            aSet = aSet + 1;
            aGameWin = false;
        } else {
            bSet = bSet + 1;
        }
    }

    public void setWin(boolean a) {

    }

    public void matchWin(boolean a) {

    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.a_point);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.b_point);
        scoreView.setText(String.valueOf(score));
    }

    public void resetDisplay(View view) {
        int aGame = 0;
        int bGame = 0;
        int aSet1 = 0;
        int aSet2 = 0;
        int aSet3 = 0;
        int bSet1 = 0;
        int bSet2 = 0;
        int bSet3 = 0;
        int aMatch = 0;
        int bMatch = 0;
        boolean aGameWin = false;
        boolean aSetWin = false;
        boolean aMatchWin = false;
        boolean deuce = false;
        displayForA(aGame);
        displayForB(bGame);
    }
}
