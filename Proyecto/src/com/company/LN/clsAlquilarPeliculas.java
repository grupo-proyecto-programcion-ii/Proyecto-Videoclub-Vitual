package com.company.LN;

import com.company.COMUN.itfProperty;

import java.util.Date;

import static com.company.COMUN.clsConstantes.*;

/**
 * Clase que alberga atributos para alquilar peliculas además de sus método
 */

public class clsAlquilarPeliculas extends clsAlquiler implements itfProperty {

    private int peliculas_id;
    private Date fecha_DevolucionP;


    public int getPeliculas_id() {
        return peliculas_id;
    }

    public void setPeliculas_id(int peliculas_id) {
        this.peliculas_id = peliculas_id;
    }


    public Date getFecha_DevolucionP() {
        return fecha_DevolucionP;
    }

    public void setFecha_DevolucionP(Date fecha_DevolucionP) {
        this.fecha_DevolucionP = fecha_DevolucionP;
    }

    public clsAlquilarPeliculas(int idAlquiler, int usuarios_codigo, int peliculas_id, Date fecha_DevolucionP) {
        super(idAlquiler, usuarios_codigo);
        this.peliculas_id = peliculas_id;
        this.fecha_DevolucionP = fecha_DevolucionP;
    }

    public clsAlquilarPeliculas(int codigo, int peliculas_id, Date fecha_DevolucionP) {
        super(codigo);
        this.peliculas_id = peliculas_id;
        this.fecha_DevolucionP = fecha_DevolucionP;

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
                return this.getFecha_DevolucionP();
        }
        return null;
    }
}
