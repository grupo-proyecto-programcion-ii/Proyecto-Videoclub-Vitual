package com.company.LP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Utilidades  {

    public static int leerEntero() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        Integer entero = null;
        boolean error = true;
        do {
            try {
                String cadena = br.readLine();
                entero = new Integer(cadena);
                error = false;
            } catch (NumberFormatException nfe) {
                System.out.println("No tecle� un n�mero entero-Repetir");
            } catch (Exception e) {
                System.out.println("Error de entrada-Repetir ");
            }
        }
        while (error);
        return entero.intValue();
    }

}
