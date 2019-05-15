package com.company.EXCEPCIONES;

public class clsIdAlquilerRepetido extends RuntimeException {

    public String mensajeIdRpetido(){
        return"No se puede introducir un id ya existente en la base de datos";
    }
}
