package com.example.sopaletras;

import java.util.Random;

public class Palabra {

    public int fila;
    public int columna;
    public int filaInicial;
    public int columnaInicial;
    
    public int sentido;
    public String[] arrayPalabra;
    public String palabra;
    public static String[] arrayPalabras;

    public Palabra(){
        Random numAleatorio = new Random();
        this.palabra = arrayPalabras[numAleatorio.nextInt(arrayPalabras.length)];

        // array de las letras de la palabra, separadas
        this.arrayPalabra = this.palabra.split("");

        // coordenada x en el eje cartesiano
        this.fila = numAleatorio.nextInt(10);

        // coordenada y en el eje cartesiano
        this.columna = numAleatorio.nextInt(10);

        // fila donde comienza la palabra en el tablero
        this.filaInicial = this.fila;

        // columna donde comienza la palabra en el tablero
        this.columnaInicial = this.columna;

        // asigna un valor que se corresponde al sentido y dirección de la palabra
        this.sentido = numAleatorio.nextInt(arrayPalabras.length);
    }
    public void calcularSentido(){
        switch (this.sentido) {
            case 0:
                //Si la direccion es 0, el orden de la palabra es de abajo a arriba
                this.fila -= 1;
                break;
            case 1:
                //Si la direccion es 1, el orden de la palabra es de izquierda a derecha
                this.columna += 1;
                break;
            case 2:
                //Si la direccion es 2, el orden de la palabra es de arriba a abajo
                this.fila += 1;
                break;
            case 3:
                //Si la direccion es 3, el orden de la palabra es de derecha a izquierda
                this.columna -= 1;
                break;
            case 4:
                //Si la direccion es 4, el orden de la palabra es de abajo izquierda a arriba derecha
                this.fila -= 1;
                this.columna += 1;
                break;
            case 5:
                //Si la direccion es 5, el orden de la palabra es de abajo derecha a arriba izquierda
                this.fila -= 1;
                this.columna -= 1;
                break;
            case 6:
                //Si la direccion es 6, el orden de la palabra es de arriba izquierda a abajo derecha
                this.fila += 1;
                this.columna += 1;
                break;
            case 7:
                //Si la direccion es 7, el orden de la palabra es de arriba drecha a abajo izquierda
                this.fila += 1;
                this.columna -= 1;
                break;
        }
    }

    public void retrocederSentido(){
        switch (this.sentido) {
            case 0:
                //Si la direccion es 0, el orden de la palabra es de abajo a arriba
                this.fila += 1;
                break;
            case 1:
                //Si la direccion es 1, el orden de la palabra es de izquierda a derecha
                this.columna -= 1;
                break;
            case 2:
                //Si la direccion es 2, el orden de la palabra es de arriba a abajo
                this.fila -= 1;
                break;
            case 3:
                //Si la direccion es 3, el orden de la palabra es de derecha a izquierda
                this.columna += 1;
                break;
            case 4:
                //Si la direccion es 4, el orden de la palabra es de abajo izquierda a arriba derecha
                this.fila += 1;
                this.columna -= 1;
                break;
            case 5:
                //Si la direccion es 5, el orden de la palabra es de abajo derecha a arriba izquierda
                this.fila += 1;
                this.columna += 1;
                break;
            case 6:
                //Si la direccion es 6, el orden de la palabra es de arriba izquierda a abajo derecha
                this.fila -= 1;
                this.columna -= 1;
                break;
            case 7:
                //Si la direccion es 7, el orden de la palabra es de arriba drecha a abajo izquierda
                this.fila -= 1;
                this.columna += 1;
                break;
        }
    }

    public void revertirPalabra(){
        this.fila = this.filaInicial;
        this.columna = this.columnaInicial;
    }

    public static void setArrayPalabras(String aP){
        arrayPalabras = aP.split(",");
    }

}