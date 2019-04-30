package com.company.LP;

import com.company.COMUN.itfProperty;
import com.company.LN.clsGestor;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static com.company.COMUN.clsConstantes.*;

/**
 * La clase contiene un menu principal donde se centra en el registro, entrada y visualización del usuario.
 * Una vez el usuario se ha registrado y se ha "logeado" tiene disponibloe la opcion de alquilar articulos
 * o un servicio de suscripcion.
 */

public class clsMenuOpciones {

    /**
     * En este menu principal se encargara de seleccionar lo que tiene que ver con los objetos de usuario
     * @throws SQLException excepcion de tipo clase SQL
     * @throws ClassNotFoundException clase exception
     */
    public void menuPrincipal() throws SQLException, ClassNotFoundException {

        int opcion = 0;

        // Creo y declaro el objeto, que senala objGestor y objArticulo
        clsGestor objGestor = new clsGestor();

        /**
         * Se crea el objGestor que apunta a la clase clsGestor. Por medio de los metodos contenidos
         * en esa clase se pueden hacer las funciones principales.
         */

        System.out.println("***************" +
                "BIENVENIDO AL VIDEOCLUB VIRTUAL" +
                "*****************");
        System.out.println();
        System.out.println("Cargando datos.....");

        objGestor.cargarUsuarios();
        objGestor.cargarPeliculas();
        objGestor.cargarVideojuegos();
        objGestor.cargarMusica();

        do {

            System.out.println("Selecciona el tipo de una opcion:");
            System.out.println("----> 1. Entrar ");
            System.out.println("----> 2. Registrarse");
            System.out.println("----> 3. Visualizar Usuarios");
            System.out.println("----> 4. Salir");
            System.out.print("Opcion:");
            opcion = Utilidades.leerEntero();

            /**
             * La primera opcion no esta acabada, lo que quiero es que si el usuario se identifica
             * con un usuario ya existente, puede seguir con los servicios. Aun no he sido capaz de comparar
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
     * @param objG que se le envia el objeto que apunta al gestor.
     */

    private void entrarUsuarios(clsGestor objG) throws SQLException, ClassNotFoundException {

        ArrayList<itfProperty> lUsuarios = objG.leerUsuarios();

        String id = null;
        String contra = null;
        int op = 0;
        int op2 = 0;

        System.out.println("Introduce tus datos; ");
        System.out.print("Usuario: ");
        id = Utilidades.leerCadena();
        System.out.print("Contrasena: ");
        contra = Utilidades.leerCadena();

        for (itfProperty usuario : lUsuarios) {
            if (contra.equals(usuario.getPropertyU(USUARIO_CONTRASENA)) & id.equals(usuario.getPropertyU(USUARIO_IDENTIFICADOR))) {

                System.out.println("Contrasena correcta en unuario: " + usuario.getPropertyU(USUARIO_IDENTIFICADOR));
                System.out.println("Tu codigo de usuario es "+ usuario.getPropertyU(USUARIO_CODIGO_ID));
                do {
                    System.out.println("Selecciona el servicio que deseas:");
                    System.out.println("----> 1. Alquilar articulos ");
                    System.out.println("----> 2. Suscripcion mensual");
                    System.out.println("----> 3. Salir");
                    System.out.print("Opcion:");
                    op = Utilidades.leerEntero();

                    if (op == 1) {

                        do {
                            System.out.println("Selecciona el tipo de articulo a reservar: ");
                            System.out.println("----> 1. Anadir Peliculas");
                            System.out.println("----> 2. Anadir CD_Musica");
                            System.out.println("----> 3. Anadir Videojuegos");
                            System.out.println("----> 4. Visualizar lista peliculas a reservar predeterminada");
                            System.out.println("----> 5. Visualizar lista peliculas a reservar por puntuacion");
                            System.out.println("----> 6. Visualizar lista videojuegos a reservar");
                            System.out.println("----> 7. Visualizar lista videojuegos a reservar por puntuacion");
                            System.out.println("----> 8. Visualizar lista musica a reservar");
                            System.out.println("----> 9. Visualizar lista musica a reservar por anio");
                            System.out.println("----> 10. Visualizar lista todos los articulos disponibles a reservar");
                            System.out.println("----> 11. Salir");
                            System.out.print("Opcion:");
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
                                    objG.visualizarNumPeliculas();
                                    visulalizarPeliculas(objG);
                                    break;
                                case 5:
                                   visualizarPelisPtos(objG);
                                   break;
                                case 6:
                                    objG.visualizarNumVideojuegos();
                                    visualizarVidejuegos(objG);
                                    break;
                                case 7:
                                    visualizarVideojuegosPtos(objG);
                                    break;
                                case 8:
                                    visualizarMusica(objG);
                                    break;
                                case 9:
                                    visualizarMusicaAnio(objG);
                                    break;
                                case 10:
                                    objG.visualizarNumCd();
                                    visualizarArticulos(objG);
                                    break;
                                case 11:
                                    System.out.println("Adios");
                                    break;
                            }
                            System.out.println();

                        } while (op2 != 11);

                    } else {

                        System.out.println("Suscripcion mensual, todavia no se ha ideado como funcionara..");
                    }

                } while (op != 3);

            } else {
                System.out.println("Contrasena incorrecta en unuario: " + usuario.getPropertyU(USUARIO_IDENTIFICADOR));
            }
        }
    }

    /**
     * Este metodo tiene la función de recibir los parametros del usuario para despues introducirlos en un array
     * en clsUsuario
     *
     * @param objG que se le envia el objeto que apunta al gestor.
     */

    private void altaUsuario(clsGestor objG) {

        String id;
        String contra;

        System.out.println("Introduce tus datos; ");
        System.out.print("Usuario: ");
        id = Utilidades.leerCadena();
        System.out.print("Contrasena: ");
        contra = Utilidades.leerCadena();

        objG.anadirUsuario(id, contra);
    }

    /**
     * Esta funcion sierve para visualizar el usuario y un codigo aleatorio generado, este codigo esta
     * pensado que sirva como etiqueta a la hora de seleccionar articulos. Una manera para saber que
     * usuarios tienen disponible la visibilidad de un articulo.
     *
     * @param objG que se le envia el objeto que apunta al gestor.
     */
    private void visulizarUsuarios(clsGestor objG) {

        ArrayList<itfProperty> usuarios = objG.leerUsuarios();

        for (itfProperty usuario : usuarios) {
            System.out.println("Identificador: " + usuario.getPropertyU(USUARIO_IDENTIFICADOR));
            System.out.println("Codigo de usuario aleatorio: " + usuario.getPropertyU(USUARIO_CODIGO_ID));
        }
    }

    /**
     * altaPelicula, altaVideojuego y altaMusica simplemente recoje los datos para llevarlo a la base de datos
     * etc....
     *
     * @param objG que se le envia el objeto que apunta al gestor.
     */
    private void altaPelicula(clsGestor objG) {

        String nombreP = null;
        double precioP = 0;
        double duracionP = 0;

        int pegiPelicula = 0;
        int puntuacionPelicula = 0;
        Date fechaS = null;

        try {
            System.out.println("Introduce los datos de la pelicula;");
            System.out.print("Fecha de salida dd/MM/yyyy: ");
            String fechaSalida = Utilidades.leerCadena();
            fechaS = new SimpleDateFormat("dd/MM/yyyy").parse(fechaSalida);
            System.out.print("precio: ");
            precioP = Utilidades.leerReal();
            System.out.print("Nombre pelicula: ");
            nombreP = Utilidades.leerCadena();
            System.out.print("duracion(min.seg): ");
            duracionP = Utilidades.leerReal();
            System.out.print("pegi de la pelicula: ");
            pegiPelicula = Utilidades.leerEntero();
            System.out.print("puntuacion pelicula: ");
            puntuacionPelicula = Utilidades.leerEntero();
            //Date fechaHoy = new Date("dd/MM/yyyy");

        } catch (ParseException e) {
            e.printStackTrace();
        }

        objG.anadirPelicula(fechaS, nombreP, precioP, duracionP, pegiPelicula, puntuacionPelicula);

    }

    public void altaVideojuego(clsGestor objG) throws SQLException, ClassNotFoundException {

        String nombreV = null;
        double precioV = 0;
        double duracionV = 0;

        int puntuacionVidejuego = 0;
        int pegiVidejuego = 0;
        Date fechaS = null;

        try {

            System.out.println("Introduce los datos del Videojuego;");
            System.out.print("Fecha de salida dd/MM/yyyy: ");
            String fechaSalida = Utilidades.leerCadena();
            fechaS = new SimpleDateFormat("dd/MM/yyyy").parse(fechaSalida);
            System.out.print("precio: ");
            precioV = Utilidades.leerReal();
            System.out.print("Nombre videojuego: ");
            nombreV = Utilidades.leerCadena();
            System.out.print("duracion(min.seg): ");
            duracionV = Utilidades.leerReal();
            System.out.print("puntuacion videojuego: ");
            puntuacionVidejuego = Utilidades.leerEntero();
            System.out.print("pegi videojuego: ");
            pegiVidejuego = Utilidades.leerEntero();
            //Date fechaHoy = new Date("dd/MM/yyyy");

        } catch (ParseException e) {
            e.printStackTrace();
        }

        objG.anadirVideojuego(fechaS ,nombreV, precioV, duracionV, puntuacionVidejuego, pegiVidejuego);

    }

    public void altaMusica_CD(clsGestor objG) throws SQLException, ClassNotFoundException {

        String nombreM = null;
        double precioM = 0;
        double duracionM = 0;

        int anio = 0;
        String artista = null;
        String explicito = null;
        Date fechaS = null;

        try {
            System.out.println("Introduce los datos de la Musica;");
            System.out.print("Fecha de salida dd/MM/yyyy: ");
            String fechaSalida = Utilidades.leerCadena();
            fechaS = new SimpleDateFormat("dd/MM/yyyy").parse(fechaSalida);
            System.out.print("precio: ");
            System.out.print("precio: ");
            precioM = Utilidades.leerReal();
            System.out.println("Nombre musica CD: ");
            nombreM = Utilidades.leerCadena();
            System.out.print("duracion(min.seg): ");
            duracionM = Utilidades.leerReal();
            System.out.print("ano de salida: ");
            anio = Utilidades.leerEntero();
            System.out.print("nombre del artista: ");
            artista = Utilidades.leerCadena();
            System.out.print("explicito o estudio: ");
            explicito = Utilidades.leerCadena();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        objG.anadirMusica_CD(fechaS ,nombreM, precioM, duracionM, anio, artista, explicito);

    }


    public void visulalizarPeliculas(clsGestor objG) {

        objG.visualizarNumPeliculas();
        ArrayList<itfProperty> peliculas = objG.leerPeliculas();

        System.out.println("PELICULAS-----------------------------");
        for (itfProperty pelicula : peliculas) {

            System.out.println("PELICULA");
            System.out.println();
            System.out.println("Fecha de salida: " + pelicula.getPropertyA(PELICULA_FECHA_DEV));
            System.out.println("Identificador Pelicula: " + pelicula.getPropertyA(PELICULA_CODIGO_ID));
            System.out.println("Nombre Pelicula: " + pelicula.getPropertyA(PELICULA_NOMBRE));
            System.out.println("Precio Pelicula: " + pelicula.getPropertyA(PELICULA_PRECIO));
            System.out.println("Duracion Pelicula: " + pelicula.getPropertyA(PELICULA_DURACION));
            System.out.println("Pegi Pelicula: " + pelicula.getPropertyA(PELICULA_PEGI));
            System.out.println("Puntuacion Pelicula: " + pelicula.getPropertyA(PELICULA_PUNTUACION));
            System.out.println();
        }
    }

    public void visualizarVidejuegos(clsGestor objG) {

        ArrayList<itfProperty> videojuegos = objG.leerVideojuegos();

        System.out.println("VIDEOJUEGOS-----------------------------");
        for (itfProperty videjuego : videojuegos) {
            System.out.println("VIDEOJUEGO");
            System.out.println();
            System.out.println("Fecha de salida: " + videjuego.getPropertyA(VIDEOJUEGO_FECHA_DEV));
            System.out.println("Identificador Videojuego: " + videjuego.getPropertyA(VIDEJUEGO_ID));
            System.out.println("Nombre Videojuego: " + videjuego.getPropertyA(VIDEOJUEGO_NOMBRE));
            System.out.println("Precio Videojuego: " + videjuego.getPropertyA(VIDEOJUEGO_PRECIO));
            System.out.println("Duracion Videojuego: " + videjuego.getPropertyA(VIDEOJUEGO_DURACION));
            System.out.println("Puntuacion Videojuego: " + videjuego.getPropertyA(VIDEOJUEGO_PUNTUACION));
            System.out.println("Pegi Videojuego: " + videjuego.getPropertyA(VIDEOJUEGO_PEGI));
            System.out.println();
        }

    }

    public void visualizarMusica(clsGestor objG) {

        ArrayList<itfProperty> musicas = objG.leerMusica();

        System.out.println("MUSICAS-----------------------------");
        for (itfProperty cd : musicas) {
            System.out.println("MUSICA");
            System.out.println();
            System.out.println("Fecha de salida: " + cd.getPropertyA(MUSICA_FECHA_DEV));
            System.out.println("Identificador Musica: " + cd.getPropertyA(MUSICA_ID));
            System.out.println("Nombre Musica: " + cd.getPropertyA(MUSICA_NOMBRE));
            System.out.println("Precio Musica: " + cd.getPropertyA(MUSICA_PRECIO));
            System.out.println("Duracion Musica: " + cd.getPropertyA(MUSICA_DURACION));
            System.out.println("Ano creacion: " + cd.getPropertyA(MUSICA_ANIO));
            System.out.println("Artista: " + cd.getPropertyA(MUSICA_ARTISTA));
            System.out.println("Estudio: " + cd.getPropertyA(MUSICA_EXPLICITO));
            System.out.println();
        }
    }

    /**
     * Este metodo recorre el ArraylisT que se encuentra en clsGestor donde se encuentran todos los objetos
     * de tipo articulo. Se ha utilizado una propiedad especifica para hacer las llamdas a la infomacin
     * que contiene dicho array.
     *
     * @param objG que se le envia el objeto que apunta al gestor.
     */
    public void visualizarArticulos(clsGestor objG) {

        System.out.println(objG.visualizarNumPeliculas()+" peliculas a reservar");
        visulalizarPeliculas(objG);

        System.out.println(objG.visualizarNumVideojuegos()+" videjuegos a reservar");
        visualizarVidejuegos(objG);

        System.out.println(objG.visualizarNumCd()+" canciones a reservar");
        visualizarMusica(objG);

    }


    /**
     * Metodos para mostrar los articulos con metodos de ordenacion dependiendo
     * puntuacion o anio segun el caso
     * @param objG objeto que apunta a clsGestor para hacer la llamada a los metodos necesarios
     */
    private static void visualizarPelisPtos(clsGestor objG){

        objG.visualizarNumPeliculas();
        ArrayList<itfProperty> _peliculas = objG.listaPeliculasPuntos();

        System.out.println("PELICULAS-----------------------------");
        for (itfProperty pelicula : _peliculas) {

            System.out.println("PELICULA");
            System.out.println();
            System.out.println("Identificador Pelicula: " + pelicula.getPropertyA(PELICULA_CODIGO_ID));
            System.out.println("Nombre Pelicula: " + pelicula.getPropertyA(PELICULA_NOMBRE));
            System.out.println("Precio Pelicula: " + pelicula.getPropertyA(PELICULA_PRECIO));
            System.out.println("Duracion Pelicula: " + pelicula.getPropertyA(PELICULA_DURACION));
            System.out.println("Pegi Pelicula: " + pelicula.getPropertyA(PELICULA_PEGI));
            System.out.println("Puntuacion Pelicula: " + pelicula.getPropertyA(PELICULA_PUNTUACION));
            System.out.println();
        }
    }


    private static void visualizarVideojuegosPtos(clsGestor objG){

        objG.visualizarNumVideojuegos();
        ArrayList<itfProperty> _videojuegos = objG.listaVideojuegosPuntos();

        System.out.println("VIDEOJUEGOS-----------------------------");
        for (itfProperty videjuego : _videojuegos) {
            System.out.println("VIDEOJUEGO");
            System.out.println();
            System.out.println("Identificador Videojuego: " + videjuego.getPropertyA(VIDEJUEGO_ID));
            System.out.println("Nombre Videojuego: " + videjuego.getPropertyA(VIDEOJUEGO_NOMBRE));
            System.out.println("Precio Videojuego: " + videjuego.getPropertyA(VIDEOJUEGO_PRECIO));
            System.out.println("Duracion Videojuego: " + videjuego.getPropertyA(VIDEOJUEGO_DURACION));
            System.out.println("Puntuacion Videojuego: " + videjuego.getPropertyA(VIDEOJUEGO_PUNTUACION));
            System.out.println("Pegi Videojuego: " + videjuego.getPropertyA(VIDEOJUEGO_PEGI));
            System.out.println();
        }


    }

    private static void visualizarMusicaAnio (clsGestor objG){

        objG.visualizarNumCd();
        ArrayList<itfProperty> _musicas = objG.listaMusicaAnio();

        System.out.println("MUSICAS-----------------------------");
        for (itfProperty cd : _musicas) {
            System.out.println("MUSICA");
            System.out.println();
            System.out.println("Identificador Musica: " + cd.getPropertyA(MUSICA_ID));
            System.out.println("Nombre Musica: " + cd.getPropertyA(MUSICA_NOMBRE));
            System.out.println("Precio Musica: " + cd.getPropertyA(MUSICA_PRECIO));
            System.out.println("Duracion Musica: " + cd.getPropertyA(MUSICA_DURACION));
            System.out.println("Ano creacion: " + cd.getPropertyA(MUSICA_ANIO));
            System.out.println("Artista: " + cd.getPropertyA(MUSICA_ARTISTA));
            System.out.println("Estudio: " + cd.getPropertyA(MUSICA_EXPLICITO));
            System.out.println();
        }
    }
}