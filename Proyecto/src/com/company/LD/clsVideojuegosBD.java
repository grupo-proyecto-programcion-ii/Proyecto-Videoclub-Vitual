package com.company.LD;

import java.sql.*;

import static com.company.LD.clsConstantesBD.*;

/**
 * Clase para insertar parametros en la base de datos y consultar los mismos de articulos videojuegos
 */
public class clsVideojuegosBD {

    /**
     * Metedo para insertar parametros de en la base de datos
     * @param objCon objeto de la conexion
     * @param objStat objeto de los statments
     * @param objRS objeto los resultados
     * @param parametrosVideojuegos parametros propio de la clase clsVidejuegos
     * @return codigo id de musica ascendente
     * @throws SQLException excepcion propia
     */
    public static int insertarVieojuego(Connection objCon, PreparedStatement objStat, ResultSet objRS, Object[] parametrosVideojuegos) throws SQLException {

        int regActualizada = 0;
        int idV = 0;

       objStat = objCon.prepareStatement(INSERT_VIDEOJUEGO, PreparedStatement.RETURN_GENERATED_KEYS);

        objStat.setDate(1, (Date) parametrosVideojuegos [0]); //fecha salida
        objStat.setString(2, (String) parametrosVideojuegos[1]); //nombre
        objStat.setDouble(3, (Integer) parametrosVideojuegos[2]);//precio
        objStat.setDouble(4, (Double) parametrosVideojuegos[3]);//duración
        objStat.setInt(5, (Integer) parametrosVideojuegos[4]);//puntuación
        objStat.setInt(6, (Integer) parametrosVideojuegos[5]);//pegi
        regActualizada = objStat.executeUpdate();

        if (regActualizada == 1) {

            objRS = objStat.getGeneratedKeys();
            if (objRS.next()) {

                idV = objRS.getInt(1);
            }
        }
        return idV;
    }

    /**
     * Metodo para consultar datos, obtenerlos. Parametros de clase clsVideojuego
     * @param _objCon objeto de la conexion
     * @param _objStat objeto de los statments
     * @param _objRS objeto los resultados
     * @return resulset
     */
    public static ResultSet consultaVideojuego(Connection _objCon, PreparedStatement _objStat, ResultSet _objRS){

        try {
            _objStat = _objCon.prepareStatement(SELECT_VIDEOJUEGOS);
            _objRS = _objStat.executeQuery(SELECT_VIDEOJUEGOS);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return _objRS;
    }
}
