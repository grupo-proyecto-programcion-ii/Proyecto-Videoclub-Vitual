package com.company.LN;

public class clsPeliculas extends clsArticulo {

    //Atributos principales de la clase clsPeliculas
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


    public clsPeliculas(int _idPelicula, String _nombreP, double _precioP, double _duracionP, int _pegiPelicula, int _puntuacionPelicula) {

        super(_idPelicula,_nombreP,  _precioP, _duracionP);
        this.pegiP= _pegiPelicula;
        this.puntuacionP = _puntuacionPelicula;
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
