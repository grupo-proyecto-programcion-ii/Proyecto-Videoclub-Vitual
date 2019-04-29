package com.company.LN;

import java.util.Date;
import static com.company.COMUN.clsConstantes.*;

/**
 * Clase que hereda del padre, siendo clsArticulo.
 */

public class clsVideojuegos extends clsArticulo {

    /**
     * Atributos geters y seter
     */
    private int puntuacionV;
    private int pegiVideojuegos;

    public int getPuntuacion() {
        return puntuacionV;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacionV = puntuacion;
    }

    public int getPegiVideojuegos() {
        return pegiVideojuegos;
    }

    public void setPegiVideojuegos(int pegiVideojuegos) {
        this.pegiVideojuegos = pegiVideojuegos;
    }

    /**
     * Contructor de clsVidejuegos que hereda 4 atributos de clsArticulo.
     * @param _idVidejuego atributo
     * @param _nombreV atributo
     * @param _precioV atributo
     * @param _duracionV atributo
     * @param puntuacionV atributo
     * @param pegiVideojuegos atributo
     */
    public clsVideojuegos(int _idVidejuego, Date _fechaDevV, String _nombreV, double _precioV, double _duracionV, int puntuacionV, int pegiVideojuegos) {

        super(_idVidejuego, _fechaDevV,_nombreV,  _precioV, _duracionV);
        this.puntuacionV = puntuacionV;
        this.pegiVideojuegos = pegiVideojuegos;
    }

    public clsVideojuegos(Date _fechaSV, String _nombreV, double _precioP, double _duracionP, int puntuacionV, int pegiVideojuegos) {

        super(_nombreV,  _precioP, _duracionP);
        this.puntuacionV = puntuacionV;
        this.pegiVideojuegos = pegiVideojuegos;
    }

    /**
     *Método para obtener los datos de los atributos de vidoejuegos.
     * @param obj_Propiedad objeto que tra la interfaz
     * @return valores a los atributos
     */
    @Override
    public Object getPropertyA(String obj_Propiedad) {

        switch (obj_Propiedad){
            case VIDEJUEGO_ID:
                return this.getId();
            case VIDEOJUEGO_FECHA_DEV:
                return this.getFechaDev();
            case VIDEOJUEGO_NOMBRE:
                return this.getNombre();
            case VIDEOJUEGO_PRECIO:
                return this.getPrecio();
            case VIDEOJUEGO_DURACION:
                return this.getDuracion();
            case VIDEOJUEGO_PUNTUACION:
                return this.puntuacionV;
            case VIDEOJUEGO_PEGI:
                return this.pegiVideojuegos;
        }
        return null;
    }

    /**
     * Métodos de la clase interfaz itfProperty
     * @param objPropiedad objeto que tra la interfaz
     * @return valores a los atributos
     */

    @Override
    public Object getPropertyU(String objPropiedad) {
        return null;
    }


}