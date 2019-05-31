package com.company.LN;

import java.util.Date;
import static com.company.COMUN.clsConstantes.*;


/**
 *Esta clase hereda de la clase padre articulos. Hereda 4 atributos principales. Contiene
 * los atributos, el contructor y el metodo para hacer la llamda a los datos.
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
     * @param _idPelicula atributo
     * @param _nombreP atributo
     * @param _precioP atributo
     * @param _duracionP atributo
     * @param _pegiPelicula atributo
     * @param _puntuacionPelicula atributo
     */
    public clsPeliculas(int _idPelicula,Date _fechaDevP , String _nombreP, double _precioP, double _duracionP, int _pegiPelicula, int _puntuacionPelicula) {

        super(_idPelicula, _fechaDevP,_nombreP,  _precioP, _duracionP);
        this.pegiP = _pegiPelicula;
        this.puntuacionP = _puntuacionPelicula;
    }


    public clsPeliculas(Date _fechaS, String _nombreP, double _precioP, double _duracionP, int _pegiPelicula, int _puntuacionPelicula) {

        super(_fechaS ,_nombreP,  _precioP, _duracionP);
        this.pegiP = _pegiPelicula;
        this.puntuacionP = _puntuacionPelicula;
    }

    /**
     * Metodo para hacer la llamda desde LP obteniendo los datos de los atributos especificamente.
     * @param obj_Propiedad objeto de la interfaz
     * @return parametros a los atributos
     */
    @Override
    public Object getPropertyA(String obj_Propiedad) {

        switch (obj_Propiedad){
            case PELICULA_CODIGO_ID:
                return this.getId();
            case PELICULA_FECHA_SALIDA:
                return this.getFechaS();
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
     * Metodos de la clase interfaz itfProperty
     * @param objPropiedad objetos me los metodos de interfaz
     * @return en este caso null
     */

    @Override
    public Object getPropertyU(String objPropiedad) {
        return null;
    }
}
