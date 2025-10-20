package com.hospital.hospitalizacion.service;

import com.hospital.hospitalizacion.dao.HabitacionDAO;
import com.hospital.hospitalizacion.model.Habitacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitacionServiceImpl implements HabitacionService {

    @Autowired
    private HabitacionDAO habitacionDAO;

    @Override
    public Habitacion registrarHabitacion(Habitacion habitacion) {
        return habitacionDAO.save(habitacion);
    }

    @Override
    public Habitacion buscarPorId(Integer id) {
        return habitacionDAO.findById(id).orElse(null);
    }

    @Override
    public List<Habitacion> listarTodas() {
        return habitacionDAO.findAll();
    }

    @Override
    public List<Habitacion> listarPorEstado(String estado) {
        return habitacionDAO.findByEstado(estado);
    }

    @Override
    public List<Habitacion> listarPorTipo(String tipo) {
        return habitacionDAO.findByTipo(tipo);
    }

    @Override
    public List<Habitacion> listarDisponiblesPorTipo(String tipo) {
        return habitacionDAO.findByTipoAndEstado(tipo, "disponible");
    }

    @Override
    public Habitacion actualizarHabitacion(Habitacion habitacion) {
        return habitacionDAO.save(habitacion);
    }

    @Override
    public Habitacion cambiarEstado(Integer id, String estado) {
        Habitacion habitacion = habitacionDAO.findById(id).orElse(null);
        if (habitacion != null) {
            habitacion.setEstado(estado);
            return habitacionDAO.save(habitacion);
        }
        return null;
    }

    @Override
    public void eliminarHabitacion(Integer id) {
        habitacionDAO.deleteById(id);
    }
}