package com.hospital.facturacion.service;

import com.hospital.facturacion.model.Factura;

import java.util.List;

public interface FacturaService {
    Factura generarFactura(Factura factura);
    Factura buscarPorId(Integer id);
    List<Factura> listarTodas();
    List<Factura> listarPorPaciente(Integer idPaciente);
    List<Factura> listarPorEstado(String estado);
    List<Factura> listarPendientesPorPaciente(Integer idPaciente);
    Factura actualizarFactura(Factura factura);
    Factura marcarComoPagada(Integer id);
    void eliminarFactura(Integer id);
}