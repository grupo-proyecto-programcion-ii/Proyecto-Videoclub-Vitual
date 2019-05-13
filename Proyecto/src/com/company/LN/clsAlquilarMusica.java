package com.company.LN;

import com.company.COMUN.itfProperty;

import java.util.Date;

import static com.company.COMUN.clsConstantes.*;


public class clsAlquilarMusica extends clsAlquiler implements itfProperty {

    private int musica_id;
    private Date fecha_DevolucionM;

    public int getMusica_id() {
        return musica_id;
    }

    public void setMusica_id(int musica_id) {
        this.musica_id = musica_id;
    }

    public Date getFecha_DevolucionM() {
        return fecha_DevolucionM;
    }

    public void setFecha_DevolucionM(Date fecha_DevolucionM) {
        this.fecha_DevolucionM = fecha_DevolucionM;
    }

    public clsAlquilarMusica(int idAlquiler, int usuarios_codigo, int musica_id, Date fecha_DevolucionM) {
        super(idAlquiler, usuarios_codigo);
        this.musica_id = musica_id;
        this.fecha_DevolucionM = fecha_DevolucionM;
    }

    public clsAlquilarMusica(int codigo, int musica_id, Date fecha_DevolucionM) {
        super(codigo);
        this.musica_id = musica_id;
        this.fecha_DevolucionM = fecha_DevolucionM;
    }

    public clsAlquilarMusica() {
    }

    @Override
    public Object getPropertyU(String objPropiedad) {

        return null;
    }

    @Override
    public Object getPropertyA(String obj_Propiedad) {
        switch (obj_Propiedad) {

            case ALQUILER_MUSICA_ID:
                return this.getIdAlquiler();
            case ALQUILER_MUSICA_USUARIOS_CODIGO:
                return this.getUsuarios_codigo();
            case ALQUILER_MUSICA_ID_PROPIA:
                return this.getMusica_id();
            case ALQUILER_MUSICA_FECHADEV:
                return this.getFecha_DevolucionM();
        }
        return null;
    }
}
