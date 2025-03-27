package com.ifsc.code;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MsgActivity extends AppCompatActivity {
     TextView textViewres, textViewCon;
     ImageView imageViewIMC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_msg);
        textViewres = findViewById(R.id.resultadoIMC);
        textViewCon = findViewById(R.id.textViewSaude);
        imageViewIMC = findViewById(R.id.imageView1);
        float imc = getIntent().getFloatExtra("imc", 0);
        textViewres.setText(String.format("Seu IMC é: %.2f", imc));
        String condicaoSaude = getIntent().getStringExtra("condicao");
        textViewCon.setText(condicaoSaude);

        int imageSource = R.drawable.normal;
        if (condicaoSaude.equals("Abaixo do peso")) {
            imageSource = R.drawable.abaixopeso;
        } else if (condicaoSaude.equals("Peso saudável")) {
            imageSource = R.drawable.normal;
        } else if (condicaoSaude.equals("Sobrepeso")) {
            imageSource = R.drawable.sobrepeso;
        } else if (condicaoSaude.equals("Obesidade Grau I")) {
            imageSource = R.drawable.obesidade1;
        } else if (condicaoSaude.equals("Obesidade Grau II")) {
            imageSource = R.drawable.obesidade2;
        } else if (condicaoSaude.equals("Obesidade Grau III")) {
            imageSource = R.drawable.obesidade3;
        }

        imageViewIMC.setImageResource(imageSource);
    }



}