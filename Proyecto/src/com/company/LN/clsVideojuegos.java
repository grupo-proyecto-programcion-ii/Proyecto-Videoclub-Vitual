package com.company.LN;

public class clsVideojuegos extends clsArticulo {

    public clsVideojuegos(){

    }

    public clsVideojuegos(int puntuacionV, int pegiVideojuegos) {
        this.puntuacionV = puntuacionV;
        this.pegiVideojuegos = pegiVideojuegos;
    }

    //Atributos principales de la clase clsVideojuegos
    private int puntuacionV;
    private int pegiVideojuegos;

    public int getPuntuacion() {
        return puntuacionV;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacionV = puntuacion;
    }

    public int getPegiVideojuegos() {
        return pegiVideojuegos;
    }

    public void setPegiVideojuegos(int pegiVideojuegos) {
        this.pegiVideojuegos = pegiVideojuegos;
    }
}
