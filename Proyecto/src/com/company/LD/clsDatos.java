package com.company.LD;


import java.sql.*;

import static com.company.LD.clsConstantesBD.*;

/**
 *Clase que cominucará los parámetros entre la lógica de negocio
 * y la lógica de presentación
 */
public class clsDatos {

    /**
     * Atributo para la conexión a la base de datos, un objeto
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
     * Método para establecer la conexión, antes se encontraba
     * en clsConexión
     * @throws SQLException
     */
    public Connection conectarBD() throws SQLException, ClassNotFoundException {

        try {

            Class.forName(DRIVER).newInstance();
            objConexion = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Ha fallado la conexión" + e);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
        return objConexion;
    }

    /**
     * Función para desconectar de la base de datos
     * @throws SQLException
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
        return clsPeliculasBD.insertarPelicula(objConexion, parametrosPeliculas);
    }

    public int insertarIdVidejuego(String nombreV, double precioV, double duracionV, int puntuacionVidejuego, int pegiVidejuego) throws SQLException {
        Object[] parametrosVideojuegos = {nombreV, precioV, duracionV, puntuacionVidejuego, pegiVidejuego};
        return clsVideojuegosBD.insertarVieojuego(objConexion, parametrosVideojuegos);
    }

    public int insertarIdMusica(String nombreM, double precioM, double duracionM, int anio, String artista, String explicito) throws SQLException {
        Object[] parametrosMusica ={nombreM, precioM, duracionM, anio, artista, explicito};
        return clsMusicaBD.insertarMusica(objConexion, parametrosMusica);
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