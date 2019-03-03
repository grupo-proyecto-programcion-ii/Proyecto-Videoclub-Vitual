package com.company.LP;

import com.company.LN.clsGestor;
import com.company.LN.clsUsuario;

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
        // Creo y declaro el objeto, que señala objGestor
        clsGestor objGestor = new clsGestor();

        /**
         * Se crea el objGestor que apunta a la clase clsGestor. Por medio de los métodos contenidos
         * en esa clase se pueden hacer las funciones principales.
         */

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

            /**
             * La primera opción no está acabada, lo que quiero es que si el usuario se identifica
             * con un usuario ya existente, puede seguir con los servicios. Aún no he sido capaz de comparar
             * el nombre de usuario que escribe, con el nombre de usuario ya existente ne el arraylist
             *
             */

            switch (opcion) {
                case 1:
                    entrarUsuarios(objGestor.leerUsuarios());
                    break;
                case 2:
                    altaUsuario(objGestor);
                    break;
                case 3:
                    objGestor.visualizarNumUsuarios();
                    visualizarUsuarios(objGestor.leerUsuarios());
                    break;
                case 4:
                    System.out.println("Fin del programa");
                    break;
            }
            System.out.println();
        } while (opcion != 4);
    }

    public void entrarUsuarios(ArrayList<clsUsuario> listaUsuarios) {

        String id = null;
        String contra = null;
        int op = 0;
        int op2 = 0;

        System.out.println("Introduce tus datos; ");
        System.out.print("Usuario: ");
        id = Utilidades.leerCadena();
        System.out.print("Contraseña: ");
        contra = Utilidades.leerCadena();

        for (clsUsuario usuario : listaUsuarios) {
            if (contra.equals(usuario.getContrasena())) {

                do {
                    System.out.println("Selecciona el servicio que deseas:");
                    System.out.println("----> 1. Alquilar artículos ");
                    System.out.println("----> 2. Suscripcuón mensual");
                    System.out.println("----> 3. Salir");
                    op = Utilidades.leerEntero();

                    if (op == 1) {

                        do {
                            System.out.println("Selecciona el tipo de artículo a reservar: ");
                            System.out.println("----> 1. Peliculas");
                            System.out.println("----> 2. CD_Musica");
                            System.out.println("----> 3. Videojuegos");
                            System.out.println("----> 4. Salir");
                            op2 = Utilidades.leerEntero();

                            switch (op2) {
                                case 1:

                                    break;
                                case 2:

                                    break;
                                case 3:

                                    break;
                                case 4:

                                    break;
                            }
                            System.out.println();

                        } while (op2 != 4);

                    } else {

                        System.out.println("Suscripción mensual, todavia no se ha idea como funcionara..");
                    }

                } while (op != 4);

            } else {
                System.out.println("Contraseña incorrecta");
            }
        }
    }

    /**
     *Para dar de anta a los usuarios se hace la llamada a la clase gestor, donde se encuentra
     * el método para añadirlo al arraylist propio de usuarios.
     * @param objGestor
     */

    public static void altaUsuario(clsGestor objGestor) {

        String id = null;
        String contra = null;

        System.out.println("Introduce tus datos; ");
        System.out.print("Usuario: ");
        id = Utilidades.leerCadena();
        System.out.print("Contraseña: ");
        contra = Utilidades.leerCadena();

        objGestor.anadirUsuario(id, contra);
    }

    /**
     * Se recorre el arraylist para visualizar los atributos principales. En este caso sólo el
     * nombre de usuario o identificador.
     * @param listaUsuarios
     */

    public static void visualizarUsuarios(ArrayList<clsUsuario> listaUsuarios) {

        for (clsUsuario usuario : listaUsuarios) {
            System.out.println("Identidicador:  " + usuario.getIdentificador());
        }
    }
}
