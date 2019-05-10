package com.company.LD;


public class clsConstantesBD {

    /**
     *Constantes de usuario, contrasena, pueeto. nombre base de datos
     * y direccion
     */

    public final static String USER = "root";
    public final static String PASS = "lossolfamidas";
    public final static String PORT = "3306";
    public final static String DATABASE = "videoclub";
    public final static String DIRECTION = "127.0.0.1";
    public final static String URL = "jdbc:mysql://" + DIRECTION + ":" + PORT + "/" + DATABASE + "?useTimezone=true&serverTimezone=GMT&useSSL=false&allowPublicKeyRetrieval=true";
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static final String INSERT_USUARIO = "INSERT INTO usuarios (identificador,contrasena)VALUES(?,?)";
    public static final String SELECT_USUARIOS = "SELECT * FROM videoclub.usuarios";

    public static final String INSERT_PELICULA = "INSERT INTO peliculas (fechaSalida,nombre,precio,duracion,pegiP,puntuacionP)VALUES(?,?,?,?,?,?)";
    public static final String SELECT_PELICULAS = "SELECT * FROM videoclub.peliculas";

    public static final String INSERT_VIDEOJUEGO = "INSERT INTO videojuegos (fechaSalida,nombre,precio,duracion,puntuacionV,pegiVideojuegos)VALUES(?,?,?,?,?,?)";
    public static final String SELECT_VIDEOJUEGOS = "SELECT * FROM videoclub.videojuegos";

    public static final String INSERT_MUSICA = "INSERT INTO musica (fechaSalida,nombre,precio,duracion,artistas,anio,explicito)VALUES(?,?,?,?,?,?,?)";
    public static final String SELECT_MUSICA = "SELECT * FROM videoclub.musica";

    public static final String  INSERT_ALQUILER_PELICULA = "INSERT INTO usuarios_has_peliculas (usuarios_codigoAleatoria, peliculas_id, fecha_devolucionP) VALUES (?,?,?)";
    public static final String SELECT_ALQUILER_PELICULAS = "SELECT * FROM videoclub.usuarios_has_peliculas";
    public static final String DELETE_PELICULA = "DELETE FROM usuarios_has_peliculas WHERE idAlquiler = ?";
}

