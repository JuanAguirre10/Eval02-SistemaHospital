package com.hospital.pacientes.dao;

import com.hospital.pacientes.model.AntecedenteMedico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AntecedenteMedicoDAO extends JpaRepository<AntecedenteMedico, Integer> {
    List<AntecedenteMedico> findByIdHistoria(Integer idHistoria);
}