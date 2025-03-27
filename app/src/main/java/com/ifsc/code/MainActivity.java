package com.ifsc.code;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    Button button;
    EditText editTextAltura, editTextPeso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button);
        editTextAltura = findViewById(R.id.editTextAltura);
        editTextPeso = findViewById(R.id.editTextPeso);

        button.setOnClickListener(V ->{
            String peso = editTextPeso.getText().toString().trim();
            String altura = editTextAltura.getText().toString().trim();

            if(!peso.isEmpty() && !altura.isEmpty()){
                try {
                    float pesoF = Float.parseFloat(peso);
                    float alturaF = Float.parseFloat(altura);

                    float imc = pesoF/(alturaF*alturaF);

                    String saude;
                    if (imc < 18.5) {
                        saude = "Abaixo do peso";
                    } else if (imc >= 18.5 && imc < 24.9) {
                        saude = "Peso saudável";
                    } else if (imc >= 25 && imc < 29.9) {
                        saude = "Sobrepeso";
                    } else if (imc >= 30 && imc < 34.9) {
                        saude = "Obesidade Grau I";
                    } else if (imc >= 35 && imc < 39.9) {
                        saude = "Obesidade Grau II";
                    } else {
                        saude = "Obesidade Grau III (Mórbida)";
                    }

                    Intent i = new Intent(getApplicationContext(),MsgActivity.class);
                    i.putExtra("imc", imc);
                    i.putExtra("condicao", saude);
                    startActivity(i);
                }catch (NumberFormatException e){
                    Toast.makeText(this, "Preencha valores Válidos", Toast.LENGTH_LONG).show();

                }
            }else {
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_LONG).show();
            }


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

