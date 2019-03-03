package com.company.LN;

public class clsVideojuegos extends clsArticulo {

    public clsVideojuegos(int puntuacion, int pegiVideojuegos) {
        this.puntuacion = puntuacion;
        this.pegiVideojuegos = pegiVideojuegos;
    }

    //Atributos principales de la clase clsVideojuegos
    private int puntuacion;
    private int pegiVideojuegos;

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public int getPegiVideojuegos() {
        return pegiVideojuegos;
    }

    public void setPegiVideojuegos(int pegiVideojuegos) {
        this.pegiVideojuegos = pegiVideojuegos;
    }
}
