package com.hospital.consultas.service;

import com.hospital.consultas.model.Diagnostico;

import java.util.List;

public interface DiagnosticoService {
    Diagnostico registrarDiagnostico(Diagnostico diagnostico);
    Diagnostico buscarPorId(Integer id);
    List<Diagnostico> listarPorConsulta(Integer idConsulta);
    Diagnostico actualizarDiagnostico(Diagnostico diagnostico);
    void eliminarDiagnostico(Integer id);
}