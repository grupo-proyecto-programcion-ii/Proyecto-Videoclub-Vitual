package com.company.LN;

import java.util.Date;

/**
 * Clase que alberga atributos para alquilar peliculas además de sus método
 */

public class clsAlquilarPeliculas {

    private int usuarios_codigo;
    private int peliculas_id;
    private Date peliculas_fechaDevP;

    public int getUsuarios_codigo() {
        return usuarios_codigo;
    }

    public void setUsuarios_codigo(int usuarios_codigo) {
        this.usuarios_codigo = usuarios_codigo;
    }

    public int getPeliculas_id() {
        return peliculas_id;
    }

    public void setPeliculas_id(int peliculas_id) {
        this.peliculas_id = peliculas_id;
    }

    public Date getPeliculas_fechaDevP() {
        return peliculas_fechaDevP;
    }

    public void setPeliculas_fechaDevP(Date peliculas_fechaDevP) {
        this.peliculas_fechaDevP = peliculas_fechaDevP;
    }

    public clsAlquilarPeliculas(int codigo, int id, Date fechaDev) {
        this.usuarios_codigo = codigo;
        this.peliculas_id = id;
        this.peliculas_fechaDevP = fechaDev;
    }

    public clsAlquilarPeliculas(){

    }
}
