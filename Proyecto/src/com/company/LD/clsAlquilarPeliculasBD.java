package com.company.LD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.company.LD.clsConstantesBD.DELETE_PELICULA;
import static com.company.LD.clsConstantesBD.INSERT_ALQUILER_PELICULA;

public class clsAlquilarPeliculasBD {

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

    public static void deletePelicula(Connection objCon, PreparedStatement objStat, ResultSet objRS, int id) throws SQLException {

        objStat = objCon.prepareStatement("DELETE FROM usuarios_has_peliculas WHERE idAlquiler = ?");

        objStat.setInt(1, id);//usuarios_codigo_aleatorio

        objStat.executeUpdate();



    }
}
