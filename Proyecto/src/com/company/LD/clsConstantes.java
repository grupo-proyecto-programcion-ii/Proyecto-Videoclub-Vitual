package com.company.LD;

import javax.swing.plaf.PanelUI;

public class clsConstantes {

    /**
     *Constantes de usuario, contraseña, pueeto. nombre base de datos
     * y dirección
     */

    public final static String USER = "root";
    public final static String PASS = "";
    public final static String PORT = "3306";
    public final static String DATABASE = "proyecto";
    public final static String DIRECTION = "127.0.0.1";
    public final static String URL = "jdbc:mysql://" + DIRECTION + ":" + PORT + "/" + USER + "?useTimezone=true&serverTimezone=GMT&useSSL=false&allowPublicKeyRetrieval=true";

}

