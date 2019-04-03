package com.company.LP;

import com.company.COMUN.itfProperty;
import com.company.LN.clsGestor;
import static com.company.COMUN.clsConstantes.*;

import java.util.ArrayList;
import java.util.Random;

/**
 * La clase contiene un menu principal donde se centra en el registro, entrada y visualización del usuario.
 * Una vez el usuario se ha registrado y se ha "logeado" tiene disponibloe la opción de alquilar articulos
 * o un servicio de suscrición.
 */

public class clsMenuOpciones {

    /**
     * En éste menu principal se encargará de seleccionar todo lo que tiene que ver con el usuario
     */

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

    /**
     * Una vez el usuario se ha registrado se conprueban sus credenciales y se le da la posibilidad a disponer de
     * servicios.
     *
     * @param objG
     */

    private void entrarUsuarios(clsGestor objG) {

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

        for (itfProperty usuario : lUsuarios) {
            if (contra.equals(usuario.getPropertyU("Contraseña")) & id.equals(usuario.getPropertyU("Identificador"))) {

                System.out.println("Contraseña correcta en unuario: " + usuario.getPropertyU("Identificador"));

                do {
                    System.out.println("Selecciona el servicio que deseas:");
                    System.out.println("----> 1. Alquilar artículos ");
                    System.out.println("----> 2. Suscripcuón mensual");
                    System.out.println("----> 3. Salir");
                    System.out.print("Opción:");
                    op = Utilidades.leerEntero();

                    if (op == 1) {

                        do {
                            System.out.println("Selecciona el tipo de artículo a reservar: ");
                            System.out.println("----> 1. Añadir Peliculas");
                            System.out.println("----> 2. Añadir CD_Musica");
                            System.out.println("----> 3. Añadir Videojuegos");
                            System.out.println("----> 4. Visualizar lista peliculas reservados");
                            System.out.println("----> 5. Visualizar lista videojuegos  reservados");
                            System.out.println("----> 6. Visualizar lista musica reservados");
                            System.out.println("----> 7. Visualizar lista todos los articulos reservados");
                            System.out.println("----> 8. Salir");
                            System.out.print("Opción:");
                            op2 = Utilidades.leerEntero();

                            switch (op2) {
                                case 1:
                                    altaPelicula(objG);
                                    break;
                                case 2:
                                    altaMusica_CD(objG);
                                    break;
                                case 3:
                                    altaVideojuego(objG);
                                    break;
                                case 4:
                                    visulalizarPeliculas(objG);
                                    break;
                                case 5:
                                    visualizarVidejuegos(objG);
                                    break;
                                case 6:
                                    visualizarMusica(objG);
                                    break;
                                case 7:
                                    visualizarArticulos(objG);
                                    break;
                                case 8:
                                    System.out.println("Adios");
                                    break;
                            }
                            System.out.println();

                        } while (op2 != 8);

                    } else {

                        System.out.println("Suscripción mensual, todavia no se ha idea como funcionara..");
                    }

                } while (op != 3);

            } else {
                System.out.println("Contraseña incorrecta en unuario: " + usuario.getPropertyU("Identificador"));
            }
        }
    }

    /**
     * Este método tiene la función de recibir los parámetros del usuario para después introducirlos en un array
     * en clsUsuario
     *
     * @param objG
     */

    private static void altaUsuario(clsGestor objG) {

        String id;
        String contra;

        System.out.println("Introduce tus datos; ");
        System.out.print("Usuario: ");
        id = Utilidades.leerCadena();
        System.out.print("Contraseña: ");
        contra = Utilidades.leerCadena();

        objG.anadirUsuario(id, contra);
    }

    /**
     * ésta función sierve para visualizar el usuario y un código aleatorio generado, éste código está
     * pensado que sirva como etiqueta a la hora de seleccionar artículos. Una manera para saber qué
     * usuarios tienen disponible la visibilidad de un artículo.
     *
     * @param objG
     */
    private static void visulizarUsuarios(clsGestor objG) {

        ArrayList<itfProperty> usuarios = objG.leerUsuarios();

        for (itfProperty usuario : usuarios) {
            System.out.println("Identificador: " + usuario.getPropertyU(USUARIO_IDENTIFICADOR));
            System.out.println("Codigo de usuario aleatorio: " + usuario.getPropertyU(USUARIO_CONTRASENA));
        }
    }

