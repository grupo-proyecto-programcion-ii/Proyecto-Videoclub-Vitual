package com.company.LN;

import com.company.LP.Utilidades;

/**
 *Aquí se gestionarán todos los usuarios y todo lo que interactuaremos con ellos. Se crearán las
 * funciones propias par dar de alta a los usuarios, dar de baja, e inclusoque entre con uno
 * ya existente.
 *
 */

public class clsGestor {

    private String usuario = null;

    public void entrarUsuario(){

        System.out.println("Introduce tus datos; ");
        System.out.print("Usuario: ");
        usuario = Utilidades.leerCadena();

    }

    public void altaUsuario(){

        System.out.println("Introduce tus datos; ");
        System.out.print("Usuario: ");
        usuario = Utilidades.leerCadena();


    }

}
