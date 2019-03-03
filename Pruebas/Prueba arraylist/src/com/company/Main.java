package com.company;

import java.util.ArrayList;

/**
 * En el main se dejará lo imprescindible. La llamada a la clase clsMenuOpciones
 * donde se interactúa con el usuário.Por ahora no sabemos que introducir en
 * clsGestor.
 */

public class Main {

    public static void main(String[] args) {

        ArrayList<String> nombreArrayList = new ArrayList<String>();
        // Añade el elemento al ArrayList
        nombreArrayList.add("Elemento");
        // Devuelve el elemento que esta en la posición '2' del ArrayList
        System.out.println(nombreArrayList.get(0));

    }
}