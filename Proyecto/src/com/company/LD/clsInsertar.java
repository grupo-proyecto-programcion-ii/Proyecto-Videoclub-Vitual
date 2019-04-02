/**package com.company.LD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Clase para insertar usuarios
 */

/*
public class clsInsertar {

    public void insertarBD(String _id, String _codigo, int _cAleatorio) {


        clsConexion conexion = new clsConexion();
        Connection objConn = conexion.conectarBD();

        try {
            if ( objConn != null ) {
                // Preparamos la insert
                String query = "insert into alumno (id, nombre, apellido, dni) values (?, ?, ?, ?)";

                //Creamos las preparedstaments
                PreparedStatement objSt = objConn.prepareStatement(query);
                objSt.setString(1, _id);
                objSt.setString(2, _codigo);
                objSt.setInt(3, _cAleatorio);

                objSt.execute();

                System.out.println("Se ha insertado el registro correctamente");

                objSt.close();
                objConn.close();

            } else {
                System.out.println("No existe conexión");
            }

        } catch (SQLException e) {
            System.out.println("No se ha podido realizar el insert: " + e);
        }
    }


}
*/