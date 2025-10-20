package com.hospital.seguridad.dao;

import com.hospital.seguridad.model.Bitacora;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BitacoraDAO extends JpaRepository<Bitacora, Integer> {
    List<Bitacora> findByIdUsuario(Integer idUsuario);
}