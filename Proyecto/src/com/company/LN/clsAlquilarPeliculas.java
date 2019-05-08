package com.company.LN;

import com.company.COMUN.itfProperty;

import java.util.Date;

import static com.company.COMUN.clsConstantes.*;

/**
 * Clase que alberga atributos para alquilar peliculas además de sus método
 */

public class clsAlquilarPeliculas implements itfProperty {

    private int idAlquiler;
    private int usuarios_codigo;
    private int peliculas_id;
    private Date peliculas_fechaDevP;

    public int getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(int idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

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


    public clsAlquilarPeliculas(int idAlquiler, int usuarios_codigo, int peliculas_id, Date peliculas_fechaDevP) {
        this.idAlquiler = idAlquiler;
        this.usuarios_codigo = usuarios_codigo;
        this.peliculas_id = peliculas_id;
        this.peliculas_fechaDevP = peliculas_fechaDevP;
    }


    public clsAlquilarPeliculas(int codigo, int id, Date fechaDev) {
        this.usuarios_codigo = codigo;
        this.peliculas_id = id;
        this.peliculas_fechaDevP = fechaDev;
    }

    public clsAlquilarPeliculas() {

    }

    @Override
    public Object getPropertyU(String objPropiedad) {

        return null;
    }

    @Override
    public Object getPropertyA(String obj_Propiedad) {
        switch (obj_Propiedad) {

            case ALQUILER_PELICULA_ID:
                return this.getIdAlquiler();
            case ALQUILER_PELICULA_USUARIOS_CODIGO:
                return this.getUsuarios_codigo();
            case ALQUILER_PELICULA_ID_PROPIA:
                return this.getPeliculas_id();
            case ALQUILER_PELICULA_FECHADEV:
                return this.getPeliculas_fechaDevP();
        }
        return null;
    }
}
