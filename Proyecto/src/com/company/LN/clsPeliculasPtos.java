package com.company.LN;

import java.util.Comparator;

public class clsPeliculasPtos implements Comparator<clsPeliculas> {
    @Override
    public int compare(clsPeliculas peli_1, clsPeliculas peli_2) {
        return peli_2.getPuntuacion() - peli_1.getPuntuacion();
    }

}
