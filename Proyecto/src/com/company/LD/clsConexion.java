package com.company.LD;


import java.sql.Connection;
import java.sql.PreparedStatement;

public class clsConexion {

    public static int insert(Connection con, String query, Object[] parametros) throws Exception {


        PreparedStatement objStatements = con.prepareStatement(query);
        cargarDatos(objStatements, parametros);
        objStatements.execute();

        return objStatements.getUpdateCount();
    }

    /**
     * Filtro para preparar de forma organizada los preparedstatements
     * @param objSt
     * @param parametros
     * @throws Exception
     */
    private static void cargarDatos(PreparedStatement objSt, Object[] parametros) throws Exception {

        for (int i = 1; i < parametros.length; i++) {

            int j = i++;
            if (parametros[i] instanceof String) {
                objSt.setString(j, (String) parametros[i]);
            } else if (parametros[i] instanceof Integer) {
                objSt.setInt(j, (Integer) parametros[i]);
            } else if (parametros[i] instanceof Double) {
                objSt.setDouble(j, (Double) parametros[i]);
            }
        }
    }
}
