package com.company.LN;

import com.company.LP.Utilidades;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *Para llevar a cabo las opciones principales se crea un arrayList, que apunta a clsUsuario, que
 * contiene los atributos principales de los usuarios.
 *
 */

public class clsGestor {

    private ArrayList<clsUsuario> listaUsuarios = new ArrayList<clsUsuario>();

    /**
     * Con esta clase se visualiza el numero de usuarios dados de alta
     */

    public void visualizarNumUsuarios(){

        if (listaUsuarios.size() == 1) {
            System.out.println(listaUsuarios.size() + " usuario dado de alta");
        } else if (listaUsuarios.size() == 0) {
            System.out.println("Ningún usuario dado de alta");
        } else {
            System.out.println(listaUsuarios.size() + " usuarios dados de alta");
        }
    }

    /**
     * Con éste método se recojen los datos del usuario en el objeto objUsuarios que apunta
     * a la clase clsUsuario donde se encuentran los atributos principales. Una vez instanciado el objeto,
     * se añade al arraylist.
     * @param id
     * @param contra
     */

    public void anadirUsuario(String id, String contra){

        clsUsuario objUsuarios = new clsUsuario(id, contra);
        listaUsuarios.add(objUsuarios);
    }

    public ArrayList<clsUsuario>leerUsuarios(){
        return listaUsuarios;
    }
}
