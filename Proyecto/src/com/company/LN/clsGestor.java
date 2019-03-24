package com.company.LN;

import com.company.COMUN.itfProperty;
import java.util.ArrayList;

/**
 *ésta clase contiene los métodos donde se recojen los parámentros de los usuarios como objetos
 * e introduciéndolos en ArrayList.
 *
 */

public class clsGestor {
    /**
     * Instancia y declñaración de dos ArrayList que guardarán objetos. Uno guardará los objetos de usuarios
     * y el otro artículos.
     */
    private ArrayList<clsUsuario> listaUsuarios = new ArrayList<clsUsuario>();
    private ArrayList<clsArticulo>listaArticulos = new ArrayList<clsArticulo>();

    /**
     * Con esta clase se visualiza el numero de usuarios dados de alta.
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
     * Con éste método se recojen los datos del usuario en forma de objetos. Se introduce en un arraylist específica
     * para una lista de usuarios.
     *
     */

    public void anadirUsuario(String _id, String _contra, int c_Aleatorio){

        clsUsuario objUsuarios = new clsUsuario(_id, _contra, c_Aleatorio);
        listaUsuarios.add(objUsuarios);
    }

    /**
     * Método para hacer la llamda desde clsMenu. Para ello se declara e instancia un arraylist
     * que apunta a la interfaz itfProperty. Se recoje el array para copiar los objetos. Éste método es
     * de relevancia ya que, una vez que el usuario se ha registrado.
     * @return
     */

    public ArrayList<itfProperty> leerUsuarios(){

        ArrayList<itfProperty> rUsuarios = new ArrayList<itfProperty>();

        for (clsUsuario usuario:listaUsuarios){
            rUsuarios.add(usuario);
        }
        return rUsuarios;
    }

    /***
     * Métodos para añador objetos de artículos al arraylist de artículos.
     * @param _idPelicula
     * @param _nombreP
     * @param _precioP
     * @param _duracionP
     * @param _pegiPelicula
     * @param _puntuacionPelicula
     */
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

    /**
     * Método para levar a la clase clsMenu un arrayList que "copia" los objetos de el arraylist de artículos.
     *
     * @return
     */

    public ArrayList<itfProperty>leerArticulos(){

        ArrayList<itfProperty> rArticulos = new ArrayList<itfProperty>();

        for (clsArticulo articulo:listaArticulos){
            rArticulos.add(articulo);
        }
        return rArticulos;
    }
}


