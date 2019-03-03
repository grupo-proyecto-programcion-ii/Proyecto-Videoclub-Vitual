package com.company.LN;

import com.company.LP.Utilidades;

/**
 *Aquí se gestionarán todos los usuarios y todo lo que interactuaremos con ellos. Se crearán las
 * funciones propias par dar de alta a los usuarios, dar de baja, e inclusoque entre con uno
 * ya existente.
 *
 */

public class clsGestor {

    @Override
    public String toString() {
        return "clsGestor{" +
                "identificador='" + identificador + '\'' +
                ", contraseña='" + contraseña + '\'' +
                '}';
    }

    //Atributos del objeto objUsuarios
    private String identificador;
    private String contraseña;

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }



    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
    
    public void entrarUsuario(String id, String contra){

        if (id.equals(identificador) && contra.equals(contraseña)) {

        }
    }
}
