package com.company.LD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class clsUsuarioBD {

    public static int insertarUsuario(Connection objCon, String identificador, String contrasena) throws Exception{

        PreparedStatement objStatements = objCon.prepareStatement("INSERT INTO Usuarios (identificador,contrasena)VALUES(?,?)");

        objStatements.setString(1,identificador);
        objStatements.setString(2, contrasena);
        objStatements.execute();

        return objStatements.getUpdateCount();
    }
}
