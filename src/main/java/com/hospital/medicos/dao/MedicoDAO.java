package com.hospital.medicos.dao;

import com.hospital.medicos.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoDAO extends JpaRepository<Medico, Integer> {
    List<Medico> findByEstado(String estado);
}