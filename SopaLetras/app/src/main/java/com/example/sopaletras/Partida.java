package com.example.sopaletras;

import java.util.ArrayList;

public class Partida {

    private ArrayList<ArrayList<String>> tablero;

    // ancho del tablero
    private int ancho = 10;

    // alto del tablero
    private int alto = 10;

    private int filaAlmacenada;
    private int columnaAlmacenada;

    // número de aciertos para ganar la partida
    public int aciertosTotales = 5;

    private ArrayList<Palabra> arrayPalabras = new ArrayList<>();

    public Partida(){
        tablero = new ArrayList<>();
        for(int i = 0; i<this.alto; i++){
            this.tablero.add(new ArrayList<String>());
            for(int j = 0; j<this.ancho; j++){
                this.tablero.get(i).add("#");
            }
        }
        generarTablero();
    }

    private void generarTablero(){
        boolean noValido;
        int contador = 5;
        ArrayList<String> arrayPalabrasRepetidas = new ArrayList<>();
        arrayPalabrasRepetidas.add("XXXXXXX");
        do{
            Palabra palabra;
            do{
                noValido = false;

                palabra = new Palabra();

                for(String pal : arrayPalabrasRepetidas){
                    if (pal.equals(palabra.palabra)) {
                        noValido = true;
                        break;
                    }
                }

                if(!noValido){
                    for(int i = 0; i< palabra.arrayPalabra.length; i++){
                        if(palabra.fila < 0 || palabra.columna <0 || palabra.fila>=alto || palabra.columna>=ancho){
                            noValido = true;
                        }else{
                            if(!this.tablero.get(palabra.fila).get(palabra.columna).equals("#")){
                                if(!this.tablero.get(palabra.fila).get(palabra.columna).equals(palabra.arrayPalabra[i])){
                                    noValido = true;
                                }
                            }
                        }
                        palabra.calcularSentido();
                    }
                }
            }while(noValido);
            arrayPalabrasRepetidas.add(palabra.palabra);
            actualizarTablero(palabra);
            contador--;
        }while(contador != 0);
    }

    private void actualizarTablero(Palabra palabra){
        palabra.revertirPalabra();
        for(int i = 0; i< palabra.arrayPalabra.length; i++){
            this.tablero.get(palabra.fila).set(palabra.columna, palabra.arrayPalabra[i]);
            palabra.calcularSentido();
        }
        palabra.retrocederSentido();
        this.arrayPalabras.add(palabra);
    }

    private void actualizarTableroEncontrado(Palabra palabra){
        palabra.revertirPalabra();
        for(int i = 0; i< palabra.arrayPalabra.length; i++){
            this.tablero.get(palabra.fila).set(palabra.columna, palabra.arrayPalabra[i]+"*");
            palabra.calcularSentido();
        }
        this.aciertosTotales--;
    }

    public void setAlmacenado(int x, int y){
        this.filaAlmacenada = x;
        this.columnaAlmacenada = y;
    }

    public boolean comprobarSeleccion(int x, int y){
        if(x != this.filaAlmacenada || y != this.columnaAlmacenada){
            Palabra coincidePalabra = new Palabra();
            boolean encontrado = false;
            for(Palabra palabra: this.arrayPalabras){
                if(palabra.filaInicial == this.filaAlmacenada){
                    if(palabra.columnaInicial == this.columnaAlmacenada){
                        coincidePalabra = palabra;
                        encontrado = true;
                    }
                }
                if(palabra.fila == this.filaAlmacenada){
                    if(palabra.columna == this.columnaAlmacenada){
                        coincidePalabra = palabra;
                        encontrado = true;
                    }
                }
            }

            if(encontrado){
                for(Palabra palabra: this.arrayPalabras){
                    if(palabra.filaInicial == x){
                        if(palabra.columnaInicial == y){
                            if(coincidePalabra.palabra.equals(palabra.palabra)){
                                actualizarTableroEncontrado(palabra);
                                return true;
                            }

                        }
                    }if(palabra.fila == x){
                        if(palabra.columna == y){
                            if(coincidePalabra.palabra.equals(palabra.palabra)){
                                actualizarTableroEncontrado(palabra);
                                return true;
                            }

                        }
                    }
                }
            }

        }
        return false;
    }

    public ArrayList<ArrayList<String>> getTablero(){
        return this.tablero;
    }



}