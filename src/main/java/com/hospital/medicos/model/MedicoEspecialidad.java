package com.hospital.medicos.model;

import jakarta.persistence.*;

@Entity
@Table(name = "MedicoEspecialidad")
public class MedicoEspecialidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMedicoEsp;

    @Column(nullable = false)
    private Integer idMedico;

    @Column(nullable = false)
    private Integer idEspecialidad;

    public MedicoEspecialidad() {
    }

    public MedicoEspecialidad(Integer idMedicoEsp, Integer idMedico, Integer idEspecialidad) {
        this.idMedicoEsp = idMedicoEsp;
        this.idMedico = idMedico;
        this.idEspecialidad = idEspecialidad;
    }

    public Integer getIdMedicoEsp() {
        return idMedicoEsp;
    }

    public void setIdMedicoEsp(Integer idMedicoEsp) {
        this.idMedicoEsp = idMedicoEsp;
    }

    public Integer getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(Integer idMedico) {
        this.idMedico = idMedico;
    }

    public Integer getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(Integer idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }
}