package com.example.puzleinfantil;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private int contador1 = 0;
    private int contador2 = 0;
    private int contador3 = 0;

    ArrayList<String> puzles = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button pieza1 = findViewById(R.id.pieza1);
        final Button pieza2 = findViewById(R.id.pieza2);
        final Button pieza3 = findViewById(R.id.pieza3);
        final Button reiniciar  = findViewById(R.id.reiniciar);

        puzles.add("abeja");
        puzles.add("arana");
        puzles.add("caracol");
        puzles.add("mariquita");
        puzles.add("oruga");

        contador1 = (int) Math.floor(Math.random()*puzles.size());
        contador2 = (int) Math.floor(Math.random()*puzles.size());
        contador3 = (int) Math.floor(Math.random()*puzles.size());


        String imagen1 =  puzles.get(contador1).concat(String.valueOf(1));
        pieza1.setBackgroundResource(getResources().getIdentifier(imagen1, "drawable", getPackageName()));

        String imagen2 =  puzles.get(contador2).concat(String.valueOf(2));
        pieza2.setBackgroundResource(getResources().getIdentifier(imagen2, "drawable", getPackageName()));

        String imagen3 =  puzles.get(contador3).concat(String.valueOf(3));
        pieza3.setBackgroundResource(getResources().getIdentifier(imagen3, "drawable", getPackageName()));


        pieza1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador1++;

                if (contador1 > (puzles.size()-1)){
                    contador1 = 0;
                }
                if (contador2 > (puzles.size()-1)) {
                    contador2 = 0;
                }
                if (contador3 > (puzles.size()-1)) {
                    contador3 = 0;
                }

                String imagen1 =  puzles.get(contador1).concat(String.valueOf(1));

                pieza1.setBackgroundResource(getResources().getIdentifier(imagen1, "drawable", getPackageName()));

                if (contador1 == contador2 && contador2 == contador3 && contador1 == contador3){
                    pieza1.setEnabled(false);
                    pieza2.setEnabled(false);
                    pieza3.setEnabled(false);

                    Toast gana =
                            Toast.makeText(getApplicationContext(),
                                    "¡HAS GANADO!", Toast.LENGTH_LONG);
                    gana.show();
                }
            }
        });

        pieza2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador2++;

                if (contador1 > (puzles.size()-1)){
                    contador1 = 0;
                }
                if (contador2 > (puzles.size()-1)) {
                    contador2 = 0;
                }
                if (contador3 > (puzles.size()-1)) {
                    contador3 = 0;
                }

                String imagen2 =  puzles.get(contador2).concat(String.valueOf(2));

                pieza2.setBackgroundResource(getResources().getIdentifier(imagen2, "drawable", getPackageName()));

                if (contador1 == contador2 && contador2 == contador3 && contador1 == contador3){
                    pieza1.setEnabled(false);
                    pieza2.setEnabled(false);
                    pieza3.setEnabled(false);

                    Toast gana =
                            Toast.makeText(getApplicationContext(),
                                    "Enhorabuena, ¡HAS GANADO!", Toast.LENGTH_LONG);

                    gana.show();
                }
            }
        });

        pieza3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador3++;

                if (contador1 > (puzles.size()-1)){
                    contador1 = 0;
                }
                if (contador2 > (puzles.size()-1)) {
                    contador2 = 0;
                }
                if (contador3 > (puzles.size()-1)) {
                    contador3 = 0;
                }

                String imagen3 =  puzles.get(contador3).concat(String.valueOf(3));

                pieza3.setBackgroundResource(getResources().getIdentifier(imagen3, "drawable", getPackageName()));

                if (contador1 == contador2 && contador2 == contador3 && contador1 == contador3){
                    pieza1.setEnabled(false);
                    pieza2.setEnabled(false);
                    pieza3.setEnabled(false);

                    Toast gana =
                            Toast.makeText(getApplicationContext(),
                                    "¡HAS GANADO!", Toast.LENGTH_LONG);

                    gana.show();

                }
            }
        });

        reiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                overridePendingTransition(0, 0);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                finish();
                overridePendingTransition(0, 0);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }
}