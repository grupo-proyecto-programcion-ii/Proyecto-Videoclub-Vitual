package com.company.LN;

import java.util.Random;

public class clsUsuario {

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

}
