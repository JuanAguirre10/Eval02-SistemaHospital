package com.hospital.citas.service;

import com.hospital.citas.model.Cita;

import java.time.LocalDate;
import java.util.List;

public interface CitaService {
    Cita agendarCita(Cita cita);
    Cita buscarPorId(Integer id);
    List<Cita> listarTodas();
    List<Cita> listarPorPaciente(Integer idPaciente);
    List<Cita> listarPorMedico(Integer idMedico);
    List<Cita> listarPorEstado(String estado);
    List<Cita> listarPorFecha(LocalDate fecha);
    Cita actualizarCita(Cita cita);
    Cita cambiarEstado(Integer id, String estado);
    void cancelarCita(Integer id);
}