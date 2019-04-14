package com.company.LN;

import java.util.Comparator;

/**
 * Clase que implementa Comparator para ordenar los datos de videjuegos segun la puntuacion de forma ascendente a
 * descendente
 */
public class clsVideojuegosPtos implements Comparator<clsVideojuegos> {
    @Override
    public int compare(clsVideojuegos v1, clsVideojuegos v2) {
        return v2.getPuntuacion() - v1.getPuntuacion();
    }
}
