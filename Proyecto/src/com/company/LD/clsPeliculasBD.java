package com.company.LD;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;

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

/**
        objStat.setDate(1, (java.util.Date) parametrosPeliculas [0]); //fecha salida
        objStat.setString(2,(String) parametrosPeliculas [1]); //nombre
        objStat.setDouble(3, (Double) parametrosPeliculas [2]);//precio
        objStat.setDouble(4, (Double) parametrosPeliculas [3]);//duración
        objStat.setInt(5, (Integer) parametrosPeliculas [4]);//pegi
        objStat.setInt(6, (Integer) parametrosPeliculas [5]);//puntuación
        regActualizada = objStat.executeUpdate();

 */

        for (int i = 0; i < parametrosPeliculas.length; i++) {
            int j = i + 1;
            if (parametrosPeliculas[i] instanceof String) {
                objStat.setString(j, (String) parametrosPeliculas[i]);
            } else if (parametrosPeliculas[i] instanceof Integer) {
                objStat.setInt(j, (Integer) parametrosPeliculas[i]);
            } else if (parametrosPeliculas[i] instanceof Double) {
                objStat.setDouble(j, (Double) parametrosPeliculas[i]);
            } else if (parametrosPeliculas[i] instanceof java.util.Date) {
                java.util.Date date = (java.util.Date) parametrosPeliculas[i];
                LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                int month = localDate.getMonthValue();
                int day = localDate.getDayOfMonth();
                int year = localDate.getYear();
                java.sql.Date fechabd = new java.sql.Date(year, month, day);
                objStat.setDate(j, fechabd);
            }
        }

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
