package com.hospital.hospitalizacion.dao;

import com.hospital.hospitalizacion.model.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HabitacionDAO extends JpaRepository<Habitacion, Integer> {
    List<Habitacion> findByEstado(String estado);
    List<Habitacion> findByTipo(String tipo);
    List<Habitacion> findByTipoAndEstado(String tipo, String estado);
}