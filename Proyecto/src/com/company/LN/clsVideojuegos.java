package com.company.LN;

public class clsVideojuegos extends clsArticulo {


    public clsVideojuegos(int _idPelicula, String _nombreV, double _precioP, double _duracionP, int puntuacionV, int pegiVideojuegos) {

        super(_idPelicula,_nombreV,  _precioP, _duracionP);
        this.puntuacionV = puntuacionV;
        this.pegiVideojuegos = pegiVideojuegos;
    }

    //Atributos principales de la clase clsVideojuegos
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
