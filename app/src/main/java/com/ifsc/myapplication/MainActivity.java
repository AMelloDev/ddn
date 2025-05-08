package com.ifsc.myapplication;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.skydoves.colorpickerview.ColorEnvelope;
import com.skydoves.colorpickerview.ColorPickerDialog;
import com.skydoves.colorpickerview.listeners.ColorEnvelopeListener;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button buttonclear;
    Button buttoncolor, buttonCirc, buttonRet, buttonLin, buttonDesf;
    SimplePaint simplePaint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonclear = findViewById(R.id.buttonclear);
        simplePaint = findViewById(R.id.simplePaint);;
        buttoncolor = findViewById(R.id.colorpick);
        buttonLin = findViewById(R.id.buttonLin);
        buttonRet =findViewById(R.id.buttonRet);
        buttonCirc = findViewById(R.id.buttonCirc);
        buttonDesf = findViewById(R.id.buttonDesf);

        buttoncolor.setOnClickListener(v ->{
            new ColorPickerDialog.Builder(this)
                    .setTitle("ColorPicker Dialog")
                    .setPreferenceName("MyColorPickerDialog")
                    .setPositiveButton("Confirma",
                            new ColorEnvelopeListener() {
                                @Override
                                public void onColorSelected(ColorEnvelope envelope, boolean fromUser) {
                                    v.setBackgroundColor(envelope.getColor());
                                    simplePaint.changeColor(envelope.getColor());
                                }

                            })
                    .setNegativeButton("Cancela",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    dialogInterface.dismiss();
                                }
                            })
                    .attachAlphaSlideBar(true) // the default value is true.
                    .attachBrightnessSlideBar(true)  // the default value is true.
                    .setBottomSpace(12) // set a bottom space between the last slidebar and buttons.
                    .show();
        });

        buttonclear.setOnClickListener(v ->{
            simplePaint.clearDraw();
        });

        buttonCirc.setOnClickListener(v ->{
            simplePaint.escolheForma("circle");
        });

        buttonRet.setOnClickListener(v ->{
            simplePaint.escolheForma("retangulo");
        });

        buttonDesf.setOnClickListener(v ->{
            simplePaint.desfazer();
        });

        buttonLin.setOnClickListener(v ->{
            simplePaint.escolheForma("linha");
        });



    }


}