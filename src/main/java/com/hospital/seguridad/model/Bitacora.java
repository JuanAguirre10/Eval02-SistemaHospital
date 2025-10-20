package com.hospital.seguridad.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Bitacora")
public class Bitacora {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBitacora;

    @Column(nullable = false)
    private Integer idUsuario;

    @Column(columnDefinition = "TEXT")
    private String accion;

    @Column(nullable = false)
    private LocalDateTime fechaHora;

    public Bitacora() {
    }

    public Bitacora(Integer idBitacora, Integer idUsuario, String accion, LocalDateTime fechaHora) {
        this.idBitacora = idBitacora;
        this.idUsuario = idUsuario;
        this.accion = accion;
        this.fechaHora = fechaHora;
    }

    public Integer getIdBitacora() {
        return idBitacora;
    }

    public void setIdBitacora(Integer idBitacora) {
        this.idBitacora = idBitacora;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }
}