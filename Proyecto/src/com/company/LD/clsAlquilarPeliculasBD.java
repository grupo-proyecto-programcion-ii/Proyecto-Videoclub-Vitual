package com.company.LD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.company.LD.clsConstantesBD.*;

/**
 * Clase para los metodos de alquilar peliculas que interactua con la base de datos
 */

public class clsAlquilarPeliculasBD {
    /**
     * Metooo principal para introducir datos de alquiler p
     * @param objCon objeto conexxion
     * @param objStat objeto del statment
     * @param objRS objeto del resultSet
     * @param parametrosAlquilerP parametros de alquiler peliculas
     * @return id de la tabla alquiler peliculas
     * @throws SQLException excepcion
     */
    public static int insertAlquilerP(Connection objCon, PreparedStatement objStat, ResultSet objRS, Object[] parametrosAlquilerP) throws SQLException {

        int regActualizada = 0;
        int idP = 0;


        objStat = objCon.prepareStatement(INSERT_ALQUILER_PELICULA,  PreparedStatement.RETURN_GENERATED_KEYS);


        objStat.setInt(1, (Integer) parametrosAlquilerP [0]);//usuarios_codigo_aleatorio
        objStat.setInt(2, (Integer) parametrosAlquilerP [1]);//pelicula_id

        java.util.Date fecha_dev = (java.util.Date) parametrosAlquilerP[2];
        java.sql.Date fechasql = new java.sql.Date(fecha_dev.getTime());

        objStat.setDate(3, fechasql, java.util.Calendar.getInstance()); //fecha devolucion

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
     * Metodo para obtener daros
     * @param _objCon objcon
     * @param _objStat objs
     * @param _objRS objrs
     * @return rsultset
     */
    public static ResultSet consultaAlquilerP(Connection _objCon, PreparedStatement _objStat, ResultSet _objRS){

        try {
            _objStat = _objCon.prepareStatement(SELECT_ALQUILER_PELICULAS);
            _objRS = _objStat.executeQuery(SELECT_ALQUILER_PELICULAS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return _objRS;
    }

    /**
     * Metodo para eliminar pelicula de alquiler
     * @param objCon objCon
     * @param objStat starment
     * @param objRS objeto resultset
     * @param id id del usuario
     * @throws SQLException excepcion
     */
    public static void deletePelicula(Connection objCon, PreparedStatement objStat, ResultSet objRS, int id) throws SQLException {

        objStat = objCon.prepareStatement(DELETE_PELICULA);

        objStat.setInt(1, id);//usuarios_codigo_aleatorio

        objStat.executeUpdate();

    }
}
