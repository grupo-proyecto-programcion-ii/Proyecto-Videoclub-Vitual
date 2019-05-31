package com.company.LD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.company.LD.clsConstantesBD.*;

/**
 * Clase para los metodos de alquilar videojuegos que interactua con la base de datos
 */
public class clsAlquilarVideojuegosBD {

    /**
     * Metodo para insertar los datos de alquiler
     * @param objCon objeto conexion
     * @param objStat objeto statment
     * @param objRS objetoresultset
     * @param parametrosAlquilerV parametros de alquiler videojuegos que se le introduce
     * @return id de la tabla alquiler
     * @throws SQLException excepcion
     */
    public static int insertAlquilerV(Connection objCon, PreparedStatement objStat, ResultSet objRS, Object[] parametrosAlquilerV) throws SQLException {

        int regActualizada = 0;
        int idP = 0;


        objStat = objCon.prepareStatement(INSERT_ALQUILER_VIDEOJUEGO,  PreparedStatement.RETURN_GENERATED_KEYS);


        objStat.setInt(1, (Integer) parametrosAlquilerV [0]);//usuarios_codigo_aleatorio
        objStat.setInt(2, (Integer) parametrosAlquilerV [1]);//pelicula_id

        java.util.Date fecha_dev = (java.util.Date) parametrosAlquilerV[2];
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
     * Obtener datos de la tabla alquiler videojeugos
     * @param _objCon objconexion
     * @param _objStat objstatment
     * @param _objRS objresultset
     * @return resultset
     */
    public static ResultSet consultaAlquilerV(Connection _objCon, PreparedStatement _objStat, ResultSet _objRS){

        try {
            _objStat = _objCon.prepareStatement(SELECT_ALQUILER_VIDEOJUEGOS);
            _objRS = _objStat.executeQuery(SELECT_ALQUILER_VIDEOJUEGOS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return _objRS;
    }

    /**
     * metodo para eliminr alquileres de videojuegos de la base de datos
     * @param objCon objconexion
     * @param objStat objeto statment
     * @param objRS objetorsult
     * @param id id del usuario
     * @throws SQLException excepcion
     */
    public static void deleteVideojuego(Connection objCon, PreparedStatement objStat, ResultSet objRS, int id) throws SQLException {

        objStat = objCon.prepareStatement(DELETE_VIDEOJUEGO);

        objStat.setInt(1, id);//usuarios_codigo_aleatorio

        objStat.executeUpdate();

    }
}
