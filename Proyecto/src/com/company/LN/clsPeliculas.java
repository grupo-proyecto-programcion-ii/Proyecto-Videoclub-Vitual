package com.company.LN;

public class clsPeliculas extends clsArticulo {

    public clsPeliculas(){

    }

    public clsPeliculas(int _pegi, int _puntuacionP) {
        this.pegi = _pegi;
        this.puntuacionP = _puntuacionP;
    }

    //Atributos principales de la clase clsPeliculas
    private int pegi;
    private int puntuacionP;

    public int getPegi() {
        return pegi;
    }

    public void setPegi(int _pegi) {
        this.pegi = _pegi;
    }

    public int getPuntuacion() {
        return puntuacionP;
    }

    public void setPuntuacion(int _puntuacion) {
        this.puntuacionP = _puntuacion;
    }

}
