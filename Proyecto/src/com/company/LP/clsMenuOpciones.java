package com.company.LP;

import com.company.LN.clsGestor;

import java.util.ArrayList;
import java.util.Iterator;

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

        // Creo y declaro el objeto, que señala objGestor
        ArrayList<clsGestor> objUsuario = new ArrayList<clsGestor>();
        clsGestor usuarios = new clsGestor();

        /**
         * he creado un iterador para que recorra el aarylist y sea capaz de mostrarme sus elementos
         * (no me ha servido)
         */
        Iterator<clsGestor> miIterator = objUsuario.iterator();


        System.out.println("***************" +
                "BIENVENIDO AL VIDEOCLUB VIRTUAL" +
                "*****************");
        System.out.println();

        do {

            System.out.println("Selecciona el tipo de una opción:");
            System.out.println("----> 1. Entrar ");
            System.out.println("----> 2. Registrarse");
            System.out.println("----> 3. Visualizar Usuarios");
            System.out.println("----> 4. Salir");
            System.out.print("Opción:");
            opcion = Utilidades.leerEntero();

            switch (opcion) {

                /**
                 * La primera opción no está acabada, lo que quiero es que si el usuario se identifica
                 * con un usuario ya existente, puede seguir con los servicios. Aún no he sido capaz de comparar
                 * el nombre de usuario que escribe, con el nombre de usuario ya existente ne el arraylist
                 *
                 */

                case 1:
                    //Si existe el usuario, se hace la llamada a entrar.
                    if (objUsuario.contains(usuarios)){
                        objUsuario.get(objUsuario.size());
                    }
                    break;

                /**
                 * Introducir usuarios de alta, funciona
                 */

                case 2:
                    //Si se quiere registrar un usuario se hace la llamda a registrar
                    usuarios.altaUsuario();
                    objUsuario.add(usuarios);
                    break;

                /**
                 * Puedo indicar el número de usuarios, pero no soy capaz de mostrarlos
                 */
                case 3:

                    if (objUsuario.size() == 1) {
                        System.out.println(objUsuario.size() + " usuario dados de alta");
                    } else {
                        System.out.println(objUsuario.size() + " usuarios dados de alta");
                    }
/**
                    while(miIterator.hasNext()) {
                        System.out.print(miIterator.next()+" / ");
                    }

                    for (int i = 0; i < objUsuario.size(); i++ ){
                        objUsuario.get(0);
                    } */
                    break;
            }
            System.out.println();
        } while (opcion != 4);
    }
}
