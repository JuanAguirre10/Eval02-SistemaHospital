package com.hospital.medicos.service;

import com.hospital.medicos.model.Medico;

import java.util.List;

public interface MedicoService {
    Medico registrarMedico(Medico medico);
    Medico buscarPorId(Integer id);
    List<Medico> listarTodos();
    List<Medico> listarActivos();
    Medico actualizarMedico(Medico medico);
    void eliminarMedico(Integer id);
}