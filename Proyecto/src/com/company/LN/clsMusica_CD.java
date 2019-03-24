package com.company.LN;

public class clsMusica_CD extends clsArticulo {

    public clsMusica_CD(){

    }

    public clsMusica_CD(int _anio, String _artistas, String _explicito) {
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


}
