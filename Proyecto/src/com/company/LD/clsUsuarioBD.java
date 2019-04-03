package com.company.LD;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class clsUsuarioBD {

    public static int insertarUsuario(Connection objCon, Object[] _parametrosUsuario) throws Exception{

        PreparedStatement objStatements = objCon.prepareStatement("INSERT INTO Usuarios (identificador,contrasena)VALUES(?,?)");

        objStatements.setString(1,(String) _parametrosUsuario [0]); //identificador
        objStatements.setString(2, (String) _parametrosUsuario [1]); //contrasena
        objStatements.execute();

        return objStatements.getUpdateCount();
    }
}
