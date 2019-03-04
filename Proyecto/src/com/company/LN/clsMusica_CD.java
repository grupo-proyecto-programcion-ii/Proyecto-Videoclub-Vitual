package com.company.LN;

public class clsMusica_CD extends clsArticulo {

    public clsMusica_CD(){

    }

    public clsMusica_CD(int anio, String artistas, String explicito) {
        this.anio = anio;
        this.artistas = artistas;
        this.explicito = explicito;
    }

    //Atributos principales de la clase clsMusicz
    private int anio;
    private String artistas;
    private String explicito;

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
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
