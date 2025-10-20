package com.hospital.medicos.service;

import com.hospital.medicos.dao.MedicoDAO;
import com.hospital.medicos.model.Medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoServiceImpl implements MedicoService {

    @Autowired
    private MedicoDAO medicoDAO;

    @Override
    public Medico registrarMedico(Medico medico) {
        return medicoDAO.save(medico);
    }

    @Override
    public Medico buscarPorId(Integer id) {
        return medicoDAO.findById(id).orElse(null);
    }

    @Override
    public List<Medico> listarTodos() {
        return medicoDAO.findAll();
    }

    @Override
    public List<Medico> listarActivos() {
        return medicoDAO.findByEstado("activo");
    }

    @Override
    public Medico actualizarMedico(Medico medico) {
        return medicoDAO.save(medico);
    }

    @Override
    public void eliminarMedico(Integer id) {
        medicoDAO.deleteById(id);
    }
}