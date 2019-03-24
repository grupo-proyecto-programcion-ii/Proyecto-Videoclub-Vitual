package com.company.LN;

public class clsMusica_CD extends clsArticulo {


    public clsMusica_CD(int _idPelicula, String _nombreM, double _precioP, double _duracionP, int _anio, String _artistas, String _explicito) {

        super(_idPelicula,_nombreM, _precioP, _duracionP);
        this.anio = _anio;
        this.artistas = _artistas;
        this.explicito = _explicito;
    }

    //Atributos principales de la clase clsMusicz
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
    public Object getProperty(String objPropiedad) {
        return null;
    }
}
