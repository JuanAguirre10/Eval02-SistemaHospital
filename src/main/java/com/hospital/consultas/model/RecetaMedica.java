package com.hospital.consultas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "RecetaMedica")
public class RecetaMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReceta;

    @Column(nullable = false)
    private Integer idConsulta;

    @Column(columnDefinition = "TEXT")
    private String indicaciones;

    public RecetaMedica() {
    }

    public RecetaMedica(Integer idReceta, Integer idConsulta, String indicaciones) {
        this.idReceta = idReceta;
        this.idConsulta = idConsulta;
        this.indicaciones = indicaciones;
    }

    public Integer getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(Integer idReceta) {
        this.idReceta = idReceta;
    }

    public Integer getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(Integer idConsulta) {
        this.idConsulta = idConsulta;
    }

    public String getIndicaciones() {
        return indicaciones;
    }

    public void setIndicaciones(String indicaciones) {
        this.indicaciones = indicaciones;
    }
}