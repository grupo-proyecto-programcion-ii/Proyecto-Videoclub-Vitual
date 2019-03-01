package com.company;

// Ejercicio para objetos de gestionar en mediateca

import com.company.LN.clsLibro;
import com.company.LP.clsMenu;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //Declaración del Array

       ArrayList<clsLibro> miLista = new ArrayList<clsLibro>();

        clsMenu.menuPrincipal(miLista);

    }
}
