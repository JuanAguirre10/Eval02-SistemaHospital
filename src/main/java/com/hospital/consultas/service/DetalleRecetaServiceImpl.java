package com.hospital.consultas.service;

import com.hospital.consultas.dao.DetalleRecetaDAO;
import com.hospital.consultas.model.DetalleReceta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleRecetaServiceImpl implements DetalleRecetaService {

    @Autowired
    private DetalleRecetaDAO detalleRecetaDAO;

    @Override
    public DetalleReceta registrarDetalle(DetalleReceta detalle) {
        return detalleRecetaDAO.save(detalle);
    }

    @Override
    public DetalleReceta buscarPorId(Integer id) {
        return detalleRecetaDAO.findById(id).orElse(null);
    }

    @Override
    public List<DetalleReceta> listarPorReceta(Integer idReceta) {
        return detalleRecetaDAO.findByIdReceta(idReceta);
    }

    @Override
    public DetalleReceta actualizarDetalle(DetalleReceta detalle) {
        return detalleRecetaDAO.save(detalle);
    }

    @Override
    public void eliminarDetalle(Integer id) {
        detalleRecetaDAO.deleteById(id);
    }
}