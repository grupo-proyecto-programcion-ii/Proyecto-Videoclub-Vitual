package com.company.LN;

import com.company.LP.Utilidades;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *Aquí se gestionarán todos los usuarios y todo lo que interactuaremos con ellos. Se crearán las
 * funciones propias par dar de alta a los usuarios, dar de baja, e inclusoque entre con uno
 * ya existente.
 *
 */

public class clsGestor {

    private ArrayList<clsUsuario> listaUsuarios = new ArrayList<clsUsuario>();
    //private Iterator<clsGestor> miIterator = listaUsuarios.iterator();


    public void visualizarNumUsuarios(){

        if (listaUsuarios.size() == 1) {
            System.out.println(listaUsuarios.size() + " usuario dado de alta");
        } else if (listaUsuarios.size() == 0) {
            System.out.println("Ningún usuario dado de alta");
        } else {
            System.out.println(listaUsuarios.size() + " usuarios dados de alta");
        }
    }

    public void anadirUsuario(String id, String contra){

        clsUsuario objUsuarios = new clsUsuario(id, contra);
        listaUsuarios.add(objUsuarios);
    }

    public ArrayList<clsUsuario>leerUsuarios(){
        return listaUsuarios;
    }
}
