package com.company.LD;

import java.sql.Connection;
import java.sql.ResultSet;

public class clsUsuarioBD extends clsConexion{

    public static int insertar(Connection objCon, String identificador, String contrasena) throws Exception {
        Object[] parametrosUsuario = {identificador, contrasena};
        return insert(objCon, "INSERT INTO Usuarios (identificador,contrasena)VALUES(?,?)", parametrosUsuario);
    }

}
