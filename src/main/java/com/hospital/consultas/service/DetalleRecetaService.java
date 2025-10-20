package com.hospital.consultas.service;

import com.hospital.consultas.model.DetalleReceta;

import java.util.List;

public interface DetalleRecetaService {
    DetalleReceta registrarDetalle(DetalleReceta detalle);
    DetalleReceta buscarPorId(Integer id);
    List<DetalleReceta> listarPorReceta(Integer idReceta);
    DetalleReceta actualizarDetalle(DetalleReceta detalle);
    void eliminarDetalle(Integer id);
}