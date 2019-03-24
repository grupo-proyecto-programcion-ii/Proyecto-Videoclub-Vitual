package com.company.LP;

        import com.company.COMUN.itfProperty;
        import com.company.LN.clsArticulo;
        import com.company.LN.clsGestor;
        import com.company.LN.clsUsuario;

        import java.util.ArrayList;
        import java.util.Iterator;
        import java.util.Random;

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

    private  clsGestor objGestor = new clsGestor();

    public void menuPrincipal() {

        int opcion = 0;
        // Creo y declaro el objeto, que señala objGestor y objArticulo
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
                    entrarUsuarios(objGestor);
                    break;
                case 2:
                    altaUsuario(objGestor);
                    break;
                case 3:
                    objGestor.visualizarNumUsuarios();
                    visulizarUsuarios(objGestor);
                    break;
                case 4:
                    System.out.println("Fin del programa");
                    break;
            }
            System.out.println();
        } while (opcion != 4);
    }

    public void entrarUsuarios(clsGestor objG) {

        ArrayList<itfProperty> lUsuarios = objG.leerUsuarios();

        String id = null;
        String contra = null;
        int op = 0;
        int op2 = 0;

        System.out.println("Introduce tus datos; ");
        System.out.print("Usuario: ");
        id = Utilidades.leerCadena();
        System.out.print("Contraseña: ");
        contra = Utilidades.leerCadena();

        for (itfProperty usuario:lUsuarios) {
            if (contra.equals(usuario.getProperty("Contraseña")) & id.equals(usuario.getProperty("Identificador"))) {

                System.out.println("Contraseña correcta en unuario: " + usuario.getProperty("Identificador"));

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
                            System.out.println("----> 4. Visualizar lista articulos reservados");
                            System.out.println("----> 5. Salir");
                            op2 = Utilidades.leerEntero();

                            switch (op2) {
                                case 1:
                                    altaPelicula(objGestor);
                                    break;
                                case 2:
                                    altaMusica_CD(objGestor);
                                    break;
                                case 3:
                                    altaVideojuego(objGestor);
                                    break;
                                case 4:

                                    break;
                                case 5:
                                    System.out.println("Adios");
                                    break;
                            }
                            System.out.println();

                        } while (op2 != 5);

                    } else {

                        System.out.println("Suscripción mensual, todavia no se ha idea como funcionara..");
                    }

                } while (op != 3);

            } else {
                System.out.println("Contraseña incorrecta en unuario: " + usuario.getProperty("Identificador"));
            }
        }
    }

    /**
     * Para dar de anta a los usuarios se hace la llamada a la clase gestor, donde se encuentra
     * el método para añadirlo al arraylist propio de usuarios.
     *
     * @param objG
     */

    public static void altaUsuario(clsGestor objG) {

        Random r = new Random();

        int codigoAleatorio = r.nextInt(1000);
        String id = null;
        String contra = null;

        System.out.println("Introduce tus datos; ");
        System.out.print("Usuario: ");
        id = Utilidades.leerCadena();
        System.out.print("Contraseña: ");
        contra = Utilidades.leerCadena();

        objG.anadirUsuario(id, contra, codigoAleatorio);
    }


    public static void visulizarUsuarios (clsGestor objG){

        ArrayList<itfProperty> usuarios = objG.leerUsuarios();

        for (itfProperty usuario:usuarios){
            System.out.println("Identificador: "+usuario.getProperty("Identificador"));
            System.out.println("Codigo de usuario aleatorio: "+usuario.getProperty("CodigoAleatorio"));
        }
    }

    public static void altaPelicula(clsGestor objG) {

        int idPelicula = 0;
        String nombreP = null;
        double precioP = 0;
        double duracionP = 0;

        int pegiPelicula = 0;
        int puntuacionPelicula = 0;

        System.out.println("Introduce los datos de la película;");
        System.out.print("precio: ");
        precioP = Utilidades.leerReal();
        System.out.println("Nombre pelicula: ");
        nombreP = Utilidades.leerCadena();
        System.out.print("duración(min.seg): ");
        duracionP = Utilidades.leerReal();
        System.out.print("pegi de la pelicula: ");
        pegiPelicula = Utilidades.leerEntero();
        System.out.print("puntuación película: ");
        puntuacionPelicula = Utilidades.leerEntero();

        objG.anadirPelicula(idPelicula, nombreP, precioP, duracionP, pegiPelicula, puntuacionPelicula);

    }

    public static void altaVideojuego(clsGestor objG) {

        int idVideojuego = 0;
        String nombreV = null;
        double precioV = 0;
        double duracionV = 0;

        int puntuacionVidejuego = 0;
        int pegiVidejuego = 0;

        System.out.println("Introduce los datos del Videojuego;");
        System.out.print("precio: ");
        precioV = Utilidades.leerReal();
        System.out.println("Nombre videojuego: ");
        nombreV = Utilidades.leerCadena();
        System.out.print("duración(min.seg): ");
        duracionV = Utilidades.leerReal();
        System.out.println("puntuación videojuego: ");
        puntuacionVidejuego = Utilidades.leerEntero();
        System.out.println("pegi videojuego: ");
        pegiVidejuego = Utilidades.leerEntero();

        objG.anadirVideojuego(idVideojuego, nombreV, precioV, duracionV, puntuacionVidejuego, pegiVidejuego);

    }

    public static void altaMusica_CD(clsGestor objG) {

        int idMusica = 0;
        String nombreM = null;
        double precioM = 0;
        double duracionM = 0;

        int anio = 0;
        String artista = null;
        String explicito = null;

        System.out.println("Introduce los datos de la Musica;");
        System.out.print("precio: ");
        precioM = Utilidades.leerReal();
        System.out.println("Nombre música CD: ");
        nombreM = Utilidades.leerCadena();
        System.out.print("duración(min.seg): ");
        duracionM = Utilidades.leerReal();
        System.out.print("año de salida: ");
        anio = Utilidades.leerEntero();
        System.out.print("nombre del artista: ");
        artista = Utilidades.leerCadena();
        System.out.println("explicito o estudio: ");
        explicito = Utilidades.leerCadena();

        objG.anadirMusica_CD(idMusica, nombreM, precioM, duracionM, anio, artista, explicito);

    }

    public static void visualizarArticulos (clsGestor objG){

        ArrayList<itfProperty> articulos = objG.leerUsuarios();

        for (itfProperty articulo:articulos){
            //System.out.println("Identificador: "+usuario.getProperty("Identificador"));
            //System.out.println("Codigo de usuario aleatorio: "+usuario.getProperty("CodigoAleatorio"));
        }
    }



}
