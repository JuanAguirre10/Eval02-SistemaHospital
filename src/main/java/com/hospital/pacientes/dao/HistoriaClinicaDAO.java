package com.hospital.pacientes.dao;

import com.hospital.pacientes.model.HistoriaClinica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HistoriaClinicaDAO extends JpaRepository<HistoriaClinica, Integer> {
    Optional<HistoriaClinica> findByIdPaciente(Integer idPaciente);
}