package com.company.LN;

/**
 * ésta clase contiene los atributos, el constructor y el método filtrar la llamda a los diferentes atributos
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
     * Contructor de la case. Se hace un super para hacer la llamda al contructor padre que es artículo.
     * De ahí recibe los 4 atributos principales.
     * @param _idPelicula
     * @param _nombreM
     * @param _precioP
     * @param _duracionP
     * @param _anio
     * @param _artistas
     * @param _explicito
     */
    public clsMusica_CD(int _idPelicula, String _nombreM, double _precioP, double _duracionP, int _anio, String _artistas, String _explicito) {

        super(_idPelicula,_nombreM, _precioP, _duracionP);
        this.anio = _anio;
        this.artistas = _artistas;
        this.explicito = _explicito;
    }

    /***
     * Método para hacer las llamadas a los datos de los atributos específicamente. Los 4 primeros son geters
     * de los atributos padre.
     * @param obj_Propiedad
     * @return
     */
    @Override
    public Object getPropertyA(String obj_Propiedad) {

        switch (obj_Propiedad){
            case "IdentificadorP":
                return this.getIndentificador();
            case "NombreV":
                return this.getNombre();
            case "PrecioV":
                return this.getPrecio();
            case "DuracionV":
                return this.getDuracion();
            case "Anio":
                return this.anio;
            case "Artista":
                return this.artistas;
            case "Explicito":
                return this.explicito;
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
