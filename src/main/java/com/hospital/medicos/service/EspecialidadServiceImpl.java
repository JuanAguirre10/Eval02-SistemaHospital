package com.hospital.medicos.service;

import com.hospital.medicos.dao.EspecialidadDAO;
import com.hospital.medicos.model.Especialidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialidadServiceImpl implements EspecialidadService {

    @Autowired
    private EspecialidadDAO especialidadDAO;

    @Override
    public Especialidad registrarEspecialidad(Especialidad especialidad) {
        return especialidadDAO.save(especialidad);
    }

    @Override
    public Especialidad buscarPorId(Integer id) {
        return especialidadDAO.findById(id).orElse(null);
    }

    @Override
    public List<Especialidad> listarTodas() {
        return especialidadDAO.findAll();
    }

    @Override
    public Especialidad actualizarEspecialidad(Especialidad especialidad) {
        return especialidadDAO.save(especialidad);
    }

    @Override
    public void eliminarEspecialidad(Integer id) {
        especialidadDAO.deleteById(id);
    }
}