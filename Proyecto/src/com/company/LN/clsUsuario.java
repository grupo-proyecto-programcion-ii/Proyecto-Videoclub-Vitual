package com.company.LN;

import com.company.COMUN.itfProperty;

import static com.company.COMUN.clsConstantes.*;
import static com.company.COMUN.clsConstantes.USUARIO_CONTRASENA;


/**
 * Esta clase contiene atributos y el contructor para el usuario.
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
     * Constructor que recibe los parametros para los atributos.
     * @param _id atributo
     * @param _codigo atributo
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
     * @param propiedad objeto que tra la interfaz
     * @return valores a los atributos
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
     * Metodos de la clase interfaz itfProperty
     * @param obj_Propiedad objeto de interfaz
     * @return valores a los atributos
     */
    @Override
    public Object getPropertyA(String obj_Propiedad) {
        return null;
    }


    /**
    @Override
    public int compareTo(clsUsuario _objUsuario) {
        return _objUsuario.codigoAleatoria.compareTo(this.codigoAleatoria);
    }
    */
}
