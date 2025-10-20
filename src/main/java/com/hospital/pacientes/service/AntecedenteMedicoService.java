package com.hospital.pacientes.service;

import com.hospital.pacientes.model.AntecedenteMedico;

import java.util.List;

public interface AntecedenteMedicoService {
    AntecedenteMedico registrarAntecedente(AntecedenteMedico antecedente);
    List<AntecedenteMedico> listarPorHistoria(Integer idHistoria);
}