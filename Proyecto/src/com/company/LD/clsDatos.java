package com.company.LD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static com.company.LD.clsConstantes.*;

/**
 *Clase que cominucará los parámetros entre la lógica de negocio
 * y la lógica de presentación
 */
public class clsDatos {

    /**
     * Atributo para la conexión a la base de datos, un objeto
     * de tipo Connection
     */

    private Connection objConexion = null;

    /**
     * Método para establecer la conexión, antes se encontraba
     * en clsConexión
     * @throws SQLException
     */
    public Connection conectarBD() throws SQLException{

        try {
            objConexion = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            System.out.println("Ha fallado la conexión" + e);
        }
        return objConexion;
    }

    /**
     * Función para desconectar de la base de datos
     * @throws SQLException
     */
    public void desconectarBD() throws SQLException {
        objConexion.close();
    }

    public int insertarCodigoUsuario(String _identificador,String _contrasena ) throws Exception {
        return clsUsuarioBD.insertar(objConexion ,_identificador, _contrasena);
    }
}
