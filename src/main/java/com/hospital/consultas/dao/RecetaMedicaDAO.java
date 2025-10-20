package com.hospital.consultas.dao;

import com.hospital.consultas.model.RecetaMedica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecetaMedicaDAO extends JpaRepository<RecetaMedica, Integer> {
    List<RecetaMedica> findByIdConsulta(Integer idConsulta);
    Optional<RecetaMedica> findFirstByIdConsultaOrderByIdRecetaDesc(Integer idConsulta);
}