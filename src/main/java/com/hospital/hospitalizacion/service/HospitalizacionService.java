package com.hospital.hospitalizacion.service;

import com.hospital.hospitalizacion.model.Hospitalizacion;

import java.time.LocalDate;
import java.util.List;

public interface HospitalizacionService {
    Hospitalizacion registrarHospitalizacion(Hospitalizacion hospitalizacion);
    Hospitalizacion buscarPorId(Integer id);
    List<Hospitalizacion> listarTodas();
    List<Hospitalizacion> listarPorPaciente(Integer idPaciente);
    List<Hospitalizacion> listarPorHabitacion(Integer idHabitacion);
    List<Hospitalizacion> listarPorEstado(String estado);
    List<Hospitalizacion> listarActivasPorPaciente(Integer idPaciente);
    Hospitalizacion actualizarHospitalizacion(Hospitalizacion hospitalizacion);
    Hospitalizacion darAlta(Integer id, LocalDate fechaAlta);
    void eliminarHospitalizacion(Integer id);
}