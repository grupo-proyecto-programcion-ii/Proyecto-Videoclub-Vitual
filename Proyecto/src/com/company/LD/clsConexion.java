package com.company.LD;


import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Clase donde se hacen todas las conecxiones a la base de datos
 */

public class clsConexion {

    /**
     * Insertar los datos al mísmo tiempo que devuelve un entero siendo el número de filas de la
     * tabla a insertar
     * @param _objCon
     * @param query
     * @param parametros
     * @return
     * @throws Exception
     */

    public static int insert(Connection _objCon, String query, Object[] parametros) throws Exception {

        PreparedStatement objStatements = _objCon.prepareStatement(query);
        //filtrarDatos(objStatements, parametros);
        objStatements.setString(1,(String) parametros[1]);
        objStatements.setString(2, (String) parametros[2]);
        objStatements.execute();

        return objStatements.getUpdateCount();
    }

    /**
     * Filtro para preparar de forma organizada los preparedstatements
     * @param objSt
     * @param parametros
     * @throws Exception
     */
    private static void filtrarDatos(PreparedStatement objSt, Object[] parametros) throws Exception {

        for (int i = 0; i < parametros.length; i++) {

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
