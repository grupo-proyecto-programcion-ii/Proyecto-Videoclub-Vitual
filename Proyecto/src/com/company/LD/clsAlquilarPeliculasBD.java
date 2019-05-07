package com.company.LD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.company.LD.clsConstantesBD.INSERT_ALQUILER_PELICULA;

public class clsAlquilarPeliculasBD {

    public static void insertAlquilerP(Connection objCon, PreparedStatement objStat, ResultSet objRS, Object[] parametrosAlquilerP) throws SQLException {

        objStat = objCon.prepareStatement(INSERT_ALQUILER_PELICULA);


        objStat.setInt(1, (Integer) parametrosAlquilerP [0]);//pegi
        objStat.setInt(2, (Integer) parametrosAlquilerP [1]);//puntuación

        java.util.Date fecha_dev = (java.util.Date) parametrosAlquilerP[2];
        java.sql.Date fechasql = new java.sql.Date(fecha_dev.getTime());

        objStat.setDate(3, fechasql, java.util.Calendar.getInstance()); //fecha salida

        objStat.executeUpdate();
    }
}
