package com.hospital.medicos.service;

import com.hospital.medicos.model.MedicoEspecialidad;

import java.util.List;

public interface MedicoEspecialidadService {
    MedicoEspecialidad asociarMedicoEspecialidad(MedicoEspecialidad medicoEspecialidad);
    List<MedicoEspecialidad> listarPorMedico(Integer idMedico);
    List<MedicoEspecialidad> listarPorEspecialidad(Integer idEspecialidad);
    void eliminarAsociacion(Integer id);
}