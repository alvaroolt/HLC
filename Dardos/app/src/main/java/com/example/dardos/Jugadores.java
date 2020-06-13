package com.example.dardos;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Jugadores extends AppCompatActivity {
    private int totalPuntos1 = 301;
    private int totalPuntos2 = 301;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jugadores);

        final TextView textJugador1 = findViewById(R.id.textJugador1);
        final TextView textJugador2 = findViewById(R.id.textJugador2);
        final TextView puntos1 = findViewById(R.id.puntos1);
        final TextView puntos2 = findViewById(R.id.puntos2);


        Button jugador1 = findViewById(R.id.jugador1);
        Button jugador2 = findViewById(R.id.jugador2);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras != null) {

            String puntaje1 = getIntent().getStringExtra("puntos1");
            String puntaje2 = getIntent().getStringExtra("puntos2");

            assert puntaje1 != null;
            totalPuntos1 = Integer.parseInt(puntaje1);

            assert puntaje2 != null;
            totalPuntos2 = Integer.parseInt(puntaje2);
        }
        puntos1.setText(Integer.toString(totalPuntos1));
        puntos2.setText(Integer.toString(totalPuntos2));


        if (totalPuntos1 == 0){
            new AlertDialog.Builder(Jugadores.this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Gana la Partida el jugador 1")
                    .setMessage("¿Quieres iniciar otra partida?")
                    .setPositiveButton("Si", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            puntos1.setText(Integer.toString(301));
                            puntos2.setText(Integer.toString(301));
                        }

                    })
                    .setNegativeButton("No", null)
                    .show();
        }

        if (totalPuntos1 < 0){
            new AlertDialog.Builder(Jugadores.this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Pierde la Partida el jugador 1")
                    .setMessage("¿Quieres iniciar otra partida?")
                    .setPositiveButton("Si", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            puntos1.setText(Integer.toString(301));
                            puntos2.setText(Integer.toString(301));
                        }

                    })
                    .setNegativeButton("No", null)
                    .show();
        }

        if (totalPuntos2 == 0){
            new AlertDialog.Builder(Jugadores.this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Gana la Partida el jugador 2")
                    .setMessage("¿Quieres iniciar otra partida?")
                    .setPositiveButton("Si", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            puntos1.setText(Integer.toString(301));
                            puntos2.setText(Integer.toString(301));
                        }

                    })
                    .setNegativeButton("No", null)
                    .show();
        }

        if (totalPuntos2 < 0){
            new AlertDialog.Builder(Jugadores.this)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setTitle("Pierde la Partida el jugador2")
                    .setMessage("¿Quieres iniciar otra partida?")
                    .setPositiveButton("Si", new DialogInterface.OnClickListener()
                    {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            puntos1.setText(Integer.toString(301));
                            puntos2.setText(Integer.toString(301));
                        }

                    })
                    .setNegativeButton("No", null)
                    .show();
        }

        jugador1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Jugadores.this, MainActivity.class);

                myIntent.putExtra("jugador", textJugador1.getText().toString());
                myIntent.putExtra("puntos1", puntos1.getText().toString());
                myIntent.putExtra("puntos2", puntos2.getText().toString());
                startActivity(myIntent);
            }

        });

        jugador2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Jugadores.this, MainActivity.class);

                myIntent.putExtra("jugador", textJugador2.getText().toString());
                myIntent.putExtra("puntos1", puntos1.getText().toString());
                myIntent.putExtra("puntos2", puntos2.getText().toString());
                startActivity(myIntent);
                finish();
            }

        });
    }
}