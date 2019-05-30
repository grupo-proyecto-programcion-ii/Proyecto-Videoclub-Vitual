package com.company.LP;

import com.company.LN.clsGestor;
import java.sql.SQLException;


/**
 * La clase contiene un menu principal donde se centra en el registro, entrada y visualización del usuario.
 * Una vez el usuario se ha registrado y se ha "logeado" tiene disponibloe la opcion de alquilar articulos
 * o un servicio de suscripcion.
 */

public class clsMenuOpciones {

    /**
     * En este menu principal se encargara de seleccionar lo que tiene que ver con los objetos de usuario
     *
     * @throws SQLException           excepcion de tipo clase SQL
     * @throws ClassNotFoundException clase exception
     */
    public void menuPrincipal(){

        /**
         * Objeto gestor para cargar los datos una vez que empieza el programa
         */
        clsGestor objGestor = new clsGestor();

        try {
            objGestor.cargarDatos();
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, "error al cargar datos");
            e.printStackTrace();
        }

        clsVentanaInicio objVentanaInicio = new clsVentanaInicio(objGestor);
        objVentanaInicio.setVisible(true);
        objVentanaInicio.setExtendedState(6);
    }
}