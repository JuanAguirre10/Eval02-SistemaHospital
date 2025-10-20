package com.hospital.pacientes.service;

import com.hospital.pacientes.model.HistoriaClinica;

public interface HistoriaClinicaService {
    HistoriaClinica buscarPorPaciente(Integer idPaciente);
    HistoriaClinica actualizarHistoria(HistoriaClinica historia);
}