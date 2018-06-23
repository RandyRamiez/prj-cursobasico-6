package com.example.e.imccalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

public class MainActivity extends AppCompatActivity {
EditText etPeso, etAltura;
TextView tvPeso, tvAltura, tvResultado;
Button btnCalcular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etPeso =(EditText) findViewById(R.id.etPeso);
        etAltura =(EditText) findViewById(R.id.etAltura);
        tvResultado =(TextView) findViewById(R.id.tvResultado);
        btnCalcular=(Button) findViewById(R.id.btnCalcular);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double peso, altura, imc;
                peso = Double.parseDouble(etPeso.getText().toString());
                altura = Double.parseDouble(etAltura.getText().toString());
                imc = peso/Math.pow(altura,2);

                int situacion;
                if (imc<=18.5){
                    situacion=1;
                }
               else if (imc>18.5 && imc <24.99){
                    situacion=2;
                }
                else{situacion=3;}
                switch (situacion){
                    case 1:
                        Crouton.makeText(MainActivity.this, "Estas en bajo peso.", Style.INFO).show();
                        break;
                    case 2:
                        Crouton.makeText(MainActivity.this, "Estas en un peso saludable.", Style.CONFIRM).show();
                        break;
                    case 3:
                        Crouton.makeText(MainActivity.this, "Estas en Sobrepeso.", Style.ALERT).show();
                        break;
                }


                tvResultado.setText("Tu indice de masa muscular es: "+imc+"%");

            }
        });
    }
}
