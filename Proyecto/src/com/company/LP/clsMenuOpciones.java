package com.company.LP;

import com.company.LN.clsGestor;

/**
 * La idea de la clase es contener aquellas opciones que el usuario tenga que seleccionar.
 * Hemos decidido que la gestión del usuario(datos de él) será en la clase gestor.
 * Lo primero que hará nuestro programa será pedir al usuario registrarse o entrar, aun que aún no diponemos
 * la base de datos con datos y usuarios queremos implementar la funcionalidad. Una vez el usuario haya seleccionado
 * esa primera opción lo que vamos a hacer es perdirle que tipo de servicios quiere que que le ofrezcamos.
 * Las dos opciones que contemplamos será la de alquilar una serie de artículos limitados o una suscripción
 * semanal/mensual.
 * <p>
 * La función menuOpciones abarca todas las opciones que el usuário seleccionara. Todas las opciones estám
 * contenidas en funciones de diferentes clases donde se llamará.
 */

public class clsMenuOpciones {

    public void menuPrincipal() {

        int opcion = 0;

        /**
         * Lo idea es que objGestor sea un ArrayList, ¿por qué? queremos que el programa contínue una vez un usuario
         * haya seleccionado los servicios...Luego si ya se ha registrado un usuario, lo idea sería que
         * otro usuario que se registre no pueda volver a registrar con el mismo nombre. Esto se le llama
         * dar de alta a un usuario, y siendo un mismo objeto mejor que sea un arraylist.
         */

        // Creo y declaro el objeto, que serña objGestor
        clsGestor objGestor = new clsGestor();

        do {

            System.out.println("***************" +
                    "BIENVENIDO AL VIDEOCLUB VIRTUAL" +
                    "*****************");
            System.out.println();

            //System.out.println("Usuarios existentes; ");
            //La idea es que aquí en un futuro con un print se muestren los datos ya existentes
            //System.out.println();

            System.out.println("Selecciona el tipo de una opción:");
            System.out.println("----> 1. Entrar ");
            System.out.println("----> 2. Registrarse");
            System.out.println("----> 3. Salir");
            System.out.print("Opción:");
            opcion = Utilidades.leerEntero();

            switch (opcion) {
                case 1:
                    //Lamada al objeto
                    objGestor.entrarUsuario();
                    break;
                case 2:

                    break;

                case 3:

                    break;

            }

            System.out.println("Selecciona el tipo de una opción:");
            System.out.println();
            System.out.println("----> 1. Alquilar artículos");
            System.out.println("----> 2. Suscripción mensual");
            System.out.println("----> 3. Salir");
            System.out.print("Opción:");
            opcion = Utilidades.leerEntero();

        } while (opcion == 3);
    }
}
