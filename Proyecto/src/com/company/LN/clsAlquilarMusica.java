package com.company.LN;

import com.company.COMUN.itfProperty;

import java.util.Date;

public class clsAlquilarMusica extends clsAlquiler implements itfProperty {

    private int musica_id;
    private Date musica_fechaDevM;

    public int getMusica_id() {
        return musica_id;
    }

    public void setMusica_id(int musica_id) {
        this.musica_id = musica_id;
    }

    public Date getMusica_fechaDevM() {
        return musica_fechaDevM;
    }

    public void setMusica_fechaDevM(Date musica_fechaDevM) {
        this.musica_fechaDevM = musica_fechaDevM;
    }

    public clsAlquilarMusica(int idAlquiler, int usuarios_codigo, int musica_id, Date musica_fechaDevM) {
        super(idAlquiler, usuarios_codigo);
        this.musica_id = musica_id;
        this.musica_fechaDevM = musica_fechaDevM;
    }

    public clsAlquilarMusica(int codigo, int musica_id, Date musica_fechaDevM) {
        super(codigo);
        this.musica_id = musica_id;
        this.musica_fechaDevM = musica_fechaDevM;
    }

    public clsAlquilarMusica() {
    }
}
