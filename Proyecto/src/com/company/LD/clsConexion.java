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
        System.out.println(query);
        PreparedStatement objStatements = _objCon.prepareStatement(query);
        objStatements.setString(1,(String) parametros[0]);
        objStatements.setString(2, (String) parametros[1]);
        objStatements.execute();

        return objStatements.getUpdateCount();
    }
}
