package com.company.LN;

public class clsUsuario {

    private String identificador = null;
    private String contrasena = null;

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }


    public clsUsuario(String id, String codigo) {

        this.identificador = id;
        this.contrasena = codigo;
    }

}
