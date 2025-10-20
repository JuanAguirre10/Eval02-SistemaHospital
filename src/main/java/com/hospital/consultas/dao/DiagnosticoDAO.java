package com.hospital.consultas.dao;

import com.hospital.consultas.model.Diagnostico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiagnosticoDAO extends JpaRepository<Diagnostico, Integer> {
    List<Diagnostico> findByIdConsulta(Integer idConsulta);
}