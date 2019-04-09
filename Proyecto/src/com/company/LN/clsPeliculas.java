package com.company.LN;
import static com.company.COMUN.clsConstantes.*;


/**
 *Esta clase hereda de la clase padre artículos. Hereda 4 atributos principales. Contiene
 * los atributos, el contructor y el método para hacer la llamda a los datos.
 */


public class clsPeliculas extends clsArticulo {

    /***
     * Atributos
     */
    private int pegiP;
    private int puntuacionP;

    public int getPegi() {
        return pegiP;
    }

    public void setPegi(int _pegi) {
        this.pegiP = _pegi;
    }

    public int getPuntuacion() {
        return puntuacionP;
    }

    public void setPuntuacion(int _puntuacion) {
        this.puntuacionP = _puntuacion;
    }

    /***
     * Contructor. Hereda con un super los 4 atributos principales.
     * @param _idPelicula
     * @param _nombreP
     * @param _precioP
     * @param _duracionP
     * @param _pegiPelicula
     * @param _puntuacionPelicula
     */
    public clsPeliculas(int _idPelicula, String _nombreP, double _precioP, double _duracionP, int _pegiPelicula, int _puntuacionPelicula) {

        super(_idPelicula,_nombreP,  _precioP, _duracionP);
        this.pegiP = _pegiPelicula;
        this.puntuacionP = _puntuacionPelicula;
    }

    public clsPeliculas(String _nombreP, double _precioP, double _duracionP, int _pegiPelicula, int _puntuacionPelicula) {

        super(_nombreP,  _precioP, _duracionP);
        this.pegiP = _pegiPelicula;
        this.puntuacionP = _puntuacionPelicula;
    }


    /**
     * Método para hacer la llamda desde LP obteniendo los datos de los atributos especificamente.
     * @param obj_Propiedad
     * @return
     */
    @Override
    public Object getPropertyA(String obj_Propiedad) {

        switch (obj_Propiedad){
            case PELICULA_CODIGO_ID:
                return this.getId();
            case PELICULA_NOMBRE:
                return this.getNombre();
            case PELICULA_PRECIO:
                return this.getPrecio();
            case PELICULA_DURACION:
                return this.getDuracion();
            case PELICULA_PEGI:
                return this.pegiP;
            case PELICULA_PUNTUACION:
                return this.puntuacionP;
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
