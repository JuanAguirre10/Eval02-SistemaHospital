package com.hospital.facturacion.dao;

import com.hospital.facturacion.model.DetalleFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleFacturaDAO extends JpaRepository<DetalleFactura, Integer> {
    List<DetalleFactura> findByIdFactura(Integer idFactura);
}