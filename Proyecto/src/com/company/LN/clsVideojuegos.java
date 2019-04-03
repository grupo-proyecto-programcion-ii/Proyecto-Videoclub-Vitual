package com.company.LN;
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
     * @param _idPelicula
     * @param _nombreV
     * @param _precioP
     * @param _duracionP
     * @param puntuacionV
     * @param pegiVideojuegos
     */
    public clsVideojuegos(int _idPelicula, String _nombreV, double _precioP, double _duracionP, int puntuacionV, int pegiVideojuegos) {

        super(_idPelicula,_nombreV,  _precioP, _duracionP);
        this.puntuacionV = puntuacionV;
        this.pegiVideojuegos = pegiVideojuegos;
    }

    /**
     *Método para obtener los datos de los atributos de vidoejuegos.
     * @param obj_Propiedad
     * @return
     */
    @Override
    public Object getPropertyA(String obj_Propiedad) {

        switch (obj_Propiedad){
            case VIDEJUEGO_ID:
                return this.getId();
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
     * @param propiedad
     * @return
     */
    @Override
    public String getStringProperty(String propiedad) {
        return null;
    }

    @Override
    public Integer getIntegerProperty(String propiedad) {
        return null;
    }

    @Override
    public Float getFloatProperty(String propiedad) {
        return null;
    }

    @Override
    public Double getDoubleProperty(String propiedad) {
        return null;
    }

    @Override
    public char getCharProperty(String propiedad) {
        return 0;
    }

    @Override
    public Object getPropertyU(String objPropiedad) {
        return null;
    }


}
