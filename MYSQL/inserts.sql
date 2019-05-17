#DELETE FROM usuarios_has_peliculas WHERE idAlquiler = 3;
#INSERT INTO usuarios_has_videojuegos (usuarios_codigoAleatoria, videojuegos_id, fecha_devolucionV) VALUES (1,3,"2019/04/01");
#SELECT*FROM usuarios_has_peliculas;
#SELECT*FROM videojuegos;

#ALTER TABLE usuarios ADD suscripcion boolean;
#select*FROM videoclub.usuarios;
#ALTER TABLE videoclub.usuarios ADD suscripcion BOOLEAN default FALSE;
#DESC videoclub.usuarios;
#
INSERT INTO videoclub.usuarios (identificador, contrasena, nombre,
 apellidos, correoE, numeroTarjeta, fechaNacimiento, costeTotal, suscripcion, fechaSuscripcion)
 VALUES ("rgt", "rgb", "rbt", "grb", "tb", "fhn", "1996/05/09", 56,false, "18/01/1997");
#
#select*FROM videoclub.usuarios;
