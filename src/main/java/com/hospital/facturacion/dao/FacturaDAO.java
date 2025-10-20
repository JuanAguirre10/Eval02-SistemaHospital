package com.hospital.facturacion.dao;

import com.hospital.facturacion.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaDAO extends JpaRepository<Factura, Integer> {
    List<Factura> findByIdPaciente(Integer idPaciente);
    List<Factura> findByEstado(String estado);
    List<Factura> findByIdPacienteAndEstado(Integer idPaciente, String estado);
}