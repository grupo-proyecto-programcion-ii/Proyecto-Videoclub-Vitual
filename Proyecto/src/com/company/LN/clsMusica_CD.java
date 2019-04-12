package com.company.LN;

import static com.company.COMUN.clsConstantes.*;
import static com.company.COMUN.clsConstantes.MUSICA_EXPLICITO;

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
     * De ahi recibe los 4 atributos principales.
     * @param _idPelicula atributo
     * @param _nombreM atributo
     * @param _precioP atributo
     * @param _duracionP atributo
     * @param _anio atributo
     * @param _artistas atributo
     * @param _explicito atributo
     */
    public clsMusica_CD(int _idPelicula, String _nombreM, double _precioP, double _duracionP, int _anio, String _artistas, String _explicito) {

        super(_idPelicula,_nombreM, _precioP, _duracionP);
        this.anio = _anio;
        this.artistas = _artistas;
        this.explicito = _explicito;
    }

    public clsMusica_CD(String _nombreM, double _precioP, double _duracionP, int _anio, String _artistas, String _explicito) {

        super(_nombreM, _precioP, _duracionP);
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
