package com.example.android.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    int quantity = 1;

    public void valueChanger(View view) {
        switch(view.getId()) {
            case R.id.plus:
                if(quantity > 99) {
                    Toast.makeText(this, "You've ordered too many!", Toast.LENGTH_SHORT).show();
                } else {
                    quantity += 1;
                }
            break;

            case R.id.minus:
                if(quantity < 1) {
                    Toast.makeText(this,"There's nothing to order!", Toast.LENGTH_SHORT).show();
                } else {
                    quantity -= 1;
                }
            break;
        }

        displayQuantity(quantity);
    }

    public void submitOrder(View view) {

        int price = quantity * 5;

        EditText nameText = (EditText) findViewById(R.id.input_name);
        String name = nameText.getText().toString();

        CheckBox whippedBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
        boolean whipped = whippedBox.isChecked();

        CheckBox chocolateBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
        boolean chocolate = chocolateBox.isChecked();

        if(whipped) {
            price += quantity;
        }
        if(chocolate) {
            price += quantity;
        }

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, ("JustJava Order for " + name));
        intent.putExtra(Intent.EXTRA_TEXT, createOrderSummary(name, price, whipped, chocolate));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private String createOrderSummary(String name, int price, boolean addWhippedCream, boolean addChocolate) {
        String message = "Name: " + name;
        message += "\nAdd whipped cream? " + addWhippedCream;
        message += "\nAdd chocolate? " + addChocolate;
        message += "\nQuantity: " + quantity;
        message += "\nTotal: $" + price + ".00";
        message += "\nThank you!";
        return message;
    }

    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText(number);
    }
}