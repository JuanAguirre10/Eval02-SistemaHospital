package com.hospital.pacientes.service;

import com.hospital.pacientes.dao.HistoriaClinicaDAO;
import com.hospital.pacientes.model.HistoriaClinica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HistoriaClinicaServiceImpl implements HistoriaClinicaService {

    @Autowired
    private HistoriaClinicaDAO historiaClinicaDAO;

    @Override
    public HistoriaClinica buscarPorPaciente(Integer idPaciente) {
        return historiaClinicaDAO.findByIdPaciente(idPaciente).orElse(null);
    }

    @Override
    public HistoriaClinica actualizarHistoria(HistoriaClinica historia) {
        return historiaClinicaDAO.save(historia);
    }
}