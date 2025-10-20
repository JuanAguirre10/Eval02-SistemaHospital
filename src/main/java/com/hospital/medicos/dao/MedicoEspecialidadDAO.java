package com.hospital.medicos.dao;

import com.hospital.medicos.model.MedicoEspecialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoEspecialidadDAO extends JpaRepository<MedicoEspecialidad, Integer> {
    List<MedicoEspecialidad> findByIdMedico(Integer idMedico);
    List<MedicoEspecialidad> findByIdEspecialidad(Integer idEspecialidad);
}