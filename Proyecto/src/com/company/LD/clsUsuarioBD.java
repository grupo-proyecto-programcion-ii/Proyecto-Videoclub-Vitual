package com.company.LD;


import java.sql.*;

import static com.company.LD.clsConstantesBD.INSERT_USUARIO;
import static com.company.LD.clsConstantesBD.SELECT_USUARIOS;

public class clsUsuarioBD {


    public static int insertarUsuario(Connection objCon, PreparedStatement objStat, ResultSet objRS, Object[] _parametrosUsuario) throws Exception {

        int regActualizada = 0;
        int idU = 0;

        objStat = objCon.prepareStatement(INSERT_USUARIO, PreparedStatement.RETURN_GENERATED_KEYS);

        objStat.setString(1, (String) _parametrosUsuario[0]); //identificador
        objStat.setString(2, (String) _parametrosUsuario[1]); //contrasena

        regActualizada = objStat.executeUpdate();

        if (regActualizada == 1) {

            objRS = objStat.getGeneratedKeys();

            if (objRS.next()) {

                idU = objRS.getInt(1);
            }
        }
        return idU;
    }

    public static ResultSet consultaUsuario(Connection _objCon, PreparedStatement _objStat, ResultSet _objRS){

        try {
            _objStat = _objCon.prepareStatement(SELECT_USUARIOS);
            _objRS = _objStat.executeQuery(SELECT_USUARIOS);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return _objRS;
    }

}
