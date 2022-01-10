package com.keniaruiz.juegoaritmetica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class OperandoActivity extends AppCompatActivity {

    private TextView resultado,operando1,operando2,operando, puntuacion, titulo;
    private Button uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, cero, borrar, revisar, regresar;
    private String puntosTotales="0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operando);

        resultado = (TextView) findViewById(R.id.text_resultado);
        operando1 = (TextView) findViewById(R.id.text_operando1);
        operando2 = (TextView) findViewById(R.id.text_operando2);
        operando = (TextView) findViewById(R.id.text_operando);
        puntuacion = (TextView) findViewById(R.id.text_puntos);
        titulo = (TextView) findViewById(R.id.text_titulo);

        updatePuntos();

        String op = getIntent().getStringExtra("operando");

        switch(op) {
            case "suma":
                titulo.setText(R.string.title_operacion_s);
                operando.setText(R.string.operando_s);
                updateNumeros();
                break;

            case "resta":
                titulo.setText(R.string.title_operacion_r);
                operando.setText(R.string.operando_r);
                updateNumerosR();
                break;

            case "division":
                titulo.setText(R.string.title_operacion_d);
                operando.setText(R.string.operando_d);
                updateNumerosD();
                break;
            case "multiplicacion":
                titulo.setText(R.string.title_operacion_m);
                operando.setText(R.string.operando_m);
                updateNumeros();
                break;
        }

        uno = (Button) findViewById(R.id.button_uno);
        uno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultado.getText().toString().isEmpty()) {
                    resultado.setText("1");
                } else {
                    resultado.setText(resultado.getText().toString() + "1");
                }
            }
        });

        dos = (Button) findViewById(R.id.button_dos);
        dos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultado.getText().toString().isEmpty()) {
                    resultado.setText("2");
                } else {
                    resultado.setText(resultado.getText().toString() + "2");
                }
            }
        });

        tres = (Button) findViewById(R.id.button_tres);
        tres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultado.getText().toString().isEmpty()) {
                    resultado.setText("3");
                } else {
                    resultado.setText(resultado.getText().toString() + "3");
                }
            }
        });

        cuatro = (Button) findViewById(R.id.button_cuatro);
        cuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultado.getText().toString().isEmpty()) {
                    resultado.setText("4");
                } else {
                    resultado.setText(resultado.getText().toString() + "4");
                }
            }
        });

        cinco = (Button) findViewById(R.id.button_cinco);
        cinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultado.getText().toString().isEmpty()) {
                    resultado.setText("5");
                } else {
                    resultado.setText(resultado.getText().toString() + "5");
                }
            }
        });

        seis = (Button) findViewById(R.id.button_seis);
        seis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultado.getText().toString().isEmpty()) {
                    resultado.setText("6");
                } else {
                    resultado.setText(resultado.getText().toString() + "6");
                }
            }
        });

        siete = (Button) findViewById(R.id.button_siete);
        siete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultado.getText().toString().isEmpty()) {
                    resultado.setText("7");
                } else {
                    resultado.setText(resultado.getText().toString() + "7");
                }
            }
        });

        ocho = (Button) findViewById(R.id.button_ocho);
        ocho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultado.getText().toString().isEmpty()) {
                    resultado.setText("8");
                } else {
                    resultado.setText(resultado.getText().toString() + "8");
                }
            }
        });

        nueve = (Button) findViewById(R.id.button_nueve);
        nueve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultado.getText().toString().isEmpty()) {
                    resultado.setText("9");
                } else {
                    resultado.setText(resultado.getText().toString() + "9");
                }
            }
        });

        cero = (Button) findViewById(R.id.button_cero);
        cero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (resultado.getText().toString().isEmpty()) {
                    resultado.setText("0");
                } else {
                    resultado.setText(resultado.getText().toString() + "0");
                }
            }
        });

        borrar = (Button) findViewById(R.id.button_borrar);
        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = resultado.getText().toString();
                result = result.substring(0, result.length() - 1);
                resultado.setText(result);
            }
        });

        regresar = (Button) findViewById(R.id.button_regresar);
        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent operaciones = new Intent(OperandoActivity.this, MainActivity.class);
                operaciones.putExtra("puntos",puntuacion.getText().toString());
                startActivity(operaciones);
            }
        });

        revisar = (Button) findViewById(R.id.button_revisar);
        revisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String op = operando.getText().toString();
                int correcto=0;

                switch(op) {
                    case "+":
                        correcto = Integer.parseInt(operando1.getText().toString())+Integer.parseInt(operando2.getText().toString());
                        if (resultado.getText().toString().equals(String.valueOf(correcto))){
                            Toast.makeText(getApplicationContext(),
                                    "✓ Correcto" , Toast.LENGTH_SHORT).show();

                            updateNumeros();
                            updatePuntos();
                        }else{
                            Toast.makeText(getApplicationContext(),
                                    "X Incorrecto  la respuesta es: " + correcto , Toast.LENGTH_SHORT).show();
                            updateNumeros();
                        }
                        break;

                    case "-":
                        correcto = Integer.parseInt(operando1.getText().toString())-Integer.parseInt(operando2.getText().toString());
                        if (resultado.getText().toString().equals(String.valueOf(correcto))){
                            Toast.makeText(getApplicationContext(),
                                    " ✓ Correcto ", Toast.LENGTH_SHORT).show();
                            updateNumerosR();
                            updatePuntos();
                        }else{
                            Toast.makeText(getApplicationContext(),
                                    " X Incorrecto  la respuesta es: "+correcto , Toast.LENGTH_SHORT).show();
                            updateNumerosR();
                        }
                        break;

                    case "x":
                        correcto = Integer.parseInt(operando1.getText().toString())*Integer.parseInt(operando2.getText().toString());
                        if (resultado.getText().toString().equals(String.valueOf(correcto))){
                            Toast.makeText(getApplicationContext(),
                                    "✓ correcto  ", Toast.LENGTH_SHORT).show();
                            updateNumeros();
                            updatePuntos();
                        }else{
                            Toast.makeText(getApplicationContext(),
                                    "X Incorrecto  la respuesta es: "+correcto  , Toast.LENGTH_SHORT).show();
                            updateNumeros();
                        }
                        break;
                    case "÷":
                        correcto = Integer.parseInt(operando1.getText().toString())/Integer.parseInt(operando2.getText().toString());
                        if (resultado.getText().toString().equals(String.valueOf(correcto))){
                            Toast.makeText(getApplicationContext(),
                                    "✓ correcto  ", Toast.LENGTH_SHORT).show();
                            updateNumerosD();
                            updatePuntos();
                        }else{
                            Toast.makeText(getApplicationContext(),
                                    "X Incorrecto  la respuesta es: "+correcto  , Toast.LENGTH_SHORT).show();
                            updateNumerosD();
                        }
                        break;
                }
            }
        });

    }

    private void updateNumeros() {

        int var1 =(int)(Math.random()*9+1);
        int var2= (int)(Math.random()*9+1);

        operando1.setText(String.valueOf(var1));
        operando2.setText(String.valueOf(var2));

        resultado.setText("");

    }

    private void updateNumerosR() {

        int var1 =(int)(Math.random()*9+1);
        int var2= (int)(Math.random()*9+1);

        while ( var1<=var2) {

            var1 = (int) (Math.random() * 9 + 1);
            var2 = (int) (Math.random() * 9 + 1);
        }

        operando1.setText(String.valueOf(var1));
        operando2.setText(String.valueOf(var2));

        resultado.setText("");

    }

    private void updateNumerosD() {

        int var1 =(int) (Math.random()*9+1);
        int var2= (int) (Math.random()*9+1);

        while (var1%var2>0) {
            var1 =(int)(Math.random()*9+1);
            var2= (int)(Math.random()*9+1);
        }

        operando1.setText(String.valueOf(var1));
        operando2.setText(String.valueOf(var2));

        resultado.setText("");

    }

    private void updatePuntos() {
        int aux1;

        String puntos = getIntent().getStringExtra("puntos");

            if (puntuacion.getText().toString().equals("0")) {
                puntuacion.setText("5");
            } else {
                aux1 = Integer.parseInt(puntuacion.getText().toString());
                aux1= aux1+5;
                puntosTotales= String.valueOf(aux1);
                puntuacion.setText(puntosTotales);
            }

    }
}