    /**
     * altaPelicula, altaVideojuego y altaMusica simplemente recoje los datos para llevarlo a la base de datos
     * etc....
     *
     * @param objG
     */
    private static void altaPelicula(clsGestor objG) {

        int idPelicula = 1;
        String nombreP = null;
        double precioP = 0;
        double duracionP = 0;

        int pegiPelicula = 0;
        int puntuacionPelicula = 0;

        System.out.println("Introduce los datos de la película;");
        System.out.print("precio: ");
        precioP = Utilidades.leerReal();
        System.out.print("Nombre pelicula: ");
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

        int idVideojuego = 2;
        String nombreV = null;
        double precioV = 0;
        double duracionV = 0;

        int puntuacionVidejuego = 0;
        int pegiVidejuego = 0;

        System.out.println("Introduce los datos del Videojuego;");
        System.out.print("precio: ");
        precioV = Utilidades.leerReal();
        System.out.print("Nombre videojuego: ");
        nombreV = Utilidades.leerCadena();
        System.out.print("duración(min.seg): ");
        duracionV = Utilidades.leerReal();
        System.out.print("puntuación videojuego: ");
        puntuacionVidejuego = Utilidades.leerEntero();
        System.out.print("pegi videojuego: ");
        pegiVidejuego = Utilidades.leerEntero();

        objG.anadirVideojuego(idVideojuego, nombreV, precioV, duracionV, puntuacionVidejuego, pegiVidejuego);

    }

    public static void altaMusica_CD(clsGestor objG) {

        int idMusica = 3;
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
        System.out.print("explicito o estudio: ");
        explicito = Utilidades.leerCadena();

        objG.anadirMusica_CD(idMusica, nombreM, precioM, duracionM, anio, artista, explicito);

    }


    public static void visulalizarPeliculas(clsGestor objG) {

        objG.visualizarNumPeliculas();
        ArrayList<itfProperty> peliculas = objG.leerPeliculas();

        System.out.println("PELICULAS-----------------------------");
        for (itfProperty pelicula : peliculas) {

            System.out.println("PELICULA");
            System.out.println();
            System.out.println("Identificador Pelicula: " + pelicula.getPropertyA(PELICULA_CODIGO_ID));
            System.out.println("Nombre Pelicula: " + pelicula.getPropertyA(PELICULA_NOMBRE));
            System.out.println("Precio Pelicula: " + pelicula.getPropertyA(PELICULA_PRECIO));
            System.out.println("Duración Pelicula: " + pelicula.getPropertyA(PELICULA_DURACION));
            System.out.println("Pegi Pelicula: " + pelicula.getPropertyA(PELICULA_PEGI));
            System.out.println("Puntuación Pelicula: " + pelicula.getPropertyA(PELICULA_PUNTUACION));
            System.out.println();
        }

    }

    public static void visualizarVidejuegos(clsGestor objG) {

        objG.visualizarNumVideojuegos();
        ArrayList<itfProperty> videojuegos = objG.leerVideojuegos();

        System.out.println("VIDEOJUEGOS-----------------------------");
        for (itfProperty videjuego : videojuegos) {
            System.out.println("VIDEOJUEGO");
            System.out.println();
            System.out.println("Identificador Videojuego: " + videjuego.getPropertyA("IdentificadorV"));
            System.out.println("Nombre Videojuego: " + videjuego.getPropertyA("NombreV"));
            System.out.println("Precio Videojuego: " + videjuego.getPropertyA("PrecioV"));
            System.out.println("Duración Videojuego: " + videjuego.getPropertyA("DuracionV"));
            System.out.println("Puntuación Videojuego: " + videjuego.getPropertyA("PuntuacionV"));
            System.out.println("Pegi Videojuego: " + videjuego.getPropertyA("PegiV"));
            System.out.println();
        }

    }

