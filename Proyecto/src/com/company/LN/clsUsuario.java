package com.company.LN;

import com.company.COMUN.itfProperty;

import java.util.Random;

public class clsUsuario implements itfProperty {

    //Atributos principales de la clase clsUsuario
    private String identificador = null;
    private String contrasena = null;
    private int codigoAleatoria = 0;

    public int getCodigoAleatoria() {
        return codigoAleatoria;
    }

    public void setCodigoAleatoria(int _codigoAleatoria) {
        this.codigoAleatoria = codigoAleatoria;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String _identificador) {
        this.identificador = _identificador;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String _contrasena) {
        this.contrasena = _contrasena;
    }


    public clsUsuario(String _id, String _codigo, int _cAleatorio) {

        this.identificador = _id;
        this.contrasena = _codigo;
        this.codigoAleatoria = _cAleatorio;
    }

    public Object getProperty(String propiedad){

        switch(propiedad)
        {
            case "Identificador": return 	this.getIdentificador();
            case "Contraseña": return this.getContrasena();
            case "CodigoAleatorio": return this.getCodigoAleatoria();
        }

        return null;
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

}
