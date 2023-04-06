package com.example.practicaltest01_06;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PracticalTest01Var06SecondaryActivity extends AppCompatActivity {
    TextView gained;
    Button ok;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var06_secondary);
        gained = findViewById(R.id.gained);
        ok = findViewById(R.id.ok);
        List<String> text = new ArrayList<>();
        int scoreNumber = 0;

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                gained.setText("0");
            } else {
                String numberHold = String.valueOf(extras.getInt("numberCheck"));
                String number1 = extras.getString("number1");
                String number2 = extras.getString("number2");
                String number3 = extras.getString("number3");
                text.add(number1);
                text.add(number2);
                text.add(number3);
                Toast.makeText(this, String.join(", ", text), Toast.LENGTH_SHORT).show();

                if (numberHold.equals("0")) {
                    if (number1.equals(number3) && number2.equals(number3) || number1.equals("*") && number2.equals(number3) || number1.equals(number3) && number2.equals("*") || number3.equals("*") && number1.equals(number2)
                            || number1.equals("*") && number2.equals("*") || number1.equals("*") && number3.equals("*") || number2.equals("*") && number3.equals("*")){
                        scoreNumber = 100;
                        gained.setText("Gained: " + scoreNumber);
                    }
                } else if (numberHold.equals("1")) {
                    if (number1.equals(number3) && number2.equals(number3) || number1.equals("*") && number2.equals(number3) || number1.equals(number3) && number2.equals("*") || number3.equals("*") && number1.equals(number2)
                            || number1.equals("*") && number2.equals("*") || number1.equals("*") && number3.equals("*") || number2.equals("*") && number3.equals("*")) {
                        scoreNumber = 50;
                        gained.setText("Gained: " + scoreNumber);
                    }
                } else if (numberHold.equals("2")) {
                    if (number1.equals(number3) && number2.equals(number3) || number1.equals("*") && number2.equals(number3) || number1.equals(number3) && number2.equals("*") || number3.equals("*") && number1.equals(number2)
                            || number1.equals("*") && number2.equals("*") || number1.equals("*") && number3.equals("*") || number2.equals("*") && number3.equals("*")) {
                        System.out.printf(number1 + " " + number2 + " " + number3 );
                        scoreNumber = 10;
                        gained.setText("Gained: " + scoreNumber);
                    }
                }
            }
        } else {
            gained.setText(savedInstanceState.getString("gained"));
        }

        ok.setOnClickListener(it -> {
            Toast.makeText(this, gained.getText(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent();
            intent.putExtra("gained", gained.getText());
            setResult(RESULT_OK, intent);
            finish();
        });

    }
}