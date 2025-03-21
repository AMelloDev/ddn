package com.ifsc.code;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MsgActivity extends AppCompatActivity {
     TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_msg);
        textView = findViewById(R.id.resultadoIMC);
        Bundle bundle = getIntent().getExtras();
        String string = bundle.getString("msg");
        textView.setText(string);
    }



}