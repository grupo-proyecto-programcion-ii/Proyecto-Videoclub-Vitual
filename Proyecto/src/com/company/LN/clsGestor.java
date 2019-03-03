package com.company.LN;

import com.company.LP.Utilidades;

/**
 *Aquí se gestionarán todos los usuarios y todo lo que interactuaremos con ellos. Se crearán las
 * funciones propias par dar de alta a los usuarios, dar de baja, e inclusoque entre con uno
 * ya existente.
 *
 */

public class clsGestor {

    private String identificador;

    public void altaUsuario(){

        System.out.println("Introduce tus datos; ");
        System.out.print("Usuario: ");
        identificador = Utilidades.leerCadena();
    }

    public void entrarUsuario(){

        System.out.println("hola");


    }

}
