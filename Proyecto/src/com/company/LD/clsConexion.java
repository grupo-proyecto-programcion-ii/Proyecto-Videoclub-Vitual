package com.company.LD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class clsConexion {

    //Nombre de la base de datos
    public String database="proyecto";

    //host
    public String hostname="localhost";

    //puerto
    public String port="3306";

    //Ruta de la base de datos (jdbc:mysql://localhost:3306/alumnoBD?useTimezone=true&serverTimezone=GMT&useSSL=false)
    public String url="jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useTimezone=true&serverTimezone=GMT&useSSL=false";

    //Nombre de usuario
    public String user="root";

    //Password
    public String password="";

    public Connection conectarBD() {

        Connection objConn = null;

        try {

            objConn = DriverManager.getConnection (url, user, password);

        } catch (SQLException e) {
            System.out.println("Ha fallado la conexión" + e);
        }

        return objConn;

    }

}
