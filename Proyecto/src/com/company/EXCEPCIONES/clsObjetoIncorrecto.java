package com.company.EXCEPCIONES;

public class clsObjetoIncorrecto extends RuntimeException {

    private String prop;

    public clsObjetoIncorrecto(String prop) {
        this.prop = prop;
    }

    public String getMessage() {
        return this.prop;
    }
}
