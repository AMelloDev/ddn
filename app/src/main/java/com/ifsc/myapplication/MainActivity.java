package com.ifsc.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button buttonclear;
    SimplePaint simplePaint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonclear = findViewById(R.id.buttonclear);
        simplePaint = findViewById(R.id.simplePaint);

        buttonclear.setOnClickListener(v ->{
            simplePaint.clearDraw();
        });
    }


}