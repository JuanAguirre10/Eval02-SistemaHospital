package com.hospital.pacientes.service;

import com.hospital.pacientes.dao.AntecedenteMedicoDAO;
import com.hospital.pacientes.model.AntecedenteMedico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AntecedenteMedicoServiceImpl implements AntecedenteMedicoService {

    @Autowired
    private AntecedenteMedicoDAO antecedenteMedicoDAO;

    @Override
    public AntecedenteMedico registrarAntecedente(AntecedenteMedico antecedente) {
        return antecedenteMedicoDAO.save(antecedente);
    }

    @Override
    public List<AntecedenteMedico> listarPorHistoria(Integer idHistoria) {
        return antecedenteMedicoDAO.findByIdHistoria(idHistoria);
    }
}