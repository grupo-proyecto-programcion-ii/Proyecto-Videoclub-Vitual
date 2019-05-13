package com.company.LD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.company.LD.clsConstantesBD.*;

public class clsAlquilarMusicaBD {

    public static int insertAlquilerM(Connection objCon, PreparedStatement objStat, ResultSet objRS, Object[] parametrosAlquilerM) throws SQLException {

        int regActualizada = 0;
        int idP = 0;


        objStat = objCon.prepareStatement(INSERT_ALQUILER_MUSICA,  PreparedStatement.RETURN_GENERATED_KEYS);


        objStat.setInt(1, (Integer) parametrosAlquilerM [0]);//usuarios_codigo_aleatorio
        objStat.setInt(2, (Integer) parametrosAlquilerM [1]);//pelicula_id

        java.util.Date fecha_dev = (java.util.Date) parametrosAlquilerM[2];
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

    public static ResultSet consultaAlquilerM(Connection _objCon, PreparedStatement _objStat, ResultSet _objRS){

        try {
            _objStat = _objCon.prepareStatement(SELECT_ALQUILER_MUSICA);
            _objRS = _objStat.executeQuery(SELECT_ALQUILER_MUSICA);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return _objRS;
    }

    public static void deleteMusica(Connection objCon, PreparedStatement objStat, ResultSet objRS, int id) throws SQLException {

        objStat = objCon.prepareStatement(DELETE_MUSICA);

        objStat.setInt(1, id);//usuarios_codigo_aleatorio

        objStat.executeUpdate();

    }
}
