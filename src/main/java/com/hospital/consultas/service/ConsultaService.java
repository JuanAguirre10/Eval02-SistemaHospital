package com.hospital.consultas.service;

import com.hospital.consultas.model.Consulta;

import java.util.List;

public interface ConsultaService {
    Consulta registrarConsulta(Consulta consulta);
    Consulta buscarPorId(Integer id);
    List<Consulta> listarTodas();
    List<Consulta> listarPorPaciente(Integer idPaciente);
    List<Consulta> listarPorMedico(Integer idMedico);
    List<Consulta> listarPorCita(Integer idCita);
    Consulta actualizarConsulta(Consulta consulta);
    void eliminarConsulta(Integer id);
}