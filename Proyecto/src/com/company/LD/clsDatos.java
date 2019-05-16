package com.company.LD;


import java.sql.*;
import java.util.Date;


import static com.company.LD.clsConstantesBD.*;

/**
 * Clase que cominucara los parametros entre la logica de negocio
 * y la logica de presentación
 */
public class clsDatos {

    /**
     * Atributo para la conexion a la base de datos, un objeto
     * de tipo Connection
     */
    private Connection objConexion = null;

    /**
     * Objeto para rear la consulta
     */
    private PreparedStatement objStatements = null;

    /**
     * Objeto para devolver un resultado de consulta
     */

    private ResultSet objRS = null;

    /**
     * Metodo para establecer la conexion, antes se encontraba
     * * en clsConexion
     *
     * @return objConexion
     * @throws SQLException           excepciones
     * @throws ClassNotFoundException excepciones de clase
     */
    public Connection conectarBD() throws SQLException, ClassNotFoundException {

        try {

            Class.forName(DRIVER).newInstance();
            objConexion = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException ignored) {
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
        return objConexion;
    }

    /**
     * Funcion para desconectar de la base de datos
     *
     * @throws SQLException excepeciones
     */
    public void desconectarBD() throws SQLException {
        objConexion.close();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Metodos para insertar datos de cada articulo al mismo tiempo que se obtiene su id (primary key)
     * que es autoincremental
     *
     */

    public int insertarCodigoUsuario(String _id, String _contra, String _nombre,String _apellidos,String _correoE,String _numeroTarjeta,
                                     Date _fechaNacimiento, double _costeTotal, boolean _suscripcion) throws Exception {
        Object[] parametrosUsuario = {_id, _contra, _nombre, _apellidos, _correoE, _numeroTarjeta, _fechaNacimiento, _costeTotal, _suscripcion};
        return clsUsuarioBD.insertarUsuario(objConexion, objStatements, objRS, parametrosUsuario);
    }

    public int insertarIdPelicula(Date fechaSP, String nombreP, double precioP, double duracionP, int pegiPelicula, int puntuacionPelicula) throws SQLException {
        Object[] parametrosPeliculas = {fechaSP, nombreP, precioP, duracionP, pegiPelicula, puntuacionPelicula};
        return clsPeliculasBD.insertarPelicula(objConexion, objStatements, objRS, parametrosPeliculas);
    }

    public int insertarIdVideojuego(Date fechaSV, String nombreV, double precioV, double duracionV, int puntuacionVidejuego, int pegiVidejuego) throws SQLException {
        Object[] parametrosVideojuegos = {fechaSV, nombreV, precioV, duracionV, puntuacionVidejuego, pegiVidejuego};
        return clsVideojuegosBD.insertarVideojuego(objConexion, objStatements, objRS, parametrosVideojuegos);
    }

    public int insertarIdMusica(Date fechaSM, String nombreM, double precioM, double duracionM, int anio, String artista, String explicito) throws SQLException {
        Object[] parametrosMusica = {fechaSM, nombreM, precioM, duracionM, anio, artista, explicito};
        return clsMusicaBD.insertarMusica(objConexion, objStatements, objRS, parametrosMusica);
    }

    public int insertarAlquilerP(int codigo, int id, Date fechaDev) throws SQLException {
        Object[] parametrosAlquilerP = {codigo, id, fechaDev};
        return clsAlquilarPeliculasBD.insertAlquilerP(objConexion, objStatements, objRS, parametrosAlquilerP);
    }

    public int insertarAlquilerV(int codigo, int id, Date fechaDev) throws SQLException {
        Object[] parametrosAlquilerV = {codigo, id, fechaDev};
        return clsAlquilarVideojuegosBD.insertAlquilerV(objConexion, objStatements, objRS, parametrosAlquilerV);
    }

    public int insertarAlquilerM(int codigo, int id, Date fechaDev) throws SQLException {
        Object[] parametrosAlquilerM = {codigo, id, fechaDev};
        return clsAlquilarMusicaBD.insertAlquilerM(objConexion, objStatements, objRS, parametrosAlquilerM);
    }


    public void eliminarAlquilerP(int _idAlquiler) throws SQLException {
        clsAlquilarPeliculasBD.deletePelicula(objConexion, objStatements, objRS, _idAlquiler);
    }

    public void eliminarAlquilerV(int _idAlquiler) throws SQLException {
        clsAlquilarVideojuegosBD.deleteVideojuego(objConexion, objStatements, objRS, _idAlquiler);
    }

    public void eliminarAlquilerM(int _idAlquiler) throws SQLException {
        clsAlquilarMusicaBD.deleteMusica(objConexion, objStatements, objRS, _idAlquiler);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Metodo para Resulset, obtener los parametros de las diferentes clases, se filtra para cargar los que se desea
     * con un codigo propio
     *
     * @param _codigoConsulta entrero propio de cada clase
     * @return String de parametros de base de datos
     */

    public ResultSet dameParametros(int _codigoConsulta) {

        if (_codigoConsulta == 0) {
            return clsUsuarioBD.consultaUsuario(objConexion, objStatements, objRS);
        } else if (_codigoConsulta == 1) {
            return clsPeliculasBD.consultaPelicula(objConexion, objStatements, objRS);
        } else if (_codigoConsulta == 2) {
            return clsVideojuegosBD.consultaVideojuego(objConexion, objStatements, objRS);
        } else if (_codigoConsulta == 3) {
            return clsMusicaBD.consultaMusica(objConexion, objStatements, objRS);
        } else if (_codigoConsulta == 4) {
            return clsAlquilarPeliculasBD.consultaAlquilerP(objConexion, objStatements, objRS);
        } else if (_codigoConsulta == 5) {
            return clsAlquilarVideojuegosBD.consultaAlquilerV(objConexion, objStatements, objRS);
        } else if (_codigoConsulta == 6) {
            return clsAlquilarMusicaBD.consultaAlquilerM(objConexion, objStatements, objRS);
        } else {
            return null;
        }
    }

}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

