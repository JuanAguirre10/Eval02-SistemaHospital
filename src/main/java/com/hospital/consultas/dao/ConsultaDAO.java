package com.hospital.consultas.dao;

import com.hospital.consultas.model.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultaDAO extends JpaRepository<Consulta, Integer> {
    List<Consulta> findByIdPaciente(Integer idPaciente);
    List<Consulta> findByIdMedico(Integer idMedico);
    List<Consulta> findByIdCita(Integer idCita);
}