package com.keniaruiz.juegoaritmetica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageButton suma,resta,multiplicacion,division;
    private Button salir;
    private TextView puntos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        puntos = (TextView) findViewById(R.id.text_puntosT);

        String puntosTotales = getIntent().getStringExtra("puntos");
        puntos.setText(puntosTotales);


        suma = (ImageButton) findViewById(R.id.button_suma);
        suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent operaciones = new Intent(MainActivity.this, OperandoActivity.class);
                operaciones.putExtra("operando","suma");
                operaciones.putExtra("puntos",puntosTotales);
                startActivity(operaciones);
            }
        });

        resta = (ImageButton) findViewById(R.id.button_resta);
        resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent operaciones = new Intent(MainActivity.this, OperandoActivity.class);
                operaciones.putExtra("operando","resta");
                operaciones.putExtra("puntos",puntosTotales);
                startActivity(operaciones);

            }
        });

        division = (ImageButton) findViewById(R.id.button_division);
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent operaciones = new Intent(MainActivity.this, OperandoActivity.class);
                operaciones.putExtra("operando","division");
                operaciones.putExtra("puntos",puntosTotales);
                startActivity(operaciones);

            }
        });

        multiplicacion = (ImageButton) findViewById(R.id.button_multiplicacion);
        multiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent operaciones = new Intent(MainActivity.this, OperandoActivity.class);
                operaciones.putExtra("operando","multiplicacion");
                operaciones.putExtra("puntos",puntosTotales);
                startActivity(operaciones);

            }
        });

        salir = (Button) findViewById(R.id.button_salir);
        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); System.exit(0);
            }
        });
    }
}