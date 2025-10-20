package com.hospital.facturacion.service;

import com.hospital.facturacion.model.DetalleFactura;

import java.util.List;

public interface DetalleFacturaService {
    DetalleFactura agregarDetalle(DetalleFactura detalle);
    DetalleFactura buscarPorId(Integer id);
    List<DetalleFactura> listarPorFactura(Integer idFactura);
    DetalleFactura actualizarDetalle(DetalleFactura detalle);
    void eliminarDetalle(Integer id);
}