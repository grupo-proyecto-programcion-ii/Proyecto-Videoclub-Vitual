package com.company.LN;

import com.company.COMUN.itfProperty;
import com.company.LD.clsDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.company.COMUN.clsConstantes.*;
import static com.company.COMUN.clsConstantes.USUARIO_CONTRASENA;

/**
 * ésta clase contiene los métodos donde se recojen los parámentros de los usuarios como objetos
 * e introduciéndolos en ArrayList.
 */

public class clsGestor {
    /**
     * Instancia y declñaración de dos ArrayList que guardarán objetos. Uno guardará los objetos de usuarios
     * y el otro artículos.
     */
    private ArrayList<clsUsuario> listaUsuarios = new ArrayList<>();
    private ArrayList<clsPeliculas> listaPeliculas = new ArrayList<>();
    private ArrayList<clsVideojuegos> listaVidejuegos = new ArrayList<>();
    private ArrayList<clsMusica_CD> listaMusica = new ArrayList<>();

    /**
     * Parámetros de mysql
     */
    private ResultSet usuariosBaseDatos;
    private ResultSet peliculasBaseDatos;
    private ResultSet videojuegosBaseDatos;
    private ResultSet musicaBaseDatos;

    /**
     * Se instancia un objeto para crear la comunicación con la lógica de datos
     */

    private clsDatos objDatos = new clsDatos();

    /**
     * Con esta clase se visualiza el numero de usuarios dados de alta.
     */
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

