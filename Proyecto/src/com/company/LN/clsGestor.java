package com.company.LN;

import com.company.COMUN.itfProperty;
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
     *
     */

    public void anadirUsuario(String _id, String _contra, int c_Aleatorio){

        clsUsuario objUsuarios = new clsUsuario(_id, _contra, c_Aleatorio);
        listaUsuarios.add(objUsuarios);
    }

    public ArrayList<itfProperty> leerUsuarios(){

        ArrayList<itfProperty> rUsuarios = new ArrayList<itfProperty>();

        for (clsUsuario usuario:listaUsuarios){
            rUsuarios.add(usuario);
        }
        return rUsuarios;
    }

    public void anadirPelicula(int _idPelicula,String _nombreP, double _precioP, double _duracionP, int _pegiPelicula, int _puntuacionPelicula){

        clsPeliculas objPelicula = new clsPeliculas(_idPelicula, _nombreP, _precioP, _duracionP, _pegiPelicula, _puntuacionPelicula );
        listaArticulos.add(objPelicula);
    }

    public void anadirVideojuego(int _idVideojuego, String _nombreV, double _precioV, double _duracionV, int _puntuacionVidejuego, int _pegiVidejuego){

        clsVideojuegos objVidejuego = new clsVideojuegos(_idVideojuego, _nombreV, _precioV, _duracionV, _puntuacionVidejuego, _pegiVidejuego);
        listaArticulos.add(objVidejuego);
    }

    public void anadirMusica_CD(int _idMusica,String nombreM, double _precioM, double _duracionM, int _anio, String _artista, String _explicito){

        clsMusica_CD objMusica = new clsMusica_CD(_idMusica, nombreM, _precioM, _duracionM, _anio, _artista, _explicito);
        listaArticulos.add(objMusica);
    }

    public ArrayList
}


