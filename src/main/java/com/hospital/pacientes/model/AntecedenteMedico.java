package com.hospital.pacientes.model;

import jakarta.persistence.*;

@Entity
@Table(name = "AntecedenteMedico")
public class AntecedenteMedico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAntecedente;

    @Column(nullable = false)
    private Integer idHistoria;

    @Column(length = 100)
    private String tipo;

    @Column(columnDefinition = "TEXT")
    private String descripcion;

    public AntecedenteMedico() {
    }

    public AntecedenteMedico(Integer idAntecedente, Integer idHistoria, String tipo, String descripcion) {
        this.idAntecedente = idAntecedente;
        this.idHistoria = idHistoria;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }

    public Integer getIdAntecedente() {
        return idAntecedente;
    }

    public void setIdAntecedente(Integer idAntecedente) {
        this.idAntecedente = idAntecedente;
    }

    public Integer getIdHistoria() {
        return idHistoria;
    }

    public void setIdHistoria(Integer idHistoria) {
        this.idHistoria = idHistoria;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}