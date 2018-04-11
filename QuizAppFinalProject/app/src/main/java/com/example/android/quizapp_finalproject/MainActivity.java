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
        String question_one = name_1.getText().toString();

        RadioGroup second = (RadioGroup) findViewById(R.id.question_2);
        int two = second.getCheckedRadioButtonId();
        RadioButton name_2 = (RadioButton) findViewById(two);
        String question_two = name_2.getText().toString();

        RadioGroup third = (RadioGroup) findViewById(R.id.question_3);
        int three = third.getCheckedRadioButtonId();
        RadioButton name_3 = (RadioButton) findViewById(three);
        String question_three = name_3.getText().toString();

        RadioGroup fourth = (RadioGroup) findViewById(R.id.question_4);
        int four = fourth.getCheckedRadioButtonId();
        RadioButton name_4 = (RadioButton) findViewById(four);
        String question_four = name_4.getText().toString();

        RadioGroup fifth = (RadioGroup) findViewById(R.id.question_5);
        int five = fifth.getCheckedRadioButtonId();
        RadioButton name_5 = (RadioButton) findViewById(five);
        String question_five = name_5.getText().toString();

        RadioGroup sixth = (RadioGroup) findViewById(R.id.question_6);
        int six = sixth.getCheckedRadioButtonId();
        RadioButton name_6 = (RadioButton) findViewById(six);
        String question_six = name_6.getText().toString();

        RadioGroup seventh = (RadioGroup) findViewById(R.id.question_7);
        int seven = seventh.getCheckedRadioButtonId();
        RadioButton name_7 = (RadioButton) findViewById(seven);
        String question_seven = name_7.getText().toString();

        RadioGroup eighth = (RadioGroup) findViewById(R.id.question_8);
        int eight = eighth.getCheckedRadioButtonId();
        RadioButton name_8 = (RadioButton) findViewById(eight);
        String question_eight = name_8.getText().toString();

//   Show answers submitted:
//        String answers = question_one + "\n" + question_two + "\n" + question_three + "\n" +
//                question_four + "\n" + question_five + "\n" + question_six + "\n" + question_seven + "\n"
//                + question_eight + "\n";
//        Toast.makeText(getApplicationContext(), answers, Toast.LENGTH_LONG).show();

        if(question_one == "n-1") {
            score += 1;
        }
        if(question_two == "Segment tree") {
            score += 1;
        }
        if(question_three == "Stack") {
            score += 1;
        }
        if(question_four == "client") {
            score += 1;
        }
        if(question_five == "0") {
            score += 1;
        }
        if(question_six == "final") {
            score += 1;
        }
        if(question_seven == "int 1_var;") {
            score += 1;
        }
        if(question_eight == "Extending") {
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
    }
}
