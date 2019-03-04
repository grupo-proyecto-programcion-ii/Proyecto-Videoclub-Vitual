package com.company.LN;

import java.util.ArrayList;

/**
 *Todas las clases de objetos reciben Herencia de la clase clsArticulo,ya que todos
 * tienen los mismos atributos en común.
 */

public class clsArticulo {

    private ArrayList<clsVideojuegos> listaVideojuegos = new ArrayList<clsVideojuegos>();
    private ArrayList<clsMusica_CD> listaMusica = new ArrayList<clsMusica_CD>();
    private ArrayList<clsPeliculas> listaPeliculas = new ArrayList<clsPeliculas>();

    private int indentificador;
    private double precio;
    private double duracion;

    public int getIndentificador() {
        return indentificador;
    }

    public void setIndentificador(int indentificador) {
        this.indentificador = indentificador;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public void anadirVidejuegos(int punt, int pegiV){

        clsVideojuegos objVidejuego = new clsVideojuegos(punt, pegiV);
        listaVideojuegos.add(objVidejuego);
    }

    public ArrayList<clsVideojuegos> leerVidejuegos(){
        return listaVideojuegos;
    }

}
