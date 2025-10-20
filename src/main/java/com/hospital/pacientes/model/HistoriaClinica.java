package com.hospital.pacientes.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "HistoriaClinica")
public class HistoriaClinica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHistoria;

    @Column(nullable = false)
    private Integer idPaciente;

    @Column(nullable = false)
    private LocalDate fechaApertura;

    @Column(columnDefinition = "TEXT")
    private String observaciones;

    public HistoriaClinica() {
    }

    public HistoriaClinica(Integer idHistoria, Integer idPaciente, LocalDate fechaApertura, String observaciones) {
        this.idHistoria = idHistoria;
        this.idPaciente = idPaciente;
        this.fechaApertura = fechaApertura;
        this.observaciones = observaciones;
    }

    public Integer getIdHistoria() {
        return idHistoria;
    }

    public void setIdHistoria(Integer idHistoria) {
        this.idHistoria = idHistoria;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public LocalDate getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(LocalDate fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}