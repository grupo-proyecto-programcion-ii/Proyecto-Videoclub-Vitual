package com.company.LN;

import com.company.COMUN.itfProperty;
import static com.company.COMUN.clsConstantes.*;


/**
 * Ésta clase contiene atributos y el contructor para el usuario.
 */
public class clsUsuario implements itfProperty {

    /**
     * Atributos geters y seters
     */
    private int codigoAleatoria;
    private String identificador = null;
    private String contrasena = null;


    public int getCodigoAleatoria() {
        return codigoAleatoria;
    }

    public void setCodigoAleatoria(int _codigoAleatoria) {
        this.codigoAleatoria = _codigoAleatoria;
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
     */
    public clsUsuario(String _id, String _codigo) {
        this.identificador = _id;
        this.contrasena = _codigo;
    }

    public clsUsuario(int codigoA, String _id, String _codigo) {
        this.codigoAleatoria = codigoA;
        this.identificador = _id;
        this.contrasena = _codigo;
    }
    /**
     *Método para obtener los datos de los atributos de usuarios.
     * @param propiedad
     * @return
     */
    public Object getPropertyU(String propiedad){

        switch(propiedad)
        {
            case USUARIO_CODIGO_ID: return this.getCodigoAleatoria();
            case USUARIO_IDENTIFICADOR: return 	this.getIdentificador();
            case USUARIO_CONTRASENA: return this.getContrasena();

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
