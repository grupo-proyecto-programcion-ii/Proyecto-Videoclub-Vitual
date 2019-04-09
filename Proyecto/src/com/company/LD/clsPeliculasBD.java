package com.company.LD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.company.LD.clsConstantesBD.INSERT_PELICULA;
import static com.company.LD.clsConstantesBD.SELECT_PELICULAS;


public class clsPeliculasBD {

    public static int insertarPelicula(Connection objCon, Object[] parametrosPeliculas) throws SQLException {

        int regActualizada = 0;
        int idP = 0;

        PreparedStatement objStatements = objCon.prepareStatement(INSERT_PELICULA);

        objStatements.setString(1,(String) parametrosPeliculas [0]); //nombre
        objStatements.setDouble(2, (Double) parametrosPeliculas [1]);//precio
        objStatements.setDouble(3, (Double) parametrosPeliculas [2]);//duración
        objStatements.setInt(4, (Integer) parametrosPeliculas [3]);//pegi
        objStatements.setInt(5, (Integer) parametrosPeliculas [4]);//puntuación
        regActualizada = objStatements.executeUpdate();

        if (regActualizada == 1) {

            ResultSet objRS = objStatements.getGeneratedKeys();
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
