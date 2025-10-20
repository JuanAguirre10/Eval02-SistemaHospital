package com.hospital.hospitalizacion.service;

import com.hospital.hospitalizacion.model.Habitacion;

import java.util.List;

public interface HabitacionService {
    Habitacion registrarHabitacion(Habitacion habitacion);
    Habitacion buscarPorId(Integer id);
    List<Habitacion> listarTodas();
    List<Habitacion> listarPorEstado(String estado);
    List<Habitacion> listarPorTipo(String tipo);
    List<Habitacion> listarDisponiblesPorTipo(String tipo);
    Habitacion actualizarHabitacion(Habitacion habitacion);
    Habitacion cambiarEstado(Integer id, String estado);
    void eliminarHabitacion(Integer id);
}