package com.example.sopaletras;

import java.util.Random;

public class Palabra {
    public int x;
    public int y;
    
    public int xInicial;
    public int yInicial;
    
    public int direccion;
    public String[] arrayPalabra;
    public String palabra;

    public static String[] arrayPalabras;

    public Palabra(){
        Random r = new Random();
        this.palabra = arrayPalabras[r.nextInt(arrayPalabras.length)];
        this.arrayPalabra = this.palabra.split("");
        this.x = r.nextInt(10);
        this.y = r.nextInt(10);
        this.xInicial = this.x;
        this.yInicial = this.y;
        this.direccion = r.nextInt(arrayPalabras.length);
    }
    public void calcularDireccion(){
        switch (this.direccion) {
            case 0:
                //Si la direccion es 0, el orden de la palabra es de abajo a arriba
                this.x -= 1;
                break;
            case 1:
                //Si la direccion es 0, el orden de la palabra es de izquierda a derecha
                this.y += 1;
                break;
            case 2:
                //Si la direccion es 0, el orden de la palabra es de arriba a abajo
                this.x += 1;
                break;
            case 3:
                //Si la direccion es 0, el orden de la palabra es de derecha a izquierda
                this.y -= 1;
                break;
            case 4:
                //Si la direccion es 0, el orden de la palabra es de abajo izquierda a arriba derecha
                this.x -= 1;
                this.y += 1;
                break;
            case 5:
                //Si la direccion es 0, el orden de la palabra es de abajo derecha a arriba izquierda
                this.x -= 1;
                this.y -= 1;
                break;
            case 6:
                //Si la direccion es 0, el orden de la palabra es de arriba izquierda a abajo derecha
                this.x += 1;
                this.y += 1;
                break;
            case 7:
                //Si la direccion es 0, el orden de la palabra es de arriba drecha a abajo izquierda
                this.x += 1;
                this.y -= 1;
                break;
        }
    }

    public void retrocederDireccion(){
        switch (this.direccion) {
            case 0:
                //Abajo arriba
                this.x += 1;
                break;
            case 1:
                //Izquierda derecha
                this.y -= 1;
                break;
            case 2:
                //Arriba abajo
                this.x -= 1;
                break;
            case 3:
                //Derecha izquierda
                this.y += 1;
                break;
            case 4:
                //Abajo izquierda - Arriba derecha
                this.x += 1;
                this.y -= 1;
                break;
            case 5:
                //Abajo derecha - Arriba izquierda
                this.x += 1;
                this.y += 1;
                break;
            case 6:
                //Arriba izquierda - Abajo derecha
                this.x -= 1;
                this.y -= 1;
                break;
            case 7:
                //Arriba derecha - Abajo izquierda
                this.x -= 1;
                this.y += 1;
                break;
        }
    }

    public void revertirPalabra(){
        this.x = this.xInicial;
        this.y = this.yInicial;
    }

    public static void setArrayPalabras(String aP){
        arrayPalabras = aP.split(",");
    }

}