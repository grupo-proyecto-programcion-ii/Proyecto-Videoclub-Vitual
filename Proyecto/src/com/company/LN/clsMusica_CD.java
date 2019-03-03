package com.company.LN;

public class clsMusica_CD extends clsArticulo {

    public clsMusica_CD(int año, String artistas, String explicito) {
        this.año = año;
        this.artistas = artistas;
        this.explicito = explicito;
    }

    //Atributos principales de la clase clsMusicz
    private int año;
    private String artistas;
    private String explicito;

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getArtistas() {
        return artistas;
    }

    public void setArtistas(String artistas) {
        this.artistas = artistas;
    }

    public String getExplicito() {
        return explicito;
    }

    public void setExplicito(String explicito) {
        this.explicito = explicito;
    }


}
