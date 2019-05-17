package com.company.LD;


import java.sql.*;

import static com.company.LD.clsConstantesBD.*;

/**
 * Clase para insertar parametros en la base de datos y consultar los mismos de usuarios
 */
public class clsUsuarioBD {

    /**
     * Metedo para insertar parametros de en la base de datos
     * @param objCon objeto de la conexion
     * @param objStat objeto de los statments
     * @param objRS objeto los resultados
     * @param _parametrosUsuario parametros propio de la clase clsUsuario
     * @return codigo id de musica ascendente
     * @throws SQLException excepcion propia
     */
    public static int insertarUsuario(Connection objCon, PreparedStatement objStat, ResultSet objRS, Object[] _parametrosUsuario) throws Exception {

        int regActualizada = 0;
        int idU = 0;

        objStat = objCon.prepareStatement(INSERT_USUARIO, PreparedStatement.RETURN_GENERATED_KEYS);

        objStat.setString(1, (String) _parametrosUsuario[0]); //identificador
        objStat.setString(2, (String) _parametrosUsuario[1]); //contrasena
        objStat.setString(3, (String) _parametrosUsuario[2]); //nombre
        objStat.setString(4, (String) _parametrosUsuario[3]); //apellidos
        objStat.setString(5, (String) _parametrosUsuario[4]); //correo electronico
        objStat.setString(6, (String) _parametrosUsuario[5]); //numero tarjeta

        java.util.Date fechaN = (java.util.Date) _parametrosUsuario[6];
        java.sql.Date fechasqlN = new java.sql.Date(fechaN.getTime());

        objStat.setDate(7, fechasqlN, java.util.Calendar.getInstance()); //fecha nacimiento
        objStat.setDouble(8, (Double) _parametrosUsuario[7]); //coste total
        objStat.setBoolean(9,(Boolean) _parametrosUsuario[8]); //estado suscripcion

        java.util.Date fechaS = (java.util.Date) _parametrosUsuario[9];
        java.sql.Date fechasqlS = new java.sql.Date(fechaS.getTime());

        objStat.setDate(10, fechasqlS, java.util.Calendar.getInstance()); //fecha suscripcion

        regActualizada = objStat.executeUpdate();

        if (regActualizada == 1) {

            objRS = objStat.getGeneratedKeys();
            if (objRS.next()) {

                idU = objRS.getInt(1);
            }
        }
        return idU;
    }

    /**
     * Metodo para consultar datos, obtenerlos. Parametros de clase clsUsuario
     * @param _objCon objeto de la conexion
     * @param _objStat objeto de los statments
     * @param _objRS objeto los resultados
     * @return resulset
     */
    public static ResultSet consultaUsuario(Connection _objCon, PreparedStatement _objStat, ResultSet _objRS) {

        try {
            _objStat = _objCon.prepareStatement(SELECT_USUARIOS);
            _objRS = _objStat.executeQuery(SELECT_USUARIOS);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return _objRS;
    }

    public static void updateAltaSuscripcion(Connection _objCon, PreparedStatement _objStat, ResultSet _objRS, int _codigoA, boolean suscripcion, java.util.Date fechaS){
        _objStat = _objCon.prepareStatement(UPDATE_ALTA_SUSCRIPCION);

        _objStat.setInt(1, _codigoA);//usuarios_codigo_aleatorio
        _objStat.setInt(1, _codigoA);//usuarios_codigo_aleatorio

        objStat.executeUpdate();
    }

    public static void updateBajaSuscripcion(Connection _objCon, PreparedStatement _objStat, ResultSet _objRS){

    }


}