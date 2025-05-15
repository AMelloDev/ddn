package com.ifsc.code;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.ifsc.code.*;
import com.ifsc.myapplication.R;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    String[] nomes =new String[]{"pera", "uva", "maça", "goiaba", "morango", "abacaxi", "kiwi"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.ifsc.myapplication.R.layout.activity_main);
        lv = findViewById(R.id.listview);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                nomes);

        lv.setAdapter(adapter);

       /* lv.setOnClickListener(new AdapterView.OnClickListener(
                @Override
                p

        ));*/
    }

}