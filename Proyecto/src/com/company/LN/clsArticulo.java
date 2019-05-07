package com.company.LN;

import com.company.COMUN.itfProperty;

import java.util.Date;

/**
 * Todas las clases de objetos reciben Herencia de la clase clsArticulo, ya que todos
 * tienen los mismos atributos en comun.
 */

public class clsArticulo implements itfProperty, Comparable<clsArticulo> {

    private int id;
    private Date fechaDev;
    private String nombre;
    private double precio;
    private double duracion;

    public clsArticulo(int id, Date fechaDev, String nombre, double precio, double duracion) {

        this.id = id;
        this.fechaDev = fechaDev;
        this.nombre = nombre;
        this.precio = precio;
        this.duracion = duracion;

    }

    public clsArticulo(Date fechaDev ,String nombre, double precio, double duracion) {

        this.fechaDev = fechaDev;
        this.nombre = nombre;
        this.precio = precio;
        this.duracion = duracion;

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

    public Date getFechaDev() {
        return fechaDev;
    }

    public void setFechaDev(Date fechaDev) {
        this.fechaDev = fechaDev;
    }

    @Override
    public Object getPropertyU(String objPropiedad) {
        return null;
    }

    @Override
    public Object getPropertyA(String obj_Propiedad) {
        return null;
    }

    @Override
    public int compareTo(clsArticulo o) {
        return this.nombre.compareTo(o.nombre);
    }
}