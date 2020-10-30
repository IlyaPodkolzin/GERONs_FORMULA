package com.example.geronsformula;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    public EditText objectA, objectB, objectC;
    public TextView result1, result2, error, explanation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void findSq(View v) {
        objectA = findViewById(R.id.objA);
        objectB = findViewById(R.id.objB);
        objectC = findViewById(R.id.objC);
        result1 = findViewById(R.id.res1);
        result2 = findViewById(R.id.res2);
        error = findViewById(R.id.err);
        explanation = findViewById(R.id.err_explain);
        error.setText("");
        explanation.setText("");
        explanation.setBackgroundColor(0);

        String a1 = objectA.getText().toString();
        String b1 = objectB.getText().toString();
        String c1 = objectC.getText().toString();

        String abc [] = {a1, b1, c1};

        boolean flag = true;
        for (String i: abc) {
            try {
                double check = Double.parseDouble(i);
            }
            catch (NumberFormatException nfe) {
                flag = false;
            }
        }

        if (!flag) {
            error.setText("ОШИБКА!");
            explanation.setText("Вводимые значения должны быть численными.");
            explanation.setBackgroundColor(Color.parseColor("#63BD4343"));
        }

        else {
            double a = Double.parseDouble(a1);
            double b = Double.parseDouble(b1);
            double c = Double.parseDouble(c1);

            double p = (a + b + c) / 2;

            double S = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            DecimalFormat Sf = new DecimalFormat("#######.###");

            result1.setText(Sf.format(p));
            result2.setText(Sf.format(S));
        }
    }


}