package com.hospital.seguridad.model;

public class LoginResponse {

    private boolean success;
    private String mensaje;
    private Integer idUsuario;
    private String nombreUsuario;
    private String rol;

    public LoginResponse() {
    }

    public LoginResponse(boolean success, String mensaje, Integer idUsuario, String nombreUsuario, String rol) {
        this.success = success;
        this.mensaje = mensaje;
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.rol = rol;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}