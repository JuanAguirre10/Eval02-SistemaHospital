package com.hospital.medicos.dao;

import com.hospital.medicos.model.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadDAO extends JpaRepository<Especialidad, Integer> {
}