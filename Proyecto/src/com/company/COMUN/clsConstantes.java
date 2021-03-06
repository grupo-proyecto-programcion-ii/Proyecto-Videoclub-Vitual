package com.company.COMUN;


/**
 * Constantes de todas las carpetas en comun que abarca usuario y sus articulos
 *
 * IMPORTANTE los nombres de los atributos sean iguales que en la base de datos
 */
public class clsConstantes {

    public static final String USUARIO_CODIGO_ID = "CodigoAleatoria";
    public static final String USUARIO_IDENTIFICADOR = "Identificador";
    public static final String USUARIO_CONTRASENA = "Contrasena";
    public static final String USUARIO_NOMBRE = "Nombre";
    public static final String USUARIO_APELLIDOS = "Apellidos";
    public static final String USUARIO_CORREO = "CorreoE";
    public static final String USUARIO_TARJETA = "NumeroTarjeta";
    public static final String USUARIO_FECHA_NACIMINETO = "FechaNacimiento";
    public static final String USUARIO_COSTE_TOTAL = "CosteTotal";
    public static final String USUARIO_SUSCRIPCION = "Suscripcion";
    public static final String USUARIO_FECHA_SUSCRIPCION = "FechaSuscripcion";


    public static final String PELICULA_CODIGO_ID = "id";
    public static final String PELICULA_FECHA_SALIDA = "FechaSalida";
    public static final String PELICULA_NOMBRE = "Nombre";
    public static final String PELICULA_PRECIO = "Precio";
    public static final String PELICULA_DURACION = "Duracion";
    public static final String PELICULA_PEGI = "PegiP";
    public static final String PELICULA_PUNTUACION = "PuntuacionP";


    public static final String VIDEJUEGO_ID = "id";
    public static final String VIDEOJUEGO_FECHA_SALIDA = "FechaSalida";
    public static final String VIDEOJUEGO_NOMBRE = "Nombre";
    public static final String VIDEOJUEGO_PRECIO = "Precio";
    public static final String VIDEOJUEGO_DURACION = "Duracion";
    public static final String VIDEOJUEGO_PUNTUACION = "PuntuacionV";
    public static final String VIDEOJUEGO_PEGI = "PegiVideojuegos";

    public static final String MUSICA_ID = "id";
    public static final String MUSICA_FECHA_SALIDA = "FechaSalida";
    public static final String MUSICA_NOMBRE = "Nombre";
    public static final String MUSICA_PRECIO = "Precio";
    public static final String MUSICA_DURACION = "Duracion";
    public static final String MUSICA_ANIO = "Anio";
    public static final String MUSICA_ARTISTA = "Artistas";
    public static final String MUSICA_EXPLICITO = "Explicito";

    public static final String ALQUILER_PELICULA_ID = "IdAlquiler";
    public static final String ALQUILER_PELICULA_USUARIOS_CODIGO = "Usuarios_CodigoAleatoria";
    public static final String ALQUILER_PELICULA_ID_PROPIA = "Peliculas_Id";
    public static final String ALQUILER_PELICULA_FECHADEV = "Fecha_DevolucionP";

    public static final String ALQUILER_VIDEOJUEGO_ID = "IdAlquiler";
    public static final String ALQUILER_VIDEOJUEGO_USUARIOS_CODIGO = "Usuarios_CodigoAleatoria";
    public static final String ALQUILER_VIDEOJUEGO_ID_PROPIA = "Videojuegos_Id";
    public static final String ALQUILER_VIDEOJUEGO_FECHADEV = "Fecha_DevolucionV";

    public static final String ALQUILER_MUSICA_ID = "IdAlquiler";
    public static final String ALQUILER_MUSICA_USUARIOS_CODIGO = "Usuarios_CodigoAleatoria";
    public static final String ALQUILER_MUSICA_ID_PROPIA = "Musica_Id";
    public static final String ALQUILER_MUSICA_FECHADEV = "Fecha_DevolucionM";

    public static final String MENSAJE_ERROR = "Error..";
    public static final String MENSAJE_ERROR2 = "No se encontró ese ID..";

}
