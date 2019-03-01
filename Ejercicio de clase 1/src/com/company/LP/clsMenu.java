package com.company.LP;

import com.company.LN.clsGestorLN;
import com.company.LN.clsLibro;

import java.util.ArrayList;

public class clsMenu {


    public static void menuPrincipal(ArrayList<clsLibro> lista){

        int opcion = 0;
        System.out.println("Bienvenido");

        do{

            System.out.println("1. - opción1");
            System.out.println("2. - opción2");
            System.out.println("3. - opción3");
            System.out.println("4. - opción4");
            System.out.println("5. - opción5");
            System.out.println("6. - opción6");
            System.out.println("7. - opción7");

            System.out.print("Eligue una opción: ");

            opcion = Utilidades.leerEntero();

            switch (opcion){

                case 1:
                    Opcion1();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }

        }while (opcion != 7);
    }

    //Creación objetos

    private static void Opcion1 ()
    {
        String titulo;
        int año;
        int identificador;
        clsGestorLN objGestor;
        clsLibro objLibro;



        System.out.println("Dame ID;");

        identificador = Utilidades.leerEntero();

        //objLibro = new clsLibro();

       // objLibro.ejemp=12;
        objGestor = new clsGestorLN();
        objLibro = objGestor.Crearlibro(identificador, titulo, anio);

        System.out.println("El libro dado de alta es:"+ objLibro.getTitulo());

    }

}
