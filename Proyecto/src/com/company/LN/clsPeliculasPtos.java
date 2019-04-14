package com.company.LN;

import java.util.Comparator;

/**
 * Clase que implementa Comparator para ordenar los datos de peliculas segun la puntuacion de forma ascendente a
 * descendente
 */
public class clsPeliculasPtos implements Comparator<clsPeliculas> {
    @Override
    public int compare(clsPeliculas peli_1, clsPeliculas peli_2) {
        return peli_2.getPuntuacion() - peli_1.getPuntuacion();
    }

}
