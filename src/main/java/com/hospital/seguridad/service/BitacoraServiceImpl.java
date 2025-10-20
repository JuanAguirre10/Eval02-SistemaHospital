package com.hospital.seguridad.service;

import com.hospital.seguridad.dao.BitacoraDAO;
import com.hospital.seguridad.model.Bitacora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BitacoraServiceImpl implements BitacoraService {

    @Autowired
    private BitacoraDAO bitacoraDAO;

    @Override
    public void registrarAccion(Integer idUsuario, String accion) {
        Bitacora bitacora = new Bitacora();
        bitacora.setIdUsuario(idUsuario);
        bitacora.setAccion(accion);
        bitacora.setFechaHora(LocalDateTime.now());
        bitacoraDAO.save(bitacora);
    }

    @Override
    public List<Bitacora> listarPorUsuario(Integer idUsuario) {
        return bitacoraDAO.findByIdUsuario(idUsuario);
    }

    @Override
    public List<Bitacora> listarTodas() {
        return bitacoraDAO.findAll();
    }
}