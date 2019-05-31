package com.company.LN;

import java.util.Date;

import static com.company.COMUN.clsConstantes.*;

/**
 * Esta clase contiene los atributos, el constructor y el metodo filtrar la llamda a los diferentes atributos
 * desde otras clases de el articulo Musica_CD.
 */

public class clsMusica_CD extends clsArticulo {

    /***
     *Atributos seters y geters
     */
    private int anio;
    private String artistas;
    private String explicito;

    public int getAnio() {
        return anio;
    }

    public void setAnio(int _anio) {
        this.anio = _anio;
    }

    public String getArtistas() {
        return artistas;
    }

    public void setArtistas(String _artistas) {
        this.artistas = _artistas;
    }

    public String getExplicito() {
        return explicito;
    }

    public void setExplicito(String _explicito) {
        this.explicito = _explicito;
    }

    /**
     * Contructor de la case. Se hace un super para hacer la llamda al contructor padre que es articulo.
     *      * De ahi recibe los 4 atributos principales.
     * @param _idPelicula id
     * @param _fechaDevM fecha
     * @param _nombreM nombre
     * @param _precioM precio
     * @param _duracionM duracion
     * @param _anio anio
     * @param _artistas artistas
     * @param _explicito explicito
     */
    public clsMusica_CD(int _idPelicula,  Date _fechaDevM,String _nombreM, double _precioM, double _duracionM, int _anio, String _artistas, String _explicito) {

        super(_idPelicula, _fechaDevM,_nombreM, _precioM, _duracionM);
        this.anio = _anio;
        this.artistas = _artistas;
        this.explicito = _explicito;
    }

    public clsMusica_CD(Date _fechaSM, String _nombreM, double _precioM, double _duracionM, int _anio, String _artistas, String _explicito) {

        super(_fechaSM ,_nombreM, _precioM, _duracionM);
        this.anio = _anio;
        this.artistas = _artistas;
        this.explicito = _explicito;
    }

    /***
     * Metodo para hacer las llamadas a los datos de los atributos especificamente. Los 4 primeros son geters
     * de los atributos padre.
     * @param obj_Propiedad objeto de la interfaz
     * @return parametros a los atributos
     */
    @Override
    public Object getPropertyA(String obj_Propiedad) {

        switch (obj_Propiedad){
            case MUSICA_ID:
                return this.getId();
            case MUSICA_FECHA_SALIDA:
                return this.getFechaS();
            case  MUSICA_NOMBRE:
                return this.getNombre();
            case MUSICA_PRECIO:
                return this.getPrecio();
            case MUSICA_DURACION:
                return this.getDuracion();
            case MUSICA_ANIO:
                return this.anio;
            case MUSICA_ARTISTA:
                return this.artistas;
            case MUSICA_EXPLICITO:
                return this.explicito;
        }
        return null;
    }

    /**
     * Metodos de la clase interfaz itfProperty
     * @param objPropiedad objeto interfaces
     * @return null
     */

    @Override
    public Object getPropertyU(String objPropiedad) {
        return null;
    }
}
