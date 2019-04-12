package com.company.LD;


import java.sql.*;

import static com.company.COMUN.clsConstantes.MENSAJE_ERROR;
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

    public int insertarCodigoUsuario(String identificador,String contrasena ) throws Exception {
        Object[] parametrosUsuario = {identificador, contrasena};
        return clsUsuarioBD.insertarUsuario(objConexion, objStatements, objRS, parametrosUsuario);
    }

    public int insertarIdPelicula(String nombreP, double precioP, double duracionP, int pegiPelicula, int puntuacionPelicula) throws SQLException {
        Object[] parametrosPeliculas = {nombreP, precioP, duracionP, pegiPelicula, puntuacionPelicula};
        return clsPeliculasBD.insertarPelicula(objConexion, objStatements, objRS, parametrosPeliculas);
    }

    public int insertarIdVidejuego(String nombreV, double precioV, double duracionV, int puntuacionVidejuego, int pegiVidejuego) throws SQLException {
        Object[] parametrosVideojuegos = {nombreV, precioV, duracionV, puntuacionVidejuego, pegiVidejuego};
        return clsVideojuegosBD.insertarVieojuego(objConexion, objStatements, objRS, parametrosVideojuegos);
    }

    public int insertarIdMusica(String nombreM, double precioM, double duracionM, int anio, String artista, String explicito) throws SQLException {
        Object[] parametrosMusica ={nombreM, precioM, duracionM, anio, artista, explicito};
        return clsMusicaBD.insertarMusica(objConexion, objStatements, objRS, parametrosMusica);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

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
