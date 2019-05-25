package com.company.LN;

import com.company.COMUN.itfProperty;
import com.company.EXCEPCIONES.clsIdAlquilerRepetido;
import com.company.LD.clsDatos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
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
    private ArrayList<clsAlquilarPeliculas> listaAlquilerPelis = new ArrayList<>();
    private ArrayList<clsAlquilarVideojuegos> listaAlquilerVidejuegos = new ArrayList<>();
    private ArrayList<clsAlquilarMusica> listaAlquilerMusica = new ArrayList<>();


    /**
     * Parametros de mysql
     */
    private ResultSet usuariosBaseDatos;
    private ResultSet peliculasBaseDatos;
    private ResultSet videojuegosBaseDatos;
    private ResultSet musicaBaseDatos;
    private ResultSet alquilerPeliculasBD;
    private ResultSet alquilerVidejuegosBD;
    private ResultSet alquilerMusicaBD;

    /**
     * Se instancia un objeto para crear la comunicacion con la logica de datos
     */
    private clsDatos objDatos = new clsDatos();


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Con este metodo se visualiza el numero de usuarios dados de alta.
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


    private double calculoCosteTotal(boolean _estadoSuscipcion) {

        double costeTotal = 0;
        if (_estadoSuscipcion == false) {
            for (clsAlquilarPeliculas alquilerPelicula : listaAlquilerPelis) {
                for (clsPeliculas pelicula : listaPeliculas) {
                    if (pelicula.getId() == alquilerPelicula.getPeliculas_id()) {
                        costeTotal = costeTotal + pelicula.getPrecio();
                    }
                }
            }
            for (clsAlquilarVideojuegos alquilerVideojuego : listaAlquilerVidejuegos) {
                for (clsVideojuegos videojuego : listaVidejuegos) {
                    if (videojuego.getId() == alquilerVideojuego.getVideojuego_id()) {
                        costeTotal = costeTotal + videojuego.getPrecio();
                    }
                }
            }
            for (clsAlquilarMusica alquilerMusica : listaAlquilerMusica) {
                for (clsMusica_CD cd : listaMusica) {
                    if (cd.getId() == alquilerMusica.getMusica_id()) {
                        costeTotal = costeTotal + cd.getPrecio();
                    }
                }
            }
        } else if (_estadoSuscipcion == true) {
            costeTotal = 40;
        }
        return costeTotal;
    }


    public void anadirUsuario(String _id, String _contra, String _nombre, String _apellidos, String _correoE,
                              String _numeroTarjeta, Date _fechaNacimiento, boolean _suscripcion, Date fechaHoy) {

        try {

            objDatos.conectarBD();

            clsUsuario objUsuario = new clsUsuario(_id, _contra, _nombre, _apellidos, _correoE,
                    _numeroTarjeta, _fechaNacimiento, calculoCosteTotal(_suscripcion), false, fechaHoy);
            listaUsuarios.add(objUsuario);
            objUsuario.setCodigoAleatoria(objDatos.insertarCodigoUsuario(_id, _contra, _nombre, _apellidos, _correoE,
                    _numeroTarjeta, _fechaNacimiento, 0, false, fechaHoy));


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

    private void cargarUsuarios() {

        int codigoConsulta = 0; // 0 para hacer select de usuarios
        try {
            objDatos.conectarBD();
            usuariosBaseDatos = objDatos.dameParametros(codigoConsulta);
            while (usuariosBaseDatos.next()) {
                int id = usuariosBaseDatos.getInt(USUARIO_CODIGO_ID);
                String identificador = usuariosBaseDatos.getString(USUARIO_IDENTIFICADOR);
                String contrasena = usuariosBaseDatos.getString(USUARIO_CONTRASENA);
                String nombre = usuariosBaseDatos.getString(USUARIO_NOMBRE);
                String apellidos = usuariosBaseDatos.getString(USUARIO_APELLIDOS);
                String correoE = usuariosBaseDatos.getString(USUARIO_CORREO);
                String numeroTarjeta = usuariosBaseDatos.getString(USUARIO_TARJETA);
                java.sql.Date fechaNacimiento = usuariosBaseDatos.getDate(USUARIO_FECHA_NACIMINETO);
                double costeTotal = usuariosBaseDatos.getDouble(USUARIO_COSTE_TOTAL);
                boolean suscripcion = usuariosBaseDatos.getBoolean(USUARIO_SUSCRIPCION);
                java.sql.Date fechaSuscripcion = usuariosBaseDatos.getDate(USUARIO_FECHA_SUSCRIPCION);

                clsUsuario objUsuario = new clsUsuario(id, identificador, contrasena, nombre, apellidos, correoE, numeroTarjeta,
                        fechaNacimiento, costeTotal, suscripcion, fechaSuscripcion);
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

            Collections.sort(listaPeliculas);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void anadirVideojuego(Date _fechaSV, String _nombreV, double _precioV, double _duracionV, int _puntuacionVidejuego, int _pegiVidejuego) throws SQLException, ClassNotFoundException {

        objDatos.conectarBD();

        clsVideojuegos objVidejuego = new clsVideojuegos(_fechaSV, _nombreV, _precioV, _duracionV, _puntuacionVidejuego, _pegiVidejuego);
        listaVidejuegos.add(objVidejuego);
        objVidejuego.setId(objDatos.insertarIdVideojuego(_fechaSV, _nombreV, _precioV, _duracionV, _puntuacionVidejuego, _pegiVidejuego));
        objDatos.desconectarBD();
    }

    public void anadirMusica_CD(Date _fechaSM, String _nombreM, double _precioM, double _duracionM, int _anio, String _artista, String _explicito) throws SQLException, ClassNotFoundException {

        objDatos.conectarBD();

        clsMusica_CD objMusica = new clsMusica_CD(_fechaSM, _nombreM, _precioM, _duracionM, _anio, _artista, _explicito);
        listaMusica.add(objMusica);
        objMusica.setId(objDatos.insertarIdMusica(_fechaSM, _nombreM, _precioM, _duracionM, _anio, _artista, _explicito));

        objDatos.desconectarBD();
    }

    public void anadirAlquilerP(String indentificador, int _id, Date _fechaDev) throws SQLException, ClassNotFoundException {

        objDatos.conectarBD();

        try {
            for (clsPeliculas pelicula : listaPeliculas) {
                for (clsUsuario usuario : listaUsuarios) {
                    if (indentificador.equals(usuario.getPropertyU(USUARIO_IDENTIFICADOR)) && _id == pelicula.getId() && compararIdAlquilerP(_id) == true) {

                        //int codigo = usuario.getCodigoAleatoria();
                        clsAlquilarPeliculas objAP = new clsAlquilarPeliculas(usuario.getCodigoAleatoria(), _id, _fechaDev);
                        listaAlquilerPelis.add(objAP);
                        objAP.setIdAlquiler(objDatos.insertarAlquilerP(usuario.getCodigoAleatoria(), _id, _fechaDev));

                        usuario.setCosteTotal(usuario.getCosteTotal() + pelicula.getPrecio());
                        System.out.println(usuario.getCosteTotal());
                        objDatos.insertarUpdateCoste(usuario.getCosteTotal(), usuario.getCodigoAleatoria());
                    }
                }
            }
        } catch (clsIdAlquilerRepetido id) {
            id.mensajeIdRpetido();
        }
        objDatos.desconectarBD();
    }


    public void anadirAlquilerV(String indentificador, int _id, Date _fechaDev) throws SQLException, ClassNotFoundException {

        objDatos.conectarBD();

        for (clsVideojuegos videojuego : listaVidejuegos) {
            for (clsUsuario usuario : listaUsuarios) {
                if (indentificador.equals(usuario.getPropertyU(USUARIO_IDENTIFICADOR)) && _id == videojuego.getId() && compararIdAlquilerV(_id) == true) {

                    //int codigo = usuario.getCodigoAleatoria();
                    clsAlquilarVideojuegos objAV = new clsAlquilarVideojuegos(usuario.getCodigoAleatoria(), _id, _fechaDev);
                    listaAlquilerVidejuegos.add(objAV);
                    objAV.setIdAlquiler(objDatos.insertarAlquilerV(usuario.getCodigoAleatoria(), _id, _fechaDev));

                    usuario.setCosteTotal(usuario.getCosteTotal() + videojuego.getPrecio());
                    System.out.println(usuario.getCosteTotal());
                    //UPDATE de coste total en la base de datos
                    objDatos.insertarUpdateCoste(usuario.getCosteTotal(), usuario.getCodigoAleatoria());
                }
            }
        }
        objDatos.desconectarBD();
    }

    public void anadirAlquilerM(String indentificador, int _id, Date _fechaDev) throws SQLException, ClassNotFoundException {

        objDatos.conectarBD();

        for (clsMusica_CD cd : listaMusica) {
            for (clsUsuario usuario : listaUsuarios) {
                if (indentificador.equals(usuario.getPropertyU(USUARIO_IDENTIFICADOR)) && _id == cd.getId() && compararIdAlquilerM(_id) == true) {

                    //int codigo = usuario.getCodigoAleatoria();
                    clsAlquilarMusica objAM = new clsAlquilarMusica(usuario.getCodigoAleatoria(), _id, _fechaDev);
                    listaAlquilerMusica.add(objAM);
                    objAM.setIdAlquiler(objDatos.insertarAlquilerM(usuario.getCodigoAleatoria(), _id, _fechaDev));
                    System.out.println(usuario.getCosteTotal());

                    usuario.setCosteTotal(usuario.getCosteTotal() + cd.getPrecio());
                    System.out.println(usuario.getCosteTotal());
                    //UPDATE de coste total en la base de datos
                    objDatos.insertarUpdateCoste(usuario.getCosteTotal(), usuario.getCodigoAleatoria());
                }
            }
        }
        objDatos.desconectarBD();
    }

    private boolean compararIdAlquilerP(int _idRecogido) {

        boolean retorno = true;
        for (clsAlquilarPeliculas alquilerPelicula : listaAlquilerPelis) {
            if (alquilerPelicula.getPeliculas_id() == _idRecogido) {
                retorno = false;
            }
        }
        return retorno;
    }

    private boolean compararIdAlquilerV(int _idRecogido) {

        boolean retorno = true;
        for (clsAlquilarVideojuegos alquilerVideojuego : listaAlquilerVidejuegos) {
            if (alquilerVideojuego.getVideojuego_id() == _idRecogido) {
                retorno = false;
            }
        }
        return retorno;
    }

    private boolean compararIdAlquilerM(int _idRecogido) {

        boolean retorno = true;
        for (clsAlquilarMusica alquilerMusica : listaAlquilerMusica) {
            if (alquilerMusica.getMusica_id() == _idRecogido) {
                retorno = false;
            }
        }
        return retorno;
    }

    public void anadirSuscripcion(String identificador) {

        try {
            objDatos.conectarBD();

            for (clsUsuario usuario : listaUsuarios) {
                if (usuario.getIdentificador().equals(identificador)) {
                    usuario.setSuscripcion(true);
                    usuario.setCosteTotal(calculoCosteTotal(usuario.isSuscripcion()));
                    usuario.setFechaSuscripcion(calcularFechaSuscripcion());
                    objDatos.insertarUpdateAltaS(usuario.getCodigoAleatoria(), usuario.isSuscripcion(),
                            usuario.getFechaSuscripcion(), calculoCosteTotal(usuario.isSuscripcion()));
                }
            }
            objDatos.desconectarBD();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void comprobarSuscripcion() {
        Date fechaHoy = new Date();
        for (clsUsuario usuario : listaUsuarios) {
            if (usuario.getFechaSuscripcion().compareTo(fechaHoy) < 0) {
                usuario.setSuscripcion(false);
                objDatos.insertarUpdateBajaS(usuario.isSuscripcion(), usuario.getCodigoAleatoria());

            }
        }
    }

    private Date calcularFechaSuscripcion() {

        Date fechaDev2 = null;
        try {
            Date fechaHoy = new Date();
            SimpleDateFormat miFormato = new SimpleDateFormat("dd/MM/yyyy");
            Calendar calendario = Calendar.getInstance();
            calendario.setTime(fechaHoy);
            calendario.add(Calendar.DATE, 30);
            String fechaDevS = miFormato.format(calendario.getTime());
            fechaDev2 = new SimpleDateFormat("dd/MM/yyyy").parse(fechaDevS);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return fechaDev2;
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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
    private void cargarPeliculas() {

        int codigoConsulta = 1; // 1 para hacer select de peliculas
        try {
            objDatos.conectarBD();
            peliculasBaseDatos = objDatos.dameParametros(codigoConsulta);
            while (peliculasBaseDatos.next()) {
                int id = peliculasBaseDatos.getInt(PELICULA_CODIGO_ID);
                java.sql.Date fechasql = peliculasBaseDatos.getDate(PELICULA_FECHA_SALIDA);
                String nombre = peliculasBaseDatos.getString(PELICULA_NOMBRE);
                double precio = peliculasBaseDatos.getDouble(PELICULA_PRECIO);
                double duracion = peliculasBaseDatos.getDouble(PELICULA_DURACION);
                int pegi = peliculasBaseDatos.getInt(PELICULA_PEGI);
                int puntuacion = peliculasBaseDatos.getInt(PELICULA_PUNTUACION);

                clsPeliculas objPeliculaBD = new clsPeliculas(id, fechasql, nombre, precio, duracion, pegi, puntuacion);
                listaPeliculas.add(objPeliculaBD);
            }
            objDatos.desconectarBD();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void cargarVideojuegos() {

        int codigoConsulta = 2; // 2 para hacer select de vidojuegos
        try {
            objDatos.conectarBD();
            videojuegosBaseDatos = objDatos.dameParametros(codigoConsulta);
            while (videojuegosBaseDatos.next()) {
                int id = videojuegosBaseDatos.getInt(VIDEJUEGO_ID);
                java.sql.Date fechasql = videojuegosBaseDatos.getDate(VIDEOJUEGO_FECHA_SALIDA);
                String nombre = videojuegosBaseDatos.getString(VIDEOJUEGO_NOMBRE);
                double precio = videojuegosBaseDatos.getDouble(VIDEOJUEGO_PRECIO);
                double duracion = videojuegosBaseDatos.getDouble(VIDEOJUEGO_DURACION);
                int puntuacion = videojuegosBaseDatos.getInt(VIDEOJUEGO_PUNTUACION);
                int pegi = videojuegosBaseDatos.getInt(VIDEOJUEGO_PEGI);

                clsVideojuegos objVideojuegoBD = new clsVideojuegos(id, fechasql, nombre, precio, duracion, puntuacion, pegi);
                listaVidejuegos.add(objVideojuegoBD);
            }
            objDatos.desconectarBD();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void cargarMusica() {

        int codigoConsulta = 3; // 3 para hacer select de musica
        try {
            objDatos.conectarBD();
            musicaBaseDatos = objDatos.dameParametros(codigoConsulta);
            while (musicaBaseDatos.next()) {
                int id = musicaBaseDatos.getInt(MUSICA_ID);
                java.sql.Date fechasql = musicaBaseDatos.getDate(MUSICA_FECHA_SALIDA);
                String nombre = musicaBaseDatos.getString(MUSICA_NOMBRE);
                double precio = musicaBaseDatos.getDouble(MUSICA_PRECIO);
                double duracion = musicaBaseDatos.getDouble(MUSICA_DURACION);
                int anio = musicaBaseDatos.getInt(MUSICA_ANIO);
                String artista = musicaBaseDatos.getString(MUSICA_ARTISTA);
                String explicito = musicaBaseDatos.getString(MUSICA_EXPLICITO);

                clsMusica_CD objMusicaBD = new clsMusica_CD(id, fechasql, nombre, precio, duracion, anio, artista, explicito);
                listaMusica.add(objMusicaBD);
            }
            objDatos.desconectarBD();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void cargarAlquilerP() {

        int codigoConsulta = 4; // 4 para hacer select de alquiler peliculas
        try {
            objDatos.conectarBD();
            alquilerPeliculasBD = objDatos.dameParametros(codigoConsulta);
            while (alquilerPeliculasBD.next()) {
                int idAquiler = alquilerPeliculasBD.getInt(ALQUILER_PELICULA_ID);
                int usuarios_codigo = alquilerPeliculasBD.getInt(ALQUILER_PELICULA_USUARIOS_CODIGO);
                int pelicula_id = alquilerPeliculasBD.getInt(ALQUILER_PELICULA_ID_PROPIA);
                java.sql.Date fechasqlP = alquilerPeliculasBD.getDate(ALQUILER_PELICULA_FECHADEV);

                clsAlquilarPeliculas objAlquilerPBD = new clsAlquilarPeliculas(idAquiler, usuarios_codigo, pelicula_id, fechasqlP);
                listaAlquilerPelis.add(objAlquilerPBD);
            }
            objDatos.desconectarBD();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void cargarAlquilerV() {

        int codigoConsulta = 5; // 5 para hacer select de alquiler videojuego
        try {
            objDatos.conectarBD();
            alquilerVidejuegosBD = objDatos.dameParametros(codigoConsulta);
            while (alquilerVidejuegosBD.next()) {
                int idAquiler = alquilerVidejuegosBD.getInt(ALQUILER_VIDEOJUEGO_ID);
                int usuarios_codigo = alquilerVidejuegosBD.getInt(ALQUILER_VIDEOJUEGO_USUARIOS_CODIGO);
                int videojuego_id = alquilerVidejuegosBD.getInt(ALQUILER_VIDEOJUEGO_ID_PROPIA);
                java.sql.Date fechasqlV = alquilerVidejuegosBD.getDate(ALQUILER_VIDEOJUEGO_FECHADEV);

                clsAlquilarVideojuegos objAlquilerVBD = new clsAlquilarVideojuegos(idAquiler, usuarios_codigo, videojuego_id, fechasqlV);
                listaAlquilerVidejuegos.add(objAlquilerVBD);
            }
            objDatos.desconectarBD();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void cargarAlquilerM() {

        int codigoConsulta = 6; // 6 para hacer select de alquiler musica
        try {
            objDatos.conectarBD();
            alquilerMusicaBD = objDatos.dameParametros(codigoConsulta);
            while (alquilerMusicaBD.next()) {
                int idAquiler = alquilerMusicaBD.getInt(ALQUILER_MUSICA_ID);
                int usuarios_codigo = alquilerMusicaBD.getInt(ALQUILER_MUSICA_USUARIOS_CODIGO);
                int musica_id = alquilerMusicaBD.getInt(ALQUILER_MUSICA_ID_PROPIA);
                java.sql.Date fechasqlM = alquilerMusicaBD.getDate(ALQUILER_MUSICA_FECHADEV);

                clsAlquilarMusica objAlquilerMBD = new clsAlquilarMusica(idAquiler, usuarios_codigo, musica_id, fechasqlM);
                listaAlquilerMusica.add(objAlquilerMBD);
            }
            objDatos.desconectarBD();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public void cargarDatos() {

        cargarUsuarios();
        comprobarSuscripcion();
        cargarPeliculas();
        cargarVideojuegos();
        cargarMusica();
        cargarAlquilerP();
        cargarAlquilerV();
        cargarAlquilerM();
        eliminarAlquiler();


    }

    private void eliminarAlquiler() {

        try {
            objDatos.conectarBD();
            Date fechaHoy = new Date();

            for (clsAlquilarPeliculas alquilerPelicula : listaAlquilerPelis) {
                if (alquilerPelicula.getFecha_DevolucionP().compareTo(fechaHoy) < 0) {
                    objDatos.eliminarAlquilerP(alquilerPelicula.getIdAlquiler());
                    listaAlquilerPelis.remove(alquilerPelicula);
                }
            }

            for (clsAlquilarVideojuegos alquilerVideojuego : listaAlquilerVidejuegos) {
                if (alquilerVideojuego.getFecha_DevolucionV().compareTo(fechaHoy) < 0) {
                    objDatos.eliminarAlquilerV(alquilerVideojuego.getIdAlquiler());
                    listaAlquilerVidejuegos.remove(alquilerVideojuego);
                }
            }

            for (clsAlquilarMusica alquilerCd : listaAlquilerMusica) {
                if (alquilerCd.getFecha_DevolucionM().compareTo(fechaHoy) < 0) {
                    objDatos.eliminarAlquilerM(alquilerCd.getIdAlquiler());
                    listaAlquilerMusica.remove(alquilerCd);
                }
            }
            objDatos.desconectarBD();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Metodos para visualizar el numero de articulos en la logica de presentacion
     *
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


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Metodos para ordenar y leer los datos para la logica de presentacion
     *
     * @return ArrayLists de los datos ordenados
     */
    public ArrayList<itfProperty> listaPeliculasPuntos() {

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


    public ArrayList<itfProperty> listaVideojuegosPuntos() {

        clsVideojuegosPtos videojuegosPtos = new clsVideojuegosPtos();
        Collections.sort(listaVidejuegos, videojuegosPtos);

        return leerVideojuegosPuntos(listaVidejuegos);
    }

    public ArrayList<itfProperty> leerVideojuegosPuntos(ArrayList<clsVideojuegos> _listaVideojuegos) {

        ArrayList<itfProperty> rVideojuegosPuntos = new ArrayList<itfProperty>();

        for (clsVideojuegos videojuego : _listaVideojuegos) {
            rVideojuegosPuntos.add(videojuego);
        }
        return rVideojuegosPuntos;
    }


    public ArrayList<itfProperty> listaMusicaAnio() {

        clsMusicaAnio musicaAnio = new clsMusicaAnio();
        Collections.sort(listaMusica, musicaAnio);

        return leerMusicaAnios(listaMusica);
    }

    public ArrayList<itfProperty> leerMusicaAnios(ArrayList<clsMusica_CD> _listaMusica) {

        ArrayList<itfProperty> rMusicaAnios = new ArrayList<itfProperty>();

        for (clsMusica_CD musica_cd : _listaMusica) {
            rMusicaAnios.add(musica_cd);
        }
        return rMusicaAnios;
    }
}
