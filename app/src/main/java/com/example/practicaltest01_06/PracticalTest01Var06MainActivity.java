package com.example.practicaltest01_06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class PracticalTest01Var06MainActivity extends AppCompatActivity {
    EditText number1;
    EditText number2;
    EditText number3;
    CheckBox hold1;
    CheckBox hold2;
    CheckBox hold3;
    Button play;
    List<String> numbers = List.of("*", "1", "2", "3");
    int myRequestCode = 1;
    String score;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var06_main);
        Random rand = new Random();
        List<String> text = new ArrayList<>();
        AtomicInteger numberCheck = new AtomicInteger();

        number1 = findViewById(R.id.number1);
        number2 = findViewById(R.id.number2);
        number3 = findViewById(R.id.number3);
        hold1 = findViewById(R.id.hold1);
        hold2 = findViewById(R.id.hold2);
        hold3 = findViewById(R.id.hold3);
        play = findViewById(R.id.play);

        play.setOnClickListener(it -> {
            if (!hold1.isChecked()) {
                number1.setText(numbers.get(rand.nextInt(numbers.size())));
                text.add(number1.getText().toString());
            } else {
                numberCheck.getAndIncrement();
            }
            if (!hold2.isChecked()) {
                number2.setText(numbers.get(rand.nextInt(numbers.size())));
                text.add(number2.getText().toString());
            } else {
                numberCheck.getAndIncrement();
            }
            if (!hold3.isChecked()) {
                number3.setText(numbers.get(rand.nextInt(numbers.size())));
                text.add(number3.getText().toString());
            } else {
                numberCheck.getAndIncrement();
            }

            Intent intent = new Intent(this, PracticalTest01Var06SecondaryActivity.class);
            intent.putExtra("number1", number1.getText().toString());
            intent.putExtra("number2", number2.getText().toString());
            intent.putExtra("number3", number3.getText().toString());
            intent.putExtra("numberCheck", numberCheck.get());
            startActivityForResult(intent, myRequestCode);
            numberCheck.set(0);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == myRequestCode) {
            score = intent.getStringExtra("gained");
            Toast.makeText(this, score, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString("score", score);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState.containsKey("score")) {
            score = savedInstanceState.getString("score");
            Toast.makeText(this, score, Toast.LENGTH_LONG).show();
        }
    }

}