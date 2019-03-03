package com.company.LN;

public class clsPeliculas extends clsArticulo {

    public clsPeliculas(int pegi, int puntuacion) {
        this.pegi = pegi;
        this.puntuacion = puntuacion;
    }

    //Atributos principales de la clase clsPeliculas
    private int pegi;
    private int puntuacion;

    public int getPegi() {
        return pegi;
    }

    public void setPegi(int pegi) {
        this.pegi = pegi;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

}
