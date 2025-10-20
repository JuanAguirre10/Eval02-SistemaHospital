package com.hospital.consultas.service;

import com.hospital.consultas.model.RecetaMedica;

import java.util.List;

public interface RecetaMedicaService {
    RecetaMedica registrarReceta(RecetaMedica receta);
    RecetaMedica buscarPorId(Integer id);
    List<RecetaMedica> listarPorConsulta(Integer idConsulta);
    RecetaMedica actualizarReceta(RecetaMedica receta);
    void eliminarReceta(Integer id);
}