package com.hospital.pacientes.dao;

import com.hospital.pacientes.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteDAO extends JpaRepository<Paciente, Integer> {
    Optional<Paciente> findByDni(String dni);
}