    public void anadirUsuario(String _id, String _contra) {


        try {

            objDatos.conectarBD();

            clsUsuario objUsuario = new clsUsuario(_id, _contra);
            listaUsuarios.add(objUsuario);
            objUsuario.setCodigoAleatoria(objDatos.insertarCodigoUsuario(_id, _contra));
            objDatos.desconectarBD();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Fallo");
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

    public void cargarUsuarios(){

        int codigoConsulta = 0; // 0 para hacer select de usuarios
        try {
            objDatos.conectarBD();
            usuariosBaseDatos = objDatos.dameParametros(codigoConsulta);
            while (usuariosBaseDatos.next()){
                int id = usuariosBaseDatos.getInt(USUARIO_CODIGO_ID);
                String nombre = usuariosBaseDatos.getString(USUARIO_IDENTIFICADOR);
                String contrasena = usuariosBaseDatos.getString(USUARIO_CONTRASENA);
                clsUsuario objUsuario = new clsUsuario(id, nombre, contrasena);
                listaUsuarios.add(objUsuario);
            }
            objDatos.desconectarBD();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /***
     * Métodos para añador objetos de artículos al arraylist de artículos.
     * @param _nombreP
     * @param _precioP
     * @param _duracionP
     * @param _pegiPelicula
     * @param _puntuacionPelicula
     */
    public void anadirPelicula(String _nombreP, double _precioP, double _duracionP, int _pegiPelicula, int _puntuacionPelicula) {

        try {

            objDatos.conectarBD();

            clsPeliculas objPelicula = new clsPeliculas(_nombreP, _precioP, _duracionP, _pegiPelicula, _puntuacionPelicula);
            listaPeliculas.add(objPelicula);
            objPelicula.setId(objDatos.insertarIdPelicula(_nombreP, _precioP, _duracionP, _pegiPelicula, _puntuacionPelicula));

            objDatos.desconectarBD();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Error al insertar película");
        }
    }

    public void anadirVideojuego(String _nombreV, double _precioV, double _duracionV, int _puntuacionVidejuego, int _pegiVidejuego) throws SQLException, ClassNotFoundException {

        objDatos.conectarBD();

        clsVideojuegos objVidejuego = new clsVideojuegos(_nombreV, _precioV, _duracionV, _puntuacionVidejuego, _pegiVidejuego);
        listaVidejuegos.add(objVidejuego);
        objVidejuego.setId(objDatos.insertarIdVidejuego(_nombreV, _precioV, _duracionV, _puntuacionVidejuego, _pegiVidejuego));
        objDatos.desconectarBD();
    }

    public void anadirMusica_CD(String   _nombreM, double _precioM, double _duracionM, int _anio, String _artista, String _explicito) throws SQLException, ClassNotFoundException {

        objDatos.conectarBD();

        clsMusica_CD objMusica = new clsMusica_CD(_nombreM, _precioM, _duracionM, _anio, _artista, _explicito);
        listaMusica.add(objMusica);
        objMusica.setId(objDatos.insertarIdMusica(_nombreM,_precioM, _duracionM, _anio, _artista, _explicito));

        objDatos.desconectarBD();
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void cargarPeliculas(){

        int codigoConsulta = 1; // 1 para hacer select de peliculas
        try {
            objDatos.conectarBD();
            peliculasBaseDatos = objDatos.dameParametros(codigoConsulta);
            while (peliculasBaseDatos.next()){
                int id = peliculasBaseDatos.getInt(PELICULA_CODIGO_ID);
                String nombre = peliculasBaseDatos.getString(PELICULA_NOMBRE);
                double precio = peliculasBaseDatos.getDouble(PELICULA_PRECIO);
                double duracion = peliculasBaseDatos.getDouble(PELICULA_DURACION);
                int pegi = peliculasBaseDatos.getInt(PELICULA_PEGI);
                int puntuacion = peliculasBaseDatos.getInt(PELICULA_PUNTUACION);

                clsPeliculas objPeliculaBD = new clsPeliculas(id, nombre, precio, duracion, pegi, puntuacion);
                listaPeliculas.add(objPeliculaBD);
            }
            objDatos.desconectarBD();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void cargarVideojuegos(){

        int codigoConsulta = 2; // 2 para hacer select de vidojuegos
        try {
            objDatos.conectarBD();
            videojuegosBaseDatos = objDatos.dameParametros(codigoConsulta);
            while (videojuegosBaseDatos.next()){
                int id = videojuegosBaseDatos.getInt(VIDEJUEGO_ID);
                String nombre = videojuegosBaseDatos.getString(VIDEOJUEGO_NOMBRE);
                double precio = videojuegosBaseDatos.getDouble(VIDEOJUEGO_PRECIO);
                double duracion = videojuegosBaseDatos.getDouble(VIDEOJUEGO_DURACION);
                int puntuacion = videojuegosBaseDatos.getInt(VIDEOJUEGO_PEGI);
                int pegi = videojuegosBaseDatos.getInt(VIDEOJUEGO_PEGI);


                clsVideojuegos objVideojuegoBD = new clsVideojuegos(id, nombre, precio, duracion, puntuacion, pegi);
                listaVidejuegos.add(objVideojuegoBD);
            }
            objDatos.desconectarBD();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void cargarMusica(){

        int codigoConsulta = 3; // 3 para hacer select de musica
        try {
            objDatos.conectarBD();
            musicaBaseDatos = objDatos.dameParametros(codigoConsulta);
            while (musicaBaseDatos.next()){
                int id = musicaBaseDatos.getInt(MUSICA_ID);
                String nombre = musicaBaseDatos.getString(MUSICA_NOMBRE);
                double precio = musicaBaseDatos.getDouble(MUSICA_PRECIO);
                double duracion = musicaBaseDatos.getDouble(MUSICA_DURACION);
                int anio = musicaBaseDatos.getInt(MUSICA_ANIO);
                String artista = musicaBaseDatos.getString(MUSICA_ARTISTA);
                String explicito = musicaBaseDatos.getString(MUSICA_EXPLICITO);

                clsMusica_CD objMusicaBD = new clsMusica_CD(id, nombre, precio, duracion, anio, artista, explicito );
                listaMusica.add(objMusicaBD);
            }
            objDatos.desconectarBD();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void visualizarNumPeliculas() {
        System.out.println(listaPeliculas.size() + " peliculas para reservar");
    }

    public void visualizarNumVideojuegos() {
        System.out.println(listaVidejuegos.size() + " videojuego para reservar");
    }

    public void visualizarNumCd() {
        System.out.println(listaMusica.size() + " musica para reservar");
    }

}
