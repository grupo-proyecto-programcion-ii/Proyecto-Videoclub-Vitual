package com.company.LD;

import org.omg.CORBA.PUBLIC_MEMBER;

public class clsConstantesBD {

    /**
     *Constantes de usuario, contraseña, pueeto. nombre base de datos
     * y dirección
     */

    public final static String USER = "root";
    public final static String PASS = "lossolfamidas";
    public final static String PORT = "3306";
    public final static String DATABASE = "videoclub";
    public final static String DIRECTION = "127.0.0.1";
    public final static String URL = "jdbc:mysql://" + DIRECTION + ":" + PORT + "/" + DATABASE + "?useTimezone=true&serverTimezone=GMT&useSSL=false&allowPublicKeyRetrieval=true";
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static final String INSERT_USUARIO = "INSERT INTO Usuarios (identificador,contrasena)VALUES(?,?)";
    public static final String SELECT_USUARIOS = "SELECT * FROM videoclub.usuarios";

    public static final String INSERT_PELICULA = "INSERT INTO Películas (nombre,precio,duracion,pegiP,puntuacionP)VALUES(?,?,?,?,?)";
    public static final String SELECT_PELICULAS = "SELECT * FROM viodeclub.peliculas";

    public static final String INSERT_VIDEOJUEGO = "INSERT INTO Videjuegos (nombre,precio,duracion,puntuacionV,pegiVidejuegos)VALUES(?,?,?,?,?)";
    public static final String SELECT_VIDEOJUEGOS = "SELECT * FROM viodeclub.videojuegos";

    public static final String INSERT_MUSICA = "INSERT INTO Música CD (nombre,precio,duracion,artistas,anio,explicito)VALUES(?,?,?,?,?,?)";
    public static final String SELECT_MUSICA = "SELECT * FROM videoclub.musica";



}

