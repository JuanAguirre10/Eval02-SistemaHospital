package com.hospital.facturacion.service;

import com.hospital.facturacion.dao.FacturaDAO;
import com.hospital.facturacion.model.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacturaServiceImpl implements FacturaService {

    @Autowired
    private FacturaDAO facturaDAO;

    @Override
    public Factura generarFactura(Factura factura) {
        return facturaDAO.save(factura);
    }

    @Override
    public Factura buscarPorId(Integer id) {
        return facturaDAO.findById(id).orElse(null);
    }

    @Override
    public List<Factura> listarTodas() {
        return facturaDAO.findAll();
    }

    @Override
    public List<Factura> listarPorPaciente(Integer idPaciente) {
        return facturaDAO.findByIdPaciente(idPaciente);
    }

    @Override
    public List<Factura> listarPorEstado(String estado) {
        return facturaDAO.findByEstado(estado);
    }

    @Override
    public List<Factura> listarPendientesPorPaciente(Integer idPaciente) {
        return facturaDAO.findByIdPacienteAndEstado(idPaciente, "pendiente");
    }

    @Override
    public Factura actualizarFactura(Factura factura) {
        return facturaDAO.save(factura);
    }

    @Override
    public Factura marcarComoPagada(Integer id) {
        Factura factura = facturaDAO.findById(id).orElse(null);
        if (factura != null) {
            factura.setEstado("pagado");
            return facturaDAO.save(factura);
        }
        return null;
    }

    @Override
    public void eliminarFactura(Integer id) {
        facturaDAO.deleteById(id);
    }
}