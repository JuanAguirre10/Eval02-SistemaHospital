package com.hospital.consultas.service;

import com.hospital.consultas.dao.DiagnosticoDAO;
import com.hospital.consultas.model.Diagnostico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosticoServiceImpl implements DiagnosticoService {

    @Autowired
    private DiagnosticoDAO diagnosticoDAO;

    @Override
    public Diagnostico registrarDiagnostico(Diagnostico diagnostico) {
        return diagnosticoDAO.save(diagnostico);
    }

    @Override
    public Diagnostico buscarPorId(Integer id) {
        return diagnosticoDAO.findById(id).orElse(null);
    }

    @Override
    public List<Diagnostico> listarPorConsulta(Integer idConsulta) {
        return diagnosticoDAO.findByIdConsulta(idConsulta);
    }

    @Override
    public Diagnostico actualizarDiagnostico(Diagnostico diagnostico) {
        return diagnosticoDAO.save(diagnostico);
    }

    @Override
    public void eliminarDiagnostico(Integer id) {
        diagnosticoDAO.deleteById(id);
    }
}