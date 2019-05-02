package com.company.LN;

import com.company.COMUN.itfProperty;
import com.company.LD.clsDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

import static com.company.COMUN.clsConstantes.*;
import static com.company.COMUN.clsConstantes.USUARIO_CONTRASENA;

/**
 * Esta clase contiene los metodos donde se recojen los paramentros de los usuarios como objetos
 * e introduciendolos en ArrayList.
 */

public class clsGestor {
    /**
     * Instancia y declaracion de dos ArrayList que guardaran objetos. Uno guardara los objetos de usuarios
     * y el otro articulos.
     */
    private ArrayList<clsUsuario> listaUsuarios = new ArrayList<>();
    private ArrayList<clsPeliculas> listaPeliculas = new ArrayList<>();
    private ArrayList<clsVideojuegos> listaVidejuegos = new ArrayList<>();
    private ArrayList<clsMusica_CD> listaMusica = new ArrayList<>();

    /**
     * Parametros de mysql
     */
    private ResultSet usuariosBaseDatos;
    private ResultSet peliculasBaseDatos;
    private ResultSet videojuegosBaseDatos;
    private ResultSet musicaBaseDatos;

    /**
     * Se instancia un objeto para crear la comunicacion con la logica de datos
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
     * Con este metodo se recojen los datos del usuario en forma de objetos. Se introduce en un arraylist especifica
     * para una lista de usuarios.
     * @param _id identificador de usuario
     * @param _contra contrasena de usuario
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

        }
    }

    /**
     * Metodo para hacer la llamda desde clsMenu. Para ello se declara e instancia un arraylist
     * que apunta a la interfaz itfProperty. Se recoje el array para copiar los objetos. Este metodo es
     * de relevancia ya que, una vez que el usuario se ha registrado.
     *
     * @return on objeto de tipo usuario
     */

    public ArrayList<itfProperty> leerUsuarios() {

        ArrayList<itfProperty> rUsuarios = new ArrayList<itfProperty>();

        for (clsUsuario usuario : listaUsuarios) {
            rUsuarios.add(usuario);
        }
        return rUsuarios;
    }

