package com.hospital.consultas.dao;

import com.hospital.consultas.model.DetalleReceta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetalleRecetaDAO extends JpaRepository<DetalleReceta, Integer> {
    List<DetalleReceta> findByIdReceta(Integer idReceta);
}