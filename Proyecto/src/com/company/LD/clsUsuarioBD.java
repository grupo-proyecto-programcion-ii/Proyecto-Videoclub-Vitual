package com.company.LD;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class clsUsuarioBD {


    public static int insertarUsuario(Connection objCon, Object[] _parametrosUsuario) throws Exception {

        int regActualizada = 0;
        int idU = 0;

        PreparedStatement objStatements = objCon.prepareStatement("INSERT INTO Usuarios (identificador,contrasena)VALUES(?,?)", PreparedStatement.RETURN_GENERATED_KEYS);

        objStatements.setString(1, (String) _parametrosUsuario[0]); //identificador
        objStatements.setString(2, (String) _parametrosUsuario[1]); //contrasena

        regActualizada = objStatements.executeUpdate();

        if (regActualizada == 1) {

            ResultSet objRS = objStatements.getGeneratedKeys();
            if (objRS.next()) {

                idU = objRS.getInt(1);
                System.out.println(idU);
            }
        }
        return idU;
    }
}
