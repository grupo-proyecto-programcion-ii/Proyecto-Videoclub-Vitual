package com.company.LN;

import com.company.COMUN.itfProperty;

/**
 * Todas las clases de objetos reciben Herencia de la clase clsArticulo, ya que todos
 * tienen los mismos atributos en comun.
 */

public abstract class clsArticulo implements itfProperty {

    private int id;
    private String nombre;
    private double precio;
    private double duracion;

    public clsArticulo(int id, String nombre, double precio, double duracion) {

        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.duracion = duracion;
    }

    public clsArticulo(String nombreP, double precioP, double duracionP) {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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