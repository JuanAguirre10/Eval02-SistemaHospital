package com.hospital.hospitalizacion.dao;

import com.hospital.hospitalizacion.model.Hospitalizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalizacionDAO extends JpaRepository<Hospitalizacion, Integer> {
    List<Hospitalizacion> findByIdPaciente(Integer idPaciente);
    List<Hospitalizacion> findByIdHabitacion(Integer idHabitacion);
    List<Hospitalizacion> findByEstado(String estado);
    List<Hospitalizacion> findByIdPacienteAndEstado(Integer idPaciente, String estado);
}