package com.company.LD;


import java.sql.Connection;
import java.sql.PreparedStatement;

public class clsConexion {

    public static int insert(Connection con, String query, Object[] parametros) throws Exception {
        PreparedStatement stt = con.prepareStatement(query);
        cargarDatos(stt, parametros);
        stt.execute();
        return stt.getUpdateCount();
    }

    private static void cargarDatos(PreparedStatement stt, Object[] parametros) throws Exception {
        for (int i = 0; i < parametros.length; i++) {
            int j = i + 1;
            if (parametros[i] instanceof String) {
                stt.setString(j, (String) parametros[i]);
            } else if (parametros[i] instanceof Integer) {
                stt.setInt(j, (Integer) parametros[i]);
            } else if (parametros[i] instanceof Double) {
                stt.setDouble(j, (Double) parametros[i]);
            }
        }
    }
}
