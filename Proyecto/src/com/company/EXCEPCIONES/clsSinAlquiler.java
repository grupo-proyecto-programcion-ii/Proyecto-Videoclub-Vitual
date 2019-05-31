package com.company.EXCEPCIONES;

public class clsSinAlquiler extends Throwable {
    public String getMessage() {
        return "no se ha hecho un alquiler)";
    }
}
