package com.example.android.quizapp_finalproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void submit(View view) {

        CheckBox box = (CheckBox) findViewById(R.id.checkbox);
        boolean boxy = box.isChecked();
        if(!boxy) {
            Toast.makeText(getApplicationContext(), "You must answer all questions.", Toast.LENGTH_SHORT).show();
            return;
        }

        int score = 0;

        RadioGroup first = (RadioGroup) findViewById(R.id.question_1);
        int one = first.getCheckedRadioButtonId();
        RadioButton name_1 = (RadioButton) findViewById(one);

        RadioGroup second = (RadioGroup) findViewById(R.id.question_2);
        int two = second.getCheckedRadioButtonId();
        RadioButton name_2 = (RadioButton) findViewById(two);

        RadioGroup third = (RadioGroup) findViewById(R.id.question_3);
        int three = third.getCheckedRadioButtonId();
        RadioButton name_3 = (RadioButton) findViewById(three);

        RadioGroup fourth = (RadioGroup) findViewById(R.id.question_4);
        int four = fourth.getCheckedRadioButtonId();
        RadioButton name_4 = (RadioButton) findViewById(four);

        RadioGroup fifth = (RadioGroup) findViewById(R.id.question_5);
        int five = fifth.getCheckedRadioButtonId();
        RadioButton name_5 = (RadioButton) findViewById(five);

        RadioGroup sixth = (RadioGroup) findViewById(R.id.question_6);
        int six = sixth.getCheckedRadioButtonId();
        RadioButton name_6 = (RadioButton) findViewById(six);

        RadioGroup seventh = (RadioGroup) findViewById(R.id.question_7);
        int seven = seventh.getCheckedRadioButtonId();
        RadioButton name_7 = (RadioButton) findViewById(seven);

        RadioGroup eighth = (RadioGroup) findViewById(R.id.question_8);
        int eight = eighth.getCheckedRadioButtonId();
        RadioButton name_8 = (RadioButton) findViewById(eight);

        if(name_1.getId() == R.id.d_1) {
            score += 1;
        }
        if(name_2.getId() == R.id.b_2) {
            score += 1;
        }
        if(name_3.getId() == R.id.b_3) {
            score += 1;
        }
        if(name_4.getId() == R.id.a_4) {
            score += 1;
        }
        if(name_5.getId() == R.id.c_5) {
            score += 1;
        }
        if(name_6.getId() == R.id.a_6) {
            score += 1;
        }
        if(name_7.getId() == R.id.d_7) {
            score += 1;
        }
        if(name_8.getId() == R.id.b_8) {
            score += 1;
        }

        String message = "You scored a " + score + "/8.";

        switch(score) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
                message += " Keep trying!";
            break;

            case 5:
            case 6:
                message += " Getting closer!";
            break;

            case 7:
                message += " Almost there!";
            break;

            case 8:
                message += " Way to go!";
            break;
        }

        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }

    public void reset(View view) {
        RadioGroup first = (RadioGroup) findViewById(R.id.question_1);
        first.clearCheck();
        RadioGroup second = (RadioGroup) findViewById(R.id.question_2);
        second.clearCheck();
        RadioGroup third = (RadioGroup) findViewById(R.id.question_3);
        third.clearCheck();
        RadioGroup fourth = (RadioGroup) findViewById(R.id.question_4);
        fourth.clearCheck();
        RadioGroup fifth = (RadioGroup) findViewById(R.id.question_5);
        fifth.clearCheck();
        RadioGroup sixth = (RadioGroup) findViewById(R.id.question_6);
        sixth.clearCheck();
        RadioGroup seventh = (RadioGroup) findViewById(R.id.question_7);
        seventh.clearCheck();
        RadioGroup eight = (RadioGroup) findViewById(R.id.question_8);
        eight.clearCheck();
        CheckBox box = (CheckBox) findViewById(R.id.checkbox);
        box.setChecked(false);
    }
}
