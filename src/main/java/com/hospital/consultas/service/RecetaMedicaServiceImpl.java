package com.hospital.consultas.service;

import com.hospital.consultas.dao.RecetaMedicaDAO;
import com.hospital.consultas.model.RecetaMedica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecetaMedicaServiceImpl implements RecetaMedicaService {

    @Autowired
    private RecetaMedicaDAO recetaMedicaDAO;

    @Override
    public RecetaMedica registrarReceta(RecetaMedica receta) {
        return recetaMedicaDAO.save(receta);
    }

    @Override
    public RecetaMedica buscarPorId(Integer id) {
        return recetaMedicaDAO.findById(id).orElse(null);
    }

    @Override
    public List<RecetaMedica> listarPorConsulta(Integer idConsulta) {
        return recetaMedicaDAO.findByIdConsulta(idConsulta);
    }

    @Override
    public RecetaMedica actualizarReceta(RecetaMedica receta) {
        return recetaMedicaDAO.save(receta);
    }

    @Override
    public void eliminarReceta(Integer id) {
        recetaMedicaDAO.deleteById(id);
    }
}