package com.company.LN;

import com.company.COMUN.itfProperty;

import java.util.Date;

import static com.company.COMUN.clsConstantes.*;

/**
 * Clase par los objetos alquiler de tipo videojuegos
 */
public class clsAlquilarVideojuegos extends clsAlquiler implements itfProperty {

    private int videojuego_id;
    private Date fecha_DevolucionV;


    public int getVideojuego_id() {
        return videojuego_id;
    }

    public void setVideojuego_id(int videojuego_id) {
        this.videojuego_id = videojuego_id;
    }

    public Date getFecha_DevolucionV() {
        return fecha_DevolucionV;
    }

    public void setFecha_DevolucionV(Date fecha_DevolucionV) {
        this.fecha_DevolucionV = fecha_DevolucionV;
    }

    public clsAlquilarVideojuegos(int idAlquiler, int usuarios_codigo, int videojuego_id, Date fecha_DevolucionV) {
        super(idAlquiler, usuarios_codigo);
        this.videojuego_id = videojuego_id;
        this.fecha_DevolucionV = fecha_DevolucionV;
    }

    public clsAlquilarVideojuegos( int usuarios_codigo, int videojuego_id, Date fecha_DevolucionV) {
        super(usuarios_codigo);
        this.videojuego_id = videojuego_id;
        this.fecha_DevolucionV = fecha_DevolucionV;
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
                return this.getFecha_DevolucionV();
        }
        return null;
    }
}
