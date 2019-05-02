package com.company.LD;

import java.sql.*;
import static com.company.LD.clsConstantesBD.INSERT_PELICULA;
import static com.company.LD.clsConstantesBD.SELECT_PELICULAS;

/**
 * Clase para insertar parametros en la base de datos y consultar los mismos de articulos peliculas
 */
public class clsPeliculasBD {

    /**
     * Metedo para insertar parametros de en la base de datos
     * @param objCon objeto de la conexion
     * @param objStat objeto de los statments
     * @param objRS objeto los resultados
     * @param parametrosPeliculas parametros propio de la clase clsPeliculas
     * @return codigo id de musica ascendente
     * @throws SQLException excepcion propia
     */
    public static int insertarPelicula(Connection objCon, PreparedStatement objStat, ResultSet objRS, Object[] parametrosPeliculas) throws SQLException {

        int regActualizada = 0;
        int idP = 0;

        objStat = objCon.prepareStatement(INSERT_PELICULA, PreparedStatement.RETURN_GENERATED_KEYS);

        java.util.Date fechaS = (java.util.Date) parametrosPeliculas[0];
        java.sql.Date fechasql = new java.sql.Date(fechaS.getTime());

        objStat.setDate(1, fechasql, java.util.Calendar.getInstance()); //fecha salida
        objStat.setString(2,(String) parametrosPeliculas [1]); //nombre
        objStat.setDouble(3, (Double) parametrosPeliculas [2]);//precio
        objStat.setDouble(4, (Double) parametrosPeliculas [3]);//duración
        objStat.setInt(5, (Integer) parametrosPeliculas [4]);//pegi
        objStat.setInt(6, (Integer) parametrosPeliculas [5]);//puntuación
        regActualizada = objStat.executeUpdate();

        if (regActualizada == 1) {

            objRS = objStat.getGeneratedKeys();

            if (objRS.next()) {

                idP = objRS.getInt(1);
            }
        }
        return idP;
    }
    /**
     * Metodo para consultar datos, obtenerlos. Parametros de clase clsPelicula
     * @param _objCon objeto de la conexion
     * @param _objStat objeto de los statments
     * @param _objRS objeto los resultados
     * @return resulset
     */
    public static ResultSet consultaPelicula(Connection _objCon, PreparedStatement _objStat, ResultSet _objRS){

        try {
            _objStat = _objCon.prepareStatement(SELECT_PELICULAS);
            _objRS = _objStat.executeQuery(SELECT_PELICULAS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return _objRS;
    }
}
