package com.company.LD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class clsMusicaBD {

    public static int insertarMusica(Connection objCon, Object[] parametrosMusica) throws SQLException {

        PreparedStatement objStatements = objCon.prepareStatement("INSERT INTO Música CD (nombre,precio,duracion,artistas,anio,explicito)VALUES(?,?,?,?,?,?)");

        objStatements.setString(1,(String) parametrosMusica [0]); //nombre
        objStatements.setDouble(2, (Integer) parametrosMusica [1]);//precio
        objStatements.setDouble(3, (Double) parametrosMusica [2]);//duración
        objStatements.setString(4, (String) parametrosMusica [3]);//artistas
        objStatements.setInt(5, (Integer) parametrosMusica [4]);//año
        objStatements.setString(5, (String) parametrosMusica [4]);//explicito
        objStatements.execute();
        return objStatements.getUpdateCount();
    }
}
