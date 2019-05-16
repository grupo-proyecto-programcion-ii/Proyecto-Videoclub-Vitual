#DELETE FROM usuarios_has_peliculas WHERE idAlquiler = 3;
#INSERT INTO usuarios_has_videojuegos (usuarios_codigoAleatoria, videojuegos_id, fecha_devolucionV) VALUES (1,3,"2019/04/01");
#SELECT*FROM usuarios_has_peliculas;
#SELECT*FROM videojuegos;

#ALTER TABLE usuarios ADD suscripcion boolean;
#select*FROM usuarios;
#ALTER TABLE videoclub.usuarios ADD suscripcion BOOLEAN default FALSE;
#
DESC videoclub.usuarios;
INSERT INTO videoclub.usuarios (codigoAleatoria, identificador, contrasena, nombre,
 apellidos, correoE, numeroTarjeta, fechaNacimiento, costeTotal, suscripcion)
 VALUES (3, "rgt", "rgb", "rbt", "grb", "tb", "fhn", "1996/05/09", 56, null);
#
select*FROM videoclub.usuarios;