    private void cargarUsuarios(){

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
     * Métodos para anadir objetos de artículos al arraylist de articulos.
     * @param _fechaSP atributo de tipo Date
     * @param _nombreP atributos pelicula
     * @param _precioP atributos pelicula
     * @param _duracionP atributos pelicula
     * @param _pegiPelicula atributos pelicula
     * @param _puntuacionPelicula atributos pelicula
     */
    public void anadirPelicula(Date _fechaSP, String _nombreP, double _precioP, double _duracionP, int _pegiPelicula, int _puntuacionPelicula) {

        try {

            objDatos.conectarBD();

            clsPeliculas objPelicula = new clsPeliculas(_fechaSP, _nombreP, _precioP, _duracionP, _pegiPelicula, _puntuacionPelicula);
            listaPeliculas.add(objPelicula);
            objPelicula.setId(objDatos.insertarIdPelicula(_fechaSP, _nombreP, _precioP, _duracionP, _pegiPelicula, _puntuacionPelicula));

            objDatos.desconectarBD();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void anadirVideojuego(Date _fechaSV, String _nombreV, double _precioV, double _duracionV, int _puntuacionVidejuego, int _pegiVidejuego) throws SQLException, ClassNotFoundException {

        objDatos.conectarBD();

        clsVideojuegos objVidejuego = new clsVideojuegos(_fechaSV, _nombreV, _precioV, _duracionV, _puntuacionVidejuego, _pegiVidejuego);
        listaVidejuegos.add(objVidejuego);
        objVidejuego.setId(objDatos.insertarIdVideojuego(_fechaSV ,_nombreV, _precioV, _duracionV, _puntuacionVidejuego, _pegiVidejuego));
        objDatos.desconectarBD();
    }

    public void anadirMusica_CD(Date _fechaSM, String _nombreM, double _precioM, double _duracionM, int _anio, String _artista, String _explicito) throws SQLException, ClassNotFoundException {

        objDatos.conectarBD();

        clsMusica_CD objMusica = new clsMusica_CD(_fechaSM, _nombreM, _precioM, _duracionM, _anio, _artista, _explicito);
        listaMusica.add(objMusica);
        objMusica.setId(objDatos.insertarIdMusica(_fechaSM ,_nombreM,_precioM, _duracionM, _anio, _artista, _explicito ));

        objDatos.desconectarBD();
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
    public Date anadirFechaDev(int dias){

        return
    }
     */
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Metodo para levar a la clase clsMenu un arrayList que "copia" los objetos de el arraylist de articulos.
     *
     * @return leerPeliculas
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

    /**
     * Metodos para actualizar cargar actualizar los ArrayList obteniendo los datos de la base de datos
     * para que se inicien datos una vez se comienza el programa
     */
    private void cargarPeliculas(){

        int codigoConsulta = 1; // 1 para hacer select de peliculas
        try {
            objDatos.conectarBD();
            peliculasBaseDatos = objDatos.dameParametros(codigoConsulta);
            while (peliculasBaseDatos.next()){
                int id = peliculasBaseDatos.getInt(PELICULA_CODIGO_ID);
                java.sql.Date fechasql = peliculasBaseDatos.getDate(PELICULA_FECHA_DEV);
                String nombre = peliculasBaseDatos.getString(PELICULA_NOMBRE);
                double precio = peliculasBaseDatos.getDouble(PELICULA_PRECIO);
                double duracion = peliculasBaseDatos.getDouble(PELICULA_DURACION);
                int pegi = peliculasBaseDatos.getInt(PELICULA_PEGI);
                int puntuacion = peliculasBaseDatos.getInt(PELICULA_PUNTUACION);

                clsPeliculas objPeliculaBD = new clsPeliculas(id, fechasql,nombre, precio, duracion, pegi, puntuacion);
                listaPeliculas.add(objPeliculaBD);
            }
            objDatos.desconectarBD();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void cargarVideojuegos(){

        int codigoConsulta = 2; // 2 para hacer select de vidojuegos
        try {
            objDatos.conectarBD();
            videojuegosBaseDatos = objDatos.dameParametros(codigoConsulta);
            while (videojuegosBaseDatos.next()){
                int id = videojuegosBaseDatos.getInt(VIDEJUEGO_ID);
                java.sql.Date fechasql = videojuegosBaseDatos.getDate(VIDEOJUEGO_FECHA_DEV);
                String nombre = videojuegosBaseDatos.getString(VIDEOJUEGO_NOMBRE);
                double precio = videojuegosBaseDatos.getDouble(VIDEOJUEGO_PRECIO);
                double duracion = videojuegosBaseDatos.getDouble(VIDEOJUEGO_DURACION);
                int puntuacion = videojuegosBaseDatos.getInt(VIDEOJUEGO_PUNTUACION);
                int pegi = videojuegosBaseDatos.getInt(VIDEOJUEGO_PEGI);

                clsVideojuegos objVideojuegoBD = new clsVideojuegos(id, fechasql,nombre, precio, duracion, puntuacion, pegi);
                listaVidejuegos.add(objVideojuegoBD);
            }
            objDatos.desconectarBD();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void cargarMusica(){

        int codigoConsulta = 3; // 3 para hacer select de musica
        try {
            objDatos.conectarBD();
            musicaBaseDatos = objDatos.dameParametros(codigoConsulta);
            while (musicaBaseDatos.next()){
                int id = musicaBaseDatos.getInt(MUSICA_ID);
                java.sql.Date fechasql = musicaBaseDatos.getDate(MUSICA_FECHA_DEV);
                String nombre = musicaBaseDatos.getString(MUSICA_NOMBRE);
                double precio = musicaBaseDatos.getDouble(MUSICA_PRECIO);
                double duracion = musicaBaseDatos.getDouble(MUSICA_DURACION);
                int anio = musicaBaseDatos.getInt(MUSICA_ANIO);
                String artista = musicaBaseDatos.getString(MUSICA_ARTISTA);
                String explicito = musicaBaseDatos.getString(MUSICA_EXPLICITO);

                clsMusica_CD objMusicaBD = new clsMusica_CD(id, fechasql,nombre, precio, duracion, anio, artista, explicito);
                listaMusica.add(objMusicaBD);
            }
            objDatos.desconectarBD();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void cargarDatos(){

        cargarUsuarios();
        cargarPeliculas();
        cargarVideojuegos();
        cargarMusica();
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Metodos para visualizar el numero de articulos en la logica de presentacion
     * @return numero de peliculas, videojuegos y cds
     */

    public int visualizarNumPeliculas() {
      return listaPeliculas.size();
    }

    public int visualizarNumVideojuegos() {
        return listaVidejuegos.size();
    }

    public int visualizarNumCd() {
      return listaMusica.size();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Metodos para ordenar y leer los datos para la logica de presentacion
     * @return ArrayLists de los datos ordenados
     */
    public ArrayList<itfProperty> listaPeliculasPuntos(){

        clsPeliculasPtos peliculasPtos = new clsPeliculasPtos();
        Collections.sort(listaPeliculas, peliculasPtos);

        return leerPeliculasPuntos(listaPeliculas);
    }

    public ArrayList<itfProperty> leerPeliculasPuntos(ArrayList<clsPeliculas> _listaPeliculas) {

        ArrayList<itfProperty> rPeliculasPuntos = new ArrayList<itfProperty>();

        for (clsPeliculas pelicula : _listaPeliculas) {
            rPeliculasPuntos.add(pelicula);
        }
        return rPeliculasPuntos;
    }




    public ArrayList<itfProperty> listaVideojuegosPuntos(){

        clsVideojuegosPtos videojuegosPtos = new clsVideojuegosPtos();
        Collections.sort(listaVidejuegos, videojuegosPtos);

        return leerVideojuegosPuntos(listaVidejuegos);
    }

    public ArrayList<itfProperty> leerVideojuegosPuntos(ArrayList<clsVideojuegos> _listaVideojuegos){

        ArrayList<itfProperty> rVideojuegosPuntos = new ArrayList<itfProperty>();

        for (clsVideojuegos videojuego : _listaVideojuegos) {
            rVideojuegosPuntos.add(videojuego);
        }return rVideojuegosPuntos;
    }





    public ArrayList<itfProperty> listaMusicaAnio (){

        clsMusicaAnio musicaAnio = new clsMusicaAnio();
        Collections.sort(listaMusica, musicaAnio);

        return leerMusicaAnios(listaMusica);
    }

    public ArrayList<itfProperty> leerMusicaAnios(ArrayList<clsMusica_CD> _listaMusica) {

        ArrayList<itfProperty> rMusicaAnios = new ArrayList<itfProperty>();

        for (clsMusica_CD musica_cd : _listaMusica){
            rMusicaAnios.add(musica_cd);
        }
        return rMusicaAnios;
    }

    public void anadirAlquilerP(int id, Date fechaDev2){

    }

}


