package com.example.dardos;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int puntos = 0;
    private int totalPuntos = 0;
    private Button aceptar;
    private Button btndoble;
    private Button btntriple;
    private TextView marcador;
    private TextView jugador;
    private int multiplicador = 1;
    private String jugadorActual="";
    private int puntos1 = 0;
    private int puntos2 = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String nombre = getIntent().getStringExtra("jugador");
        final String puntaje1 = getIntent().getStringExtra("puntos1");
        final String puntaje2 = getIntent().getStringExtra("puntos2");

        marcador = (TextView) findViewById(R.id.puntos);
        jugador = (TextView) findViewById(R.id.jugador);
        jugadorActual = nombre;

        if (jugadorActual.contains("1")) {
            totalPuntos = Integer.parseInt(puntaje1);
            marcador.setText(puntaje1);
            puntos2 = Integer.parseInt(puntaje2);
        } else {
            totalPuntos = Integer.parseInt(puntaje2);
            marcador.setText(puntaje2);
            puntos1 = Integer.parseInt(puntaje1);
        }


        jugador.setText(nombre);


        aceptar = (Button) findViewById(R.id.aceptar);
        btndoble = (Button) findViewById(R.id.btndoble);
        btntriple = (Button) findViewById(R.id.btntriple);

        Button uno = (Button) findViewById(R.id.btn1);
        Button dos = (Button) findViewById(R.id.btn2);
        Button tres = (Button) findViewById(R.id.btn3);
        Button cuatro = (Button) findViewById(R.id.btn4);
        Button cinco = (Button) findViewById(R.id.btn5);
        Button seis = (Button) findViewById(R.id.btn6);
        Button siete = (Button) findViewById(R.id.btn7);
        Button ocho = (Button) findViewById(R.id.btn8);
        Button nueve = (Button) findViewById(R.id.btn9);
        Button diez = (Button) findViewById(R.id.btn10);
        Button once = (Button) findViewById(R.id.btn11);
        Button doce = (Button) findViewById(R.id.btn12);
        Button trece = (Button) findViewById(R.id.btn13);
        Button catorce = (Button) findViewById(R.id.btn14);
        Button quince = (Button) findViewById(R.id.btn15);
        Button dieciseis = (Button) findViewById(R.id.btn16);
        Button diecisiete = (Button) findViewById(R.id.btn17);
        Button dieciocho = (Button) findViewById(R.id.btn18);
        Button diecinueve = (Button) findViewById(R.id.btn19);
        Button veinte = (Button) findViewById(R.id.btn20);
        Button veinticinco = (Button) findViewById(R.id.btn25);
        Button cincuenta = (Button) findViewById(R.id.btn50);



        uno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                puntos = 1;
            }
        });
        dos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                puntos = 2;
            }
        });
        tres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                puntos = 3;
            }
        });
        cuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                puntos = 4;
            }
        });
        cinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                puntos = 5;
            }
        });
        seis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                puntos = 6;
            }
        });
        siete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                puntos = 7;
            }
        });
        ocho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                puntos = 8;
            }
        });
        nueve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                puntos = 9;
            }
        });
        diez.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                puntos = 10;
            }
        });
        once.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                puntos = 11;
            }
        });
        doce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                puntos = 12;
            }
        });
        trece.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                puntos = 13;
            }
        });
        catorce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                puntos = 14;
            }
        });
        quince.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                puntos = 15;
            }
        });
        dieciseis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                puntos = 16;
            }
        });
        diecisiete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                puntos = 17;
            }
        });
        dieciocho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                puntos = 18;
            }
        });
        diecinueve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                puntos = 19;
            }
        });
        veinte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                puntos = 20;
            }
        });
        veinticinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                puntos = 25;
            }
        });
        cincuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                puntos = 50;
            }
        });

        btndoble.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (multiplicador == 2) {
                    multiplicador = 1;
                    btndoble.setBackgroundColor(0xFFFFFFFF);
                    btntriple.setBackgroundColor(0xFFFFFFFF);
                }else{
                    multiplicador = 2;
                    btndoble.setBackgroundColor(0xFFFF0000);
                    btntriple.setBackgroundColor(0xFFFFFFFF);
                }
            }
        });

        btntriple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (multiplicador == 3) {
                    multiplicador = 1;
                    btntriple.setBackgroundColor(0xFFFFFFFF);
                    btndoble.setBackgroundColor(0xFFFFFFFF);
                }else{
                    multiplicador = 3;
                    btntriple.setBackgroundColor(0xFFFF0000);
                    btndoble.setBackgroundColor(0xFFFFFFFF);
                }
            }
        });

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                totalPuntos = Integer.parseInt(marcador.getText().toString());
                totalPuntos = totalPuntos-(puntos*multiplicador);
                marcador.setText(Integer.toString(totalPuntos));

                if (jugadorActual.contains("1")) {
                    Intent myIntent = new Intent(MainActivity.this, Jugadores.class);
                    myIntent.putExtra("puntos1", Integer.toString(totalPuntos));
                    myIntent.putExtra("puntos2", Integer.toString(puntos2));
                    startActivity(myIntent);
                    finish();
                }else{
                    Intent myIntent = new Intent(MainActivity.this, Jugadores.class);
                    myIntent.putExtra("puntos1", Integer.toString(puntos1));
                    myIntent.putExtra("puntos2", Integer.toString(totalPuntos));
                    startActivity(myIntent);
                    finish();
                }
            }
        });
    }


}