package com.company.LN;

import com.company.COMUN.itfProperty;

import java.util.Date;

import static com.company.COMUN.clsConstantes.*;

public class clsAlquilarVideojuegos extends clsAlquiler implements itfProperty {

    private int videojuego_id;
    private Date videojuegos_fechaDevV;


    public int getVideojuego_id() {
        return videojuego_id;
    }

    public void setVideojuego_id(int videojuego_id) {
        this.videojuego_id = videojuego_id;
    }

    public Date getVideojuegos_fechaDevP() {
        return videojuegos_fechaDevV;
    }

    public void setVideojuegos_fechaDevP(Date videojuegos_fechaDevP) {
        this.videojuegos_fechaDevV = videojuegos_fechaDevP;
    }

    public clsAlquilarVideojuegos(int idAlquiler, int usuarios_codigo, int videojuego_id, Date videojuegos_fechaDevP) {
        super(idAlquiler, usuarios_codigo);
        this.videojuego_id = videojuego_id;
        this.videojuegos_fechaDevV = videojuegos_fechaDevP;
    }

    public clsAlquilarVideojuegos( int usuarios_codigo, int videojuego_id, Date videojuegos_fechaDevP) {
        super(usuarios_codigo);
        this.videojuego_id = videojuego_id;
        this.videojuegos_fechaDevV = videojuegos_fechaDevP;
    }


    public clsAlquilarVideojuegos() {
    }

    @Override
    public Object getPropertyU(String objPropiedad) {
        return null;
    }

    @Override
    public Object getPropertyA(String obj_Propiedad) {

        switch (obj_Propiedad) {

            case ALQUILER_VIDEOJUEGO_ID:
                return this.getIdAlquiler();
            case ALQUILER_VIDEOJUEGO_USUARIOS_CODIGO:
                return this.getUsuarios_codigo();
            case ALQUILER_VIDEOJUEGO_ID_PROPIA:
                return this.getVideojuego_id();
            case ALQUILER_VIDEOJUEGO_FECHADEV:
                return this.getVideojuegos_fechaDevP();
        }
        return null;
    }
}
