package com.hospital.pacientes.service;

import com.hospital.pacientes.model.Paciente;

import java.util.List;

public interface PacienteService {
    Paciente registrarPaciente(Paciente paciente);
    Paciente buscarPorDni(String dni);
    Paciente buscarPorId(Integer id);
    List<Paciente> listarTodos();
    Paciente actualizarPaciente(Paciente paciente);
    void eliminarPaciente(Integer id);
}