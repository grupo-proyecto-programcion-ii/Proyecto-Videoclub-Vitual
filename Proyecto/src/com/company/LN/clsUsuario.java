package com.company.LN;

import com.company.COMUN.itfProperty;


/**
 * Ésta clase contiene atributos y el contructor para el usuario.
 */
public class clsUsuario implements itfProperty {

    /**
     * Atributos geters y seters
     */
    private int codigoAleatoria = 0;
    private String identificador = null;
    private String contrasena = null;


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

    /***
     * Contructor que recibe los parámetros para los atributos.
     * @param _id
     * @param _codigo
     * @param _cAleatorio
     */
    public clsUsuario(String _id, String _codigo, int _cAleatorio) {

        this.identificador = _id;
        this.contrasena = _codigo;
        this.codigoAleatoria = _cAleatorio;
    }
    /**
     *Método para obtener los datos de los atributos de usuarios.
     * @param propiedad
     * @return
     */
    public Object getPropertyU(String propiedad){

        switch(propiedad)
        {
            case "Identificador": return 	this.getIdentificador();
            case "Contraseña": return this.getContrasena();
            case "CodigoAleatorio": return this.getCodigoAleatoria();
        }

        return null;
    }/**
     * Métodos de la clase interfaz itfProperty
     * @param propiedad
     * @return
     */
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
    public Object getPropertyA(String obj_Propiedad) {
        return null;
    }

}
