package com.company.LD;

import java.sql.*;
import static com.company.LD.clsConstantesBD.*;

/**
 * Clase para insertar parametros en la base de datos y consultar los mismos de articulos musica
 */

public class clsMusicaBD {

    /**
     * Metedo para insertar parametros de en la base de datos
     * @param objCon objeto de la conexion
     * @param objStat objeto de los statments
     * @param objRS objeto los resultados
     * @param parametrosMusica parametros propio de la clase musica
     * @return codigo id de musica ascendente
     * @throws SQLException excepcion propia
     */

    public static int insertarMusica(Connection objCon, PreparedStatement objStat, ResultSet objRS, Object[] parametrosMusica) throws SQLException {

        int regActualizada = 0;
        int idM = 0;

        objStat = objCon.prepareStatement(INSERT_MUSICA, PreparedStatement.RETURN_GENERATED_KEYS);

        java.util.Date fechaS = (java.util.Date) parametrosMusica[0];
        java.sql.Date fechasql = new java.sql.Date(fechaS.getTime());

        objStat.setDate(1, fechasql, java.util.Calendar.getInstance()); //fecha salida
        objStat.setString(2, (String) parametrosMusica[1]); //nombre
        objStat.setDouble(3, (Double) parametrosMusica[2]);//precio
        objStat.setDouble(4, (Double) parametrosMusica[3]);//duración
        objStat.setString(5, (String) parametrosMusica[4]);//artistas
        objStat.setInt(6, (Integer) parametrosMusica[5]);//año
        objStat.setString(7, (String) parametrosMusica[6]);//explicito
        regActualizada = objStat.executeUpdate();

        if (regActualizada == 1) {

            objRS = objStat.getGeneratedKeys();
            if (objRS.next()) {

                idM = objRS.getInt(1);
            }
        }
        return idM;
    }

    /**
     * Metodo para consultar datos, obtenerlos. Parametros de clase musica
     * @param _objCon objeto de la conexion
     * @param _objStat objeto de los statments
     * @param _objRS objeto los resultados
     * @return resulset
     */
    public static ResultSet consultaMusica(Connection _objCon, PreparedStatement _objStat, ResultSet _objRS) {

        try {
            _objStat = _objCon.prepareStatement(SELECT_MUSICA);
            _objRS = _objStat.executeQuery(SELECT_MUSICA);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return _objRS;
    }
}
