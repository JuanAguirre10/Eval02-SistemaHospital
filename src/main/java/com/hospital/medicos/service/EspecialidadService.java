package com.hospital.medicos.service;

import com.hospital.medicos.model.Especialidad;

import java.util.List;

public interface EspecialidadService {
    Especialidad registrarEspecialidad(Especialidad especialidad);
    Especialidad buscarPorId(Integer id);
    List<Especialidad> listarTodas();
    Especialidad actualizarEspecialidad(Especialidad especialidad);
    void eliminarEspecialidad(Integer id);
}