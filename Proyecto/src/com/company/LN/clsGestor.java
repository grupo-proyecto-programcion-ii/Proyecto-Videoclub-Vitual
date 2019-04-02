package com.company.LN;

import com.company.COMUN.itfProperty;
import com.company.LD.clsDatos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

/**
 * ésta clase contiene los métodos donde se recojen los parámentros de los usuarios como objetos
 * e introduciéndolos en ArrayList.
 */

public class clsGestor {
    /**
     * Instancia y declñaración de dos ArrayList que guardarán objetos. Uno guardará los objetos de usuarios
     * y el otro artículos.
     */
    private ArrayList<clsUsuario> listaUsuarios = new ArrayList<clsUsuario>();
    //private ArrayList<clsArticulo> listaArticulos = new ArrayList<clsArticulo>();
    private ArrayList<clsPeliculas> listaPeliculas = new ArrayList<clsPeliculas>();
    private ArrayList<clsVideojuegos> listaVidejuegos = new ArrayList<clsVideojuegos>();
    private ArrayList<clsMusica_CD> listaMusica = new ArrayList<clsMusica_CD>();

    /**
     * Se instancia un objeto para crear la comunicación con la lógica de datos
     */

    private clsDatos objDatos = new clsDatos();

    /**
     * Con esta clase se visualiza el numero de usuarios dados de alta.
     */

    public void visualizarNumUsuarios() {

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
     */

    public void anadirUsuario(String _id, String _contra, int c_Aleatorio) {

        try {

            objDatos.conectarBD();

            clsUsuario objUsuarios = new clsUsuario(_id, _contra, c_Aleatorio);
            listaUsuarios.add(objUsuarios);
            objUsuarios.setCodigoAleatoria(objDatos.insertarCodigoUsuario(_id, _contra));

            objDatos.desconectarBD();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Fallo al introdir usuarios....");
        }

    }

    /**
     * Método para hacer la llamda desde clsMenu. Para ello se declara e instancia un arraylist
     * que apunta a la interfaz itfProperty. Se recoje el array para copiar los objetos. Éste método es
     * de relevancia ya que, una vez que el usuario se ha registrado.
     *
     * @return
     */

    public ArrayList<itfProperty> leerUsuarios() {

        ArrayList<itfProperty> rUsuarios = new ArrayList<itfProperty>();

        for (clsUsuario usuario : listaUsuarios) {
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
    public void anadirPelicula(int _idPelicula, String _nombreP, double _precioP, double _duracionP, int _pegiPelicula, int _puntuacionPelicula) {

        clsPeliculas objPelicula = new clsPeliculas(_idPelicula, _nombreP, _precioP, _duracionP, _pegiPelicula, _puntuacionPelicula);
        listaPeliculas.add(objPelicula);
    }

    public void anadirVideojuego(int _idVideojuego, String _nombreV, double _precioV, double _duracionV, int _puntuacionVidejuego, int _pegiVidejuego) {

        clsVideojuegos objVidejuego = new clsVideojuegos(_idVideojuego, _nombreV, _precioV, _duracionV, _puntuacionVidejuego, _pegiVidejuego);
        listaVidejuegos.add(objVidejuego);
    }

    public void anadirMusica_CD(int _idMusica, String nombreM, double _precioM, double _duracionM, int _anio, String _artista, String _explicito) {

        clsMusica_CD objMusica = new clsMusica_CD(_idMusica, nombreM, _precioM, _duracionM, _anio, _artista, _explicito);
        listaMusica.add(objMusica);
    }


    public int _idPelicula() {

        Random idP = new Random();

        int idPelicula = idP.nextInt(-1000);
        return idPelicula;
    }


    /**
     * Método para levar a la clase clsMenu un arrayList que "copia" los objetos de el arraylist de artículos.
     *
     * @return
     */

    public ArrayList<itfProperty> leerPeliculas() {

        ArrayList<itfProperty> rPeliculas = new ArrayList<itfProperty>();

        for (clsPeliculas pelicula : listaPeliculas) {
            rPeliculas.add(pelicula);
        }
        return rPeliculas;
    }

    public ArrayList<itfProperty> leerVideojuegos() {

        ArrayList<itfProperty> rVideojuegos = new ArrayList<itfProperty>();

        for (clsVideojuegos videojuego : listaVidejuegos) {
            rVideojuegos.add(videojuego);
        }
        return rVideojuegos;
    }

    public ArrayList<itfProperty> leerMusica() {

        ArrayList<itfProperty> rMusica = new ArrayList<itfProperty>();

        for (clsMusica_CD cd : listaMusica) {
            rMusica.add(cd);
        }
        return rMusica;
    }

    public void visualizarNumPeliculas() {
        System.out.println(listaPeliculas.size() + " peliculas para reservar");
    }

    public void visualizarNumVideojuegos() {
        System.out.println(listaVidejuegos.size() + " peliculas para reservar");
    }

    public void visualizarNumCd() {
        System.out.println(listaMusica.size() + " peliculas para reservar");
    }

}


