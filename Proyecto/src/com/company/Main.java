package com.company;
import com.company.LP.clsMenuOpciones;

import java.sql.SQLException;

/**
 * En el main se dejara lo imprescindible. La llamada a la clase clsMenuOpciones
 * donde se interactua con el usuario.Por ahora no sabemos que introducir en
 * clsGestor.
 */

public class Main<result> {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        System.out.println();

        // Creo y declaro el objeto, que seria objMenu*/
        clsMenuOpciones objMenu = new clsMenuOpciones();

        //Lamada al objeto
        objMenu.menuPrincipal();
    }

}

