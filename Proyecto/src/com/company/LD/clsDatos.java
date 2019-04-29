package com.company.LD;


import java.sql.*;
import java.util.Date;


import static com.company.LD.clsConstantesBD.*;

/**
 *Clase que cominucara los parametros entre la logica de negocio
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
     *      * en clsConexion
     * @return objConexion
     * @throws SQLException excepciones
     * @throws ClassNotFoundException excepciones de clase
     */
    public Connection conectarBD() throws SQLException, ClassNotFoundException {

        try {

            Class.forName(DRIVER).newInstance();
            objConexion = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return objConexion;
    }

    /**
     * Funcion para desconectar de la base de datos
     * @throws SQLException excepeciones
     */
    public void desconectarBD() throws SQLException {
        objConexion.close();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Metodos para insertar datos de cada articulo al mismo tiempo que se obtiene su id (primary key)
     * que es autoincremental
     * @param identificador artributo de nombre de usuario
     * @param contrasena atributo de contrasena de usuario
     * @return entrero
     * @throws Exception propia de SQL
     */

    public int insertarCodigoUsuario(String identificador,String contrasena ) throws Exception {
        Object[] parametrosUsuario = {identificador, contrasena};
        return clsUsuarioBD.insertarUsuario(objConexion, objStatements, objRS, parametrosUsuario);
    }

    public int insertarIdPelicula(Date fechaSP, String nombreP, double precioP, double duracionP, int pegiPelicula, int puntuacionPelicula) throws SQLException {
        Object[] parametrosPeliculas = {fechaSP, nombreP, precioP, duracionP, pegiPelicula, puntuacionPelicula};
        return clsPeliculasBD.insertarPelicula(objConexion, objStatements, objRS, parametrosPeliculas);
    }

    public int insertarIdVidejuego(Date fechaSV, String nombreV, double precioV, double duracionV, int puntuacionVidejuego, int pegiVidejuego) throws SQLException {
        Object[] parametrosVideojuegos = {fechaSV, nombreV, precioV, duracionV, puntuacionVidejuego, pegiVidejuego};
        return clsVideojuegosBD.insertarVieojuego(objConexion, objStatements, objRS, parametrosVideojuegos);
    }

    public int insertarIdMusica(Date fechaSM, String nombreM, double precioM, double duracionM, int anio, String artista, String explicito) throws SQLException {
        Object[] parametrosMusica ={fechaSM, nombreM, precioM, duracionM, anio, artista, explicito};
        return clsMusicaBD.insertarMusica(objConexion, objStatements, objRS, parametrosMusica);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Metodo para Resulset, obtener los parametros de las diferentes clases, se filtra para cargar los que se desea
     * con un codigo propio
     * @param _codigoConsulta entrero propio de cada clase
     * @return String de parametros de base de datos
     */

    public ResultSet dameParametros(int _codigoConsulta){

        if (_codigoConsulta == 0){
            return clsUsuarioBD.consultaUsuario(objConexion,objStatements, objRS);
        }else if (_codigoConsulta == 1){
            return clsPeliculasBD.consultaPelicula(objConexion,objStatements, objRS);
        }else if (_codigoConsulta == 2){
            return clsVideojuegosBD.consultaVideojuego(objConexion,objStatements, objRS);
        }else if (_codigoConsulta == 3){
            return clsMusicaBD.consultaMusica(objConexion,objStatements, objRS);
        }else {
            return null;
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
