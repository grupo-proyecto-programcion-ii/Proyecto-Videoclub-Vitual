package com.company.LN;

/**
 *Todas las clases de objetos reciben Herencia de la clase clsArticulo,ya que todos
 * tienen los mismos atributos en común.
 */

public class clsArticulo {

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






}
