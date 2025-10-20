package com.hospital.consultas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Diagnostico")
public class Diagnostico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDiagnostico;

    @Column(nullable = false)
    private Integer idConsulta;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Column(length = 50)
    private String tipo;

    public Diagnostico() {
    }

    public Diagnostico(Integer idDiagnostico, Integer idConsulta, String descripcion, String tipo) {
        this.idDiagnostico = idDiagnostico;
        this.idConsulta = idConsulta;
        this.descripcion = descripcion;
        this.tipo = tipo;
    }

    public Integer getIdDiagnostico() {
        return idDiagnostico;
    }

    public void setIdDiagnostico(Integer idDiagnostico) {
        this.idDiagnostico = idDiagnostico;
    }

    public Integer getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}