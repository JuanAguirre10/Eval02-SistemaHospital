package com.hospital.hospitalizacion.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Hospitalizacion")
public class Hospitalizacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHosp;

    @Column(nullable = false)
    private Integer idPaciente;

    @Column(nullable = false)
    private Integer idHabitacion;

    @Column(nullable = false)
    private LocalDate fechaIngreso;

    private LocalDate fechaAlta;

    @Column(columnDefinition = "TEXT")
    private String diagnosticoIngreso;

    @Column(length = 20)
    private String estado = "activo";

    public Hospitalizacion() {
    }

    public Hospitalizacion(Integer idHosp, Integer idPaciente, Integer idHabitacion, LocalDate fechaIngreso, LocalDate fechaAlta, String diagnosticoIngreso, String estado) {
        this.idHosp = idHosp;
        this.idPaciente = idPaciente;
        this.idHabitacion = idHabitacion;
        this.fechaIngreso = fechaIngreso;
        this.fechaAlta = fechaAlta;
        this.diagnosticoIngreso = diagnosticoIngreso;
        this.estado = estado;
    }

    public Integer getIdHosp() {
        return idHosp;
    }

    public void setIdHosp(Integer idHosp) {
        this.idHosp = idHosp;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public Integer getIdHabitacion() {
        return idHabitacion;
    }

    public void setIdHabitacion(Integer idHabitacion) {
        this.idHabitacion = idHabitacion;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getDiagnosticoIngreso() {
        return diagnosticoIngreso;
    }

    public void setDiagnosticoIngreso(String diagnosticoIngreso) {
        this.diagnosticoIngreso = diagnosticoIngreso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}