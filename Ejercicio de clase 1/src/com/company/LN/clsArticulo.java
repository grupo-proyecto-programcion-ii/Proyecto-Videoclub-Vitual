package com.company.LN;

class clsArticulio {

    private int identificador;
    private String titulo;
    private int año;
    private double precio;
    public int ejemp;

    public clsArticulio(int identificador, String titulo, int año, double precio, int ejemp) {
        super();
        this.identificador = identificador;
        this.titulo = titulo;
        this.año = año;
        this.precio = precio;
        this.ejemp = ejemp;
    }

    /**
     * Establece el PVP del artículo, pero recibimos el precio sin IVA
     * @param _precio
     */

    public void setPrecio(double _precio)
    {
        precio = _precio + _precio * 0.21;
    }

    public int getIdentificador() {
        return identificador;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo)
    {
        if (!titulo.equals(""))
            this.titulo = titulo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año)
    {
        if(año>0)
        {
            this.año = año;
        }

        this.año=0;

    }

}
