package com.ifsc.code;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText edMin, edMax;
    TextView TxResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);
     setContentView(R.layout.activity_main);
     edMin = findViewById(R.id.edMin);
     edMax = findViewById(R.id.edMax);
     TxResult = findViewById(R.id.TxResult);
     Button b = findViewById(R.id.btSort);

     b.setOnClickListener(v -> {
         int min = Integer.parseInt(edMin.getText().toString());
         int max = Integer.parseInt(edMax.getText().toString());

         //Random
         Random random = new Random();

         int n= random.nextInt(max-min)+min;
         TxResult.setText(Integer.toString(n));
     });


    }

}