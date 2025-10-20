package com.hospital.seguridad.service;

import com.hospital.seguridad.model.Bitacora;

import java.util.List;

public interface BitacoraService {
    void registrarAccion(Integer idUsuario, String accion);
    List<Bitacora> listarPorUsuario(Integer idUsuario);
    List<Bitacora> listarTodas();
}