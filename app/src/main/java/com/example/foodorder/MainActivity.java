package com.example.foodorder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String MSG = "order";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void placeOrder(View view){
        Intent intent = new Intent(this, orderActivity.class);

        EditText editText1 = findViewById(R.id.editText1);
        EditText editText3 = findViewById(R.id.editText3);
        Double height = Double.parseDouble(editText1.getText().toString());
        Double weight = Double.parseDouble(editText3.getText().toString());
        String message;

        double bmi= ((weight / height / height ) * 10000);

        String bmi1 = String.format("%.2f", bmi);
        if(bmi < 18.5){
            message = "You are Under Weight, focus on diet";

        }else
        if(bmi > 18.5 && bmi < 25){
            message = "Good, you are healthy Weighted";

        }else if(bmi > 25 && bmi<30) {
            message = "You are over Weighted, focus on diet";

        }else{
            message = "You are obese, please strict to healthy diet";

        }

        intent.putExtra(MSG, message);
        startActivity(intent);
    }
}

