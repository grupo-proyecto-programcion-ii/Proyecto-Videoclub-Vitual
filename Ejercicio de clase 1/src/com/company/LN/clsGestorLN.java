package com.company.LN;

/**
 * Clase que sirve de enlace entre la LP y la LN
 */

public class clsGestorLN {

    public clsLibro crearLibro (String titulo, int anio, int identificador){

        clsLibro retorno;

        retorno = new clsLibro(identificador, titulo);
       /** retorno.setAño(anio);
        retorno.setIdentificador(identificador);
        retorno.setTitulo(titulo);
       */
        return retorno;
    }

}
