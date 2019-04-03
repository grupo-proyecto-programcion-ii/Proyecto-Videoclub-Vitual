package com.company;
import com.company.LP.clsMenuOpciones;

import java.sql.SQLException;

/**
 * En el main se dejará lo imprescindible. La llamada a la clase clsMenuOpciones
 * donde se interactúa con el usuário.Por ahora no sabemos que introducir en
 * clsGestor.
 */

public class Main {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        System.out.println();

        // Creo y declaro el objeto, que serña objMenu*/
        clsMenuOpciones objMenu = new clsMenuOpciones();

        //Lamada al objeto
        objMenu.menuPrincipal();
    }
}
