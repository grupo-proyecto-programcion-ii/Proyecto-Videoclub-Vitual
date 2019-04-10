package com.company.LD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.company.LD.clsConstantesBD.*;

public class clsVideojuegosBD {

    public static int insertarVieojuego(Connection objCon, PreparedStatement objStat, ResultSet objRS, Object[] parametrosVideojuegos) throws SQLException {

        int regActualizada = 0;
        int idV = 0;

       objStat = objCon.prepareStatement(INSERT_VIDEOJUEGO, PreparedStatement.RETURN_GENERATED_KEYS);

        objStat.setString(1, (String) parametrosVideojuegos[0]); //nombre
        objStat.setDouble(2, (Integer) parametrosVideojuegos[1]);//precio
        objStat.setDouble(3, (Double) parametrosVideojuegos[2]);//duración
        objStat.setInt(4, (Integer) parametrosVideojuegos[3]);//puntuación
        objStat.setInt(5, (Integer) parametrosVideojuegos[4]);//pegi
        regActualizada = objStat.executeUpdate();

        if (regActualizada == 1) {

            objRS = objStat.getGeneratedKeys();
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
