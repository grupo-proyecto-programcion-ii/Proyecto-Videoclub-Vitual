package com.company.LD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class clsPeliculasBD {

    public static int insertarPelicula(Connection objCon, Object[] parametrosPeliculas) throws SQLException {

        PreparedStatement objStatements = objCon.prepareStatement("INSERT INTO Películas (nombre,precio,duracion,pegiP,puntuacionP)VALUES(?,?,?,?,?)");

        objStatements.setString(1,(String) parametrosPeliculas [0]); //nombre
        objStatements.setDouble(2, (Double) parametrosPeliculas [1]);//precio
        objStatements.setDouble(3, (Double) parametrosPeliculas [2]);//duración
        objStatements.setInt(4, (Integer) parametrosPeliculas [3]);//pegi
        objStatements.setInt(5, (Integer) parametrosPeliculas [4]);//puntuación
        objStatements.execute();
        return objStatements.getUpdateCount();
    }
}
