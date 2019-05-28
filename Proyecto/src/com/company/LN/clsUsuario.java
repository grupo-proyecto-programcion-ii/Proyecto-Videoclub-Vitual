package com.company.LN;

import com.company.COMUN.itfProperty;

import java.util.Date;

import static com.company.COMUN.clsConstantes.*;
import static com.company.COMUN.clsConstantes.USUARIO_CONTRASENA;


/**
 * Esta clase contiene atributos y el contructor para el usuario.
 */
public class clsUsuario implements itfProperty {

    /**
     * Atributos geters y seters
     */
    private int codigoAleatoria;
    private String identificador = null;
    private String contrasena = null;
    private String nombre = null;
    private String apellidos = null;
    private String correoE = null;
    private String numeroTarjeta;
    private Date fechaNacimiento;
    private double costeTotal;
    private boolean suscripcion = false;
    private Date fechaSuscripcion;

    public int getCodigoAleatoria() {
        return codigoAleatoria;
    }

    public void setCodigoAleatoria(int _codigoAleatoria) {
        this.codigoAleatoria = _codigoAleatoria;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String _identificador) {
        this.identificador = _identificador;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String _contrasena) {
        this.contrasena = _contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreoE() {
        return correoE;
    }

    public void setCorreoE(String correoE) {
        this.correoE = correoE;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public double getCosteTotal() {
        return costeTotal;
    }

    public void setCosteTotal(double costeTotal) {
        this.costeTotal = costeTotal;
    }

    public boolean isSuscripcion() {
        return suscripcion;
    }

    public void setSuscripcion(boolean suscripcion) {
        this.suscripcion = suscripcion;
    }

    public Date getFechaSuscripcion() {
        return fechaSuscripcion;
    }

    public void setFechaSuscripcion(Date fechaSuscripcion) {
        this.fechaSuscripcion = fechaSuscripcion;
    }


    public clsUsuario(String identificador, String contrasena,
                      String nombre, String apellidos, String correoE,
                      String numeroTarjeta, Date fechaNacimiento,
                      double costeTotal, boolean suscripcion, Date fechaSuscripcion) {
        this.identificador = identificador;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correoE = correoE;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaNacimiento = fechaNacimiento;
        this.costeTotal = costeTotal;
        this.suscripcion = suscripcion;
        this.fechaSuscripcion = fechaSuscripcion;
    }

    public clsUsuario(int codigoAleatoria, String identificador, String contrasena, String nombre,
                      String apellidos, String correoE, String numeroTarjeta,
                      Date fechaNacimiento, double costeTotal, boolean suscripcion, Date fechaSuscripcion) {
        this.codigoAleatoria = codigoAleatoria;
        this.identificador = identificador;
        this.contrasena = contrasena;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correoE = correoE;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaNacimiento = fechaNacimiento;
        this.costeTotal = costeTotal;
        this.suscripcion = suscripcion;
        this.fechaSuscripcion = fechaSuscripcion;
    }

    public clsUsuario() {

    }

    /**
     * Método para obtener los datos de los atributos de usuarios.
     *
     * @param propiedad objeto que tra la interfaz
     * @return valores a los atributos
     */
    public Object getPropertyU(String propiedad) {

        switch (propiedad) {
            case USUARIO_CODIGO_ID:
                return this.codigoAleatoria;
            case USUARIO_IDENTIFICADOR:
                return this.identificador;
            case USUARIO_CONTRASENA:
                return this.contrasena;
            case USUARIO_NOMBRE:
                return this.nombre;
            case USUARIO_APELLIDOS:
                return this.apellidos;
            case USUARIO_CORREO:
                return this.correoE;
            case USUARIO_TARJETA:
                return this.numeroTarjeta;
            case USUARIO_FECHA_NACIMINETO:
                return this.fechaNacimiento;
            case USUARIO_COSTE_TOTAL:
                return this.costeTotal;
            case USUARIO_SUSCRIPCION:
                return this.suscripcion;
            case USUARIO_FECHA_SUSCRIPCION:
                return this.fechaSuscripcion;

        }
        return null;
    }

    /**
     * Metodos de la clase interfaz itfProperty
     *
     * @param obj_Propiedad objeto de interfaz
     * @return valores a los atributos
     */
    @Override
    public Object getPropertyA(String obj_Propiedad) {
        return null;
    }

    @Override
    public boolean getPropertyEstadoS() {
        return this.suscripcion;
    }

}
