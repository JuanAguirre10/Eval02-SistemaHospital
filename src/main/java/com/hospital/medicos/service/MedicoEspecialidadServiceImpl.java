package com.hospital.medicos.service;

import com.hospital.medicos.dao.MedicoEspecialidadDAO;
import com.hospital.medicos.model.MedicoEspecialidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoEspecialidadServiceImpl implements MedicoEspecialidadService {

    @Autowired
    private MedicoEspecialidadDAO medicoEspecialidadDAO;

    @Override
    public MedicoEspecialidad asociarMedicoEspecialidad(MedicoEspecialidad medicoEspecialidad) {
        return medicoEspecialidadDAO.save(medicoEspecialidad);
    }

    @Override
    public List<MedicoEspecialidad> listarPorMedico(Integer idMedico) {
        return medicoEspecialidadDAO.findByIdMedico(idMedico);
    }

    @Override
    public List<MedicoEspecialidad> listarPorEspecialidad(Integer idEspecialidad) {
        return medicoEspecialidadDAO.findByIdEspecialidad(idEspecialidad);
    }

    @Override
    public void eliminarAsociacion(Integer id) {
        medicoEspecialidadDAO.deleteById(id);
    }
}