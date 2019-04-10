package com.company.LD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.company.LD.clsConstantesBD.*;

public class clsVideojuegosBD {

    public static int insertarVieojuego(Connection objCon, Object[] parametrosVideojuegos) throws SQLException {

        int regActualizada = 0;
        int idV = 0;

        PreparedStatement objStatements = objCon.prepareStatement(INSERT_VIDEOJUEGO);

        objStatements.setString(1, (String) parametrosVideojuegos[0]); //nombre
        objStatements.setDouble(2, (Double) parametrosVideojuegos[1]);//precio
        objStatements.setDouble(3, (Double) parametrosVideojuegos[2]);//duración
        objStatements.setInt(4, (Integer) parametrosVideojuegos[3]);//puntuación
        objStatements.setInt(5, (Integer) parametrosVideojuegos[4]);//pegi
        regActualizada = objStatements.executeUpdate();

        if (regActualizada == 1) {

            ResultSet objRS = objStatements.getGeneratedKeys();
            if (objRS.next()) {

                idV = objRS.getInt(1);
            }
        }
        return idV;
    }

    public static ResultSet consultaVideojuego(Connection _objCon, PreparedStatement _objStat, ResultSet _objRS){

        try {
            _objStat = _objCon.prepareStatement(SELECT_VIDEOJUEGOS);
            _objRS = _objStat.executeQuery(SELECT_VIDEOJUEGOS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return _objRS;
    }
}
