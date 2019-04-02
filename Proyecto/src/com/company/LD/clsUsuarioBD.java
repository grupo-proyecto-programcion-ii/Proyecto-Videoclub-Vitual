package com.company.LD;

import java.sql.Connection;
import java.sql.ResultSet;

public class clsUsuarioBD extends clsConexion{

    public static int insertar(Connection objCon, String identificador, String contrasena) throws Exception {
        Object[] parametrosUsuario = {identificador, contrasena};
        return insert(objCon, "INSERT INTO Usuarios (identificador,contrasena)VALUES(?,?)", parametrosUsuario);
    }

  /**  public static ResultSet getAll(Connection con) throws Exception {
        String query = "SELECT " + template + " FROM campos cmp";
        System.out.println(query);
        ResultSet rs = select(con, query);
        return rs;
    }

   */
}
