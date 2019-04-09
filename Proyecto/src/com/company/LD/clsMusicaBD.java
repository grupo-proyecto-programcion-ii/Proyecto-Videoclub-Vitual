package com.company.LD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.company.LD.clsConstantesBD.*;

public class clsMusicaBD {

    public static int insertarMusica(Connection objCon, Object[] parametrosMusica) throws SQLException {

        int regActualizada = 0;
        int idM = 0;

        PreparedStatement objStatements = objCon.prepareStatement(INSERT_MUSICA);

        objStatements.setString(1,(String) parametrosMusica [0]); //nombre
        objStatements.setDouble(2, (Integer) parametrosMusica [1]);//precio
        objStatements.setDouble(3, (Double) parametrosMusica [2]);//duración
        objStatements.setString(4, (String) parametrosMusica [3]);//artistas
        objStatements.setInt(5, (Integer) parametrosMusica [4]);//año
        objStatements.setString(5, (String) parametrosMusica [4]);//explicito
        regActualizada = objStatements.executeUpdate();

        if (regActualizada == 1) {

            ResultSet objRS = objStatements.getGeneratedKeys();
            if (objRS.next()) {

                idM = objRS.getInt(1);
            }
        }
        return idM;
    }

    public static ResultSet consultaMusica(Connection _objCon, PreparedStatement _objStat, ResultSet _objRS){

        try {
            _objStat = _objCon.prepareStatement(SELECT_MUSICA);
            _objRS = _objStat.executeQuery(SELECT_MUSICA);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return _objRS;
    }
}
