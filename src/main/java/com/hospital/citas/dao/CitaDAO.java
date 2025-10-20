package com.hospital.citas.dao;

import com.hospital.citas.model.Cita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CitaDAO extends JpaRepository<Cita, Integer> {
    List<Cita> findByIdPaciente(Integer idPaciente);
    List<Cita> findByIdMedico(Integer idMedico);
    List<Cita> findByEstado(String estado);
    List<Cita> findByFecha(LocalDate fecha);
    List<Cita> findByIdPacienteAndEstado(Integer idPaciente, String estado);
}