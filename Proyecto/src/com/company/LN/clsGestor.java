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
    private ArrayList<clsArticulo>listaArticulos = new ArrayList<clsArticulo>();

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
     * @param _id
     * @param _contra
     * @param c_Aleatorio
     */

    public void anadirUsuario(String _id, String _contra, int c_Aleatorio){

        clsUsuario objUsuarios = new clsUsuario(_id, _contra, c_Aleatorio);
        listaUsuarios.add(objUsuarios);
    }

    public void anadirPelicula(){

    }
    public void anadirVideojuego(){

    }
    public void anadirMusica_CD(){

    }

    public ArrayList<clsUsuario>leerUsuarios(){
        return listaUsuarios;
    }
}
