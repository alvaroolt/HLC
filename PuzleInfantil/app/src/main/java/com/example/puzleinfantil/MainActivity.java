package com.example.puzleinfantil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private int valor1 = 0;
    private int valor2 = 0;
    private int valor3 = 0;

    ArrayList<String> puzzle = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button pieza1 = findViewById(R.id.pieza1);
        final Button pieza2 = findViewById(R.id.pieza2);
        final Button pieza3 = findViewById(R.id.pieza3);
        final Button reiniciar  = findViewById(R.id.buttonReiniciar);

        puzzle.add("arana");
        puzzle.add("abeja");
        puzzle.add("oruga");
        puzzle.add("mariquita");
        puzzle.add("caracol");

        // recogen un valor entero aleatorio entre 0 y el tamaño de puzles (arraylist) para elegir la pieza inicial que muestra
        valor1 = (int) Math.floor(Math.random()* puzzle.size());
        valor2 = (int) Math.floor(Math.random()* puzzle.size());
        valor3 = (int) Math.floor(Math.random()* puzzle.size());


        String imagenpuzle1 =  puzzle.get(valor1).concat(String.valueOf(1));
        pieza1.setBackgroundResource(getResources().getIdentifier(imagenpuzle1, "drawable", getPackageName()));

        String imagenpuzle2 =  puzzle.get(valor2).concat(String.valueOf(2));
        pieza2.setBackgroundResource(getResources().getIdentifier(imagenpuzle2, "drawable", getPackageName()));

        String imagenpuzle3 =  puzzle.get(valor3).concat(String.valueOf(3));
        pieza3.setBackgroundResource(getResources().getIdentifier(imagenpuzle3, "drawable", getPackageName()));

        final String mensajeGanador = "Has ganado";

        pieza1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valor1++;

                //si el usuario pincha en la imagen y llega hasta el final, de esta manera consigo que vuelva al inicio del array
                if (valor1 > (puzzle.size()-1)){
                    valor1 = 0;
                }
                if (valor2 > (puzzle.size()-1)) {
                    valor2 = 0;
                }
                if (valor3 > (puzzle.size()-1)) {
                    valor3 = 0;
                }

                // uno el nombre de la pieza junto a su numero, para que me de el nombre del archivo jpg correcto
                String imagen1 =  puzzle.get(valor1).concat(String.valueOf(1));
                pieza1.setBackgroundResource(getResources().getIdentifier(imagen1, "drawable", getPackageName()));

                if (valor1 == valor2 && valor2 == valor3){
                    pieza1.setEnabled(false);
                    pieza2.setEnabled(false);
                    pieza3.setEnabled(false);

                    Toast ganar =
                            Toast.makeText(getApplicationContext(),
                                    mensajeGanador, Toast.LENGTH_LONG);
                    ganar.show();
                }
            }
        });

        pieza2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valor2++;

                //si el usuario pincha en la imagen y llega hasta el final, de esta manera consigo que vuelva al inicio del array
                if (valor1 > (puzzle.size()-1)){
                    valor1 = 0;
                }
                if (valor2 > (puzzle.size()-1)) {
                    valor2 = 0;
                }
                if (valor3 > (puzzle.size()-1)) {
                    valor3 = 0;
                }

                // uno el nombre de la pieza junto a su numero, para que me de el nombre del archivo jpg correcto
                String imagen2 =  puzzle.get(valor2).concat(String.valueOf(2));
                pieza2.setBackgroundResource(getResources().getIdentifier(imagen2, "drawable", getPackageName()));

                if (valor1 == valor2 && valor2 == valor3){
                    pieza1.setEnabled(false);
                    pieza2.setEnabled(false);
                    pieza3.setEnabled(false);

                    Toast ganar =
                            Toast.makeText(getApplicationContext(),
                                    mensajeGanador, Toast.LENGTH_LONG);

                    ganar.show();
                }
            }
        });


        pieza3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                valor3++;

                //si el usuario pincha en la imagen y llega hasta el final, de esta manera consigo que vuelva al inicio del array
                if (valor1 > (puzzle.size()-1)){
                    valor1 = 0;
                }
                if (valor2 > (puzzle.size()-1)) {
                    valor2 = 0;
                }
                if (valor3 > (puzzle.size()-1)) {
                    valor3 = 0;
                }

                // uno el nombre de la pieza junto a su numero, para que me de el nombre del archivo jpg correcto
                String imagen3 =  puzzle.get(valor3).concat(String.valueOf(3));
                pieza3.setBackgroundResource(getResources().getIdentifier(imagen3, "drawable", getPackageName()));

                if (valor1 == valor2 && valor2 == valor3){
                    pieza1.setEnabled(false);
                    pieza2.setEnabled(false);
                    pieza3.setEnabled(false);

                    Toast ganar =
                            Toast.makeText(getApplicationContext(),
                                    mensajeGanador, Toast.LENGTH_LONG);

                    ganar.show();

                }
            }
        });

    }

    public static void reiniciarActivity(Activity actividad){
        Intent intent=new Intent();
        intent.setClass(actividad, actividad.getClass());
        actividad.startActivity(intent);
        actividad.finish();
    }

    public void onClick_buttonReiniciar(View v){
        reiniciarActivity(this);
    }
}