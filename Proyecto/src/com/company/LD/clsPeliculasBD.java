package com.company.LD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.company.LD.clsConstantesBD.INSERT_PELICULA;
import static com.company.LD.clsConstantesBD.SELECT_PELICULAS;


public class clsPeliculasBD {

    public static int insertarPelicula(Connection objCon, PreparedStatement objStat, ResultSet objRS, Object[] parametrosPeliculas) throws SQLException {

        int regActualizada = 0;
        int idP = 0;

        objStat = objCon.prepareStatement(INSERT_PELICULA, PreparedStatement.RETURN_GENERATED_KEYS);

        objStat.setString(1,(String) parametrosPeliculas [0]); //nombre
        objStat.setDouble(2, (Double) parametrosPeliculas [1]);//precio
        objStat.setDouble(3, (Double) parametrosPeliculas [2]);//duración
        objStat.setInt(4, (Integer) parametrosPeliculas [3]);//pegi
        objStat.setInt(5, (Integer) parametrosPeliculas [4]);//puntuación
        regActualizada = objStat.executeUpdate();

        if (regActualizada == 1) {

            objRS = objStat.getGeneratedKeys();

            if (objRS.next()) {

                idP = objRS.getInt(1);
            }
        }
        return idP;
    }

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
