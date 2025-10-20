package com.hospital.facturacion.service;

import com.hospital.facturacion.dao.DetalleFacturaDAO;
import com.hospital.facturacion.dao.FacturaDAO;
import com.hospital.facturacion.model.DetalleFactura;
import com.hospital.facturacion.model.Factura;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class DetalleFacturaServiceImpl implements DetalleFacturaService {

    @Autowired
    private DetalleFacturaDAO detalleFacturaDAO;

    @Autowired
    private FacturaDAO facturaDAO;

    @Override
    public DetalleFactura agregarDetalle(DetalleFactura detalle) {
        DetalleFactura nuevoDetalle = detalleFacturaDAO.save(detalle);

        actualizarTotalFactura(detalle.getIdFactura());

        return nuevoDetalle;
    }

    @Override
    public DetalleFactura buscarPorId(Integer id) {
        return detalleFacturaDAO.findById(id).orElse(null);
    }

    @Override
    public List<DetalleFactura> listarPorFactura(Integer idFactura) {
        return detalleFacturaDAO.findByIdFactura(idFactura);
    }

    @Override
    public DetalleFactura actualizarDetalle(DetalleFactura detalle) {
        DetalleFactura detalleActualizado = detalleFacturaDAO.save(detalle);
        actualizarTotalFactura(detalle.getIdFactura());
        return detalleActualizado;
    }

    @Override
    public void eliminarDetalle(Integer id) {
        DetalleFactura detalle = detalleFacturaDAO.findById(id).orElse(null);
        if (detalle != null) {
            Integer idFactura = detalle.getIdFactura();
            detalleFacturaDAO.deleteById(id);
            actualizarTotalFactura(idFactura);
        }
    }

    private void actualizarTotalFactura(Integer idFactura) {
        List<DetalleFactura> detalles = detalleFacturaDAO.findByIdFactura(idFactura);
        BigDecimal total = detalles.stream()
                .map(DetalleFactura::getMonto)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        Factura factura = facturaDAO.findById(idFactura).orElse(null);
        if (factura != null) {
            factura.setTotal(total);
            facturaDAO.save(factura);
        }
    }
}