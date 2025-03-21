package com.ifsc.code;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    Button button;
    EditText editTextMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        button.setOnClickListener(V ->{
            Intent i = new Intent(getApplicationContext(),MsgActivity.class);
            editTextMsg = findViewById(R.id.editText);
            String mensagem = String.valueOf(editTextMsg.getText());
            i.putExtra("msg", mensagem);
            startActivity(i);
        });

        Log.d("CicloDeVida", "onCreate");
        Toast.makeText(this,"onCreate", Toast.LENGTH_LONG).show();
    }


         //public void iniciaNovaActivity() {

        // }
        @Override
        protected void onStart(){
           super.onStart();
            Log.d("CicloDeVida", "onStart");
            Toast.makeText(this,"onStart", Toast.LENGTH_LONG).show();
        }

        @Override
        protected void onResume(){
            super.onResume();
            Log.d("CicloDeVida", "onResume");
            Toast.makeText(this,"onResume", Toast.LENGTH_LONG).show();

        }
        @Override
        protected void onPause(){
            super.onPause();
            Log.d("CicloDeVida", "onPause");
            Toast.makeText(this,"onPause", Toast.LENGTH_LONG).show();
        }

        protected void onStop(){
            super.onStop();
            Log.d("CicloDeVida", "onStop");
            Toast.makeText(this,"onStop", Toast.LENGTH_LONG).show();
        }
        protected void onRestart(){
            super.onRestart();
            Log.d("CicloDeVida", "onRestart");
            Toast.makeText(this,"onRestart", Toast.LENGTH_LONG).show();
        }
        protected  void onDestroy(){
            super.onDestroy();
            Log.d("CicloDeVida", "onDestroy");
            Toast.makeText(this,"onDestroy", Toast.LENGTH_LONG).show();
        }
    }

