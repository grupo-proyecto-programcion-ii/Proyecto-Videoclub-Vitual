package com.company.LN;

import com.company.COMUN.itfProperty;

/**
 * Clase principal de alquiler
 */
public class clsAlquiler implements itfProperty {

    /**
     * Atributos de alquiler que heredaran todo los articulos
     */
    private int idAlquiler;
    private int usuarios_codigo;


    /**
     * geters y setters para los atributos de alquiler
     * @return id
     */
    public int getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(int idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    public int getUsuarios_codigo() {
        return usuarios_codigo;
    }

    public void setUsuarios_codigo(int usuarios_codigo) {
        this.usuarios_codigo = usuarios_codigo;
    }

    public clsAlquiler(int idAlquiler, int usuarios_codigo) {
        this.idAlquiler = idAlquiler;
        this.usuarios_codigo = usuarios_codigo;
    }

    public clsAlquiler(int codigo) {
        this.usuarios_codigo = codigo;
    }

    public clsAlquiler() {

    }

    @Override
    public Object getPropertyU(String objPropiedad) {
        return null;
    }

    @Override
    public Object getPropertyA(String obj_Propiedad) {
        return null;
    }

    @Override
    public boolean getPropertyEstadoS() {
        return false;
    }

}
