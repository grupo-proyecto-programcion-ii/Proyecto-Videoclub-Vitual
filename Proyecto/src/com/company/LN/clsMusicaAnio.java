package com.company.LN;


import java.util.Comparator;

/**
 * Clase que implementa Comparator para ordenar los datos de musica segun el anio de forma ascendente a
 * descendente
 */
public class clsMusicaAnio implements Comparator<clsMusica_CD> {

    @Override
    public int compare(clsMusica_CD cd1, clsMusica_CD cd2) {
        return cd2.getAnio() - cd1.getAnio();
    }
}