    public static void visualizarMusica(clsGestor objG) {

        objG.visualizarNumCd();
        ArrayList<itfProperty> musicas = objG.leerMusica();

        System.out.println("MUSICAS-----------------------------");
        for (itfProperty cd : musicas) {
            System.out.println("MUSICA");
            System.out.println();
            System.out.println("Identificador Musica: " + cd.getPropertyA("IdentificadorM"));
            System.out.println("Nombre Musica: " + cd.getPropertyA("NombreM"));
            System.out.println("Precio Musica: " + cd.getPropertyA("PrecioM"));
            System.out.println("Duración Musica: " + cd.getPropertyA("DuracionM"));
            System.out.println("Año creación: " + cd.getPropertyA("Anio"));
            System.out.println("Artista: " + cd.getPropertyA("artista"));
            System.out.println("Estudio: " + cd.getPropertyA("Explicito"));
            System.out.println();
        }

    }

    /**
     * éste método recorre el ArraylisT que se encuentra en clsGestor donde se encuentran todos los objetos
     * de tipo artículo. Se ha utilizado una propiedad específica para hacer las llamdas a la infomación
     * que contiene dicho array.
     *
     * @param objG
     */
    public static void visualizarArticulos(clsGestor objG) {

        ArrayList<itfProperty> peliculas = objG.leerPeliculas();
        ArrayList<itfProperty> videojuegos = objG.leerVideojuegos();
        ArrayList<itfProperty> musicas = objG.leerMusica();

        System.out.println("PELICULAS");
        for (itfProperty pelicula : peliculas) {

            System.out.println("PELICULA-----------------------------");
            System.out.println();
            System.out.println("Identificador Pelicula: " + pelicula.getPropertyA(PELICULA_CODIGO_ID));
            System.out.println("Nombre Pelicula: " + pelicula.getPropertyA(PELICULA_NOMBRE));
            System.out.println("Precio Pelicula: " + pelicula.getPropertyA(PELICULA_PRECIO));
            System.out.println("Duración Pelicula: " + pelicula.getPropertyA(PELICULA_DURACION));
            System.out.println("Pegi Pelicula: " + pelicula.getPropertyA(PELICULA_PEGI));
            System.out.println("Puntuación Pelicula: " + pelicula.getPropertyA(PELICULA_PUNTUACION));
            System.out.println();
        }

        System.out.println("VIDEOJUEGOS-----------------------------");
        for (itfProperty videjuego : videojuegos) {
            System.out.println("VIDEOJUEGO");
            System.out.println();
            System.out.println("Identificador Videojuego: " + videjuego.getPropertyA("IdentificadorV"));
            System.out.println("Nombre Videojuego: " + videjuego.getPropertyA("NombreV"));
            System.out.println("Precio Videojuego: " + videjuego.getPropertyA("PrecioV"));
            System.out.println("Duración Videojuego: " + videjuego.getPropertyA("DuracionV"));
            System.out.println("Puntuación Videojuego: " + videjuego.getPropertyA("PuntuacionV"));
            System.out.println("Pegi Videojuego: " + videjuego.getPropertyA("PegiV"));
            System.out.println();
        }

        System.out.println("MUSICAS-----------------------------");
        for (itfProperty cd : musicas) {
            System.out.println("MUSICA");
            System.out.println();
            System.out.println("Identificador Musica: " + cd.getPropertyA("IdentificadorM"));
            System.out.println("Nombre Musica: " + cd.getPropertyA("NombreM"));
            System.out.println("Precio Musica: " + cd.getPropertyA("PrecioM"));
            System.out.println("Duración Musica: " + cd.getPropertyA("DuracionM"));
            System.out.println("Año creación: " + cd.getPropertyA("Anio"));
            System.out.println("Artista: " + cd.getPropertyA("artista"));
            System.out.println("Estudio: " + cd.getPropertyA("Explicito"));
            System.out.println();
        }


    }
}
