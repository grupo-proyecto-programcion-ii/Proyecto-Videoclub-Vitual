package com.company.LD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class clsVideojuegosBD {

    public static int insertarVieojuego(Connection objCon, Object[] parametrosVideojuegos) throws SQLException {

        PreparedStatement objStatements = objCon.prepareStatement("INSERT INTO Videjuegos (nombre,precio,duracion,puntuacionV,pegiVidejuegos)VALUES(?,?,?,?,?)");

        objStatements.setString(1, (String) parametrosVideojuegos[0]); //nombre
        objStatements.setDouble(2, (Integer) parametrosVideojuegos[1]);//precio
        objStatements.setDouble(3, (Double) parametrosVideojuegos[2]);//duración
        objStatements.setInt(4, (Integer) parametrosVideojuegos[3]);//puntuación
        objStatements.setInt(5, (Integer) parametrosVideojuegos[4]);//pegi
        objStatements.execute();
        return objStatements.getUpdateCount();
    }
}
