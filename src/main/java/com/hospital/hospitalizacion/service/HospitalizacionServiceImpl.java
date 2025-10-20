package com.hospital.hospitalizacion.service;

import com.hospital.hospitalizacion.dao.HabitacionDAO;
import com.hospital.hospitalizacion.dao.HospitalizacionDAO;
import com.hospital.hospitalizacion.model.Habitacion;
import com.hospital.hospitalizacion.model.Hospitalizacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class HospitalizacionServiceImpl implements HospitalizacionService {

    @Autowired
    private HospitalizacionDAO hospitalizacionDAO;

    @Autowired
    private HabitacionDAO habitacionDAO;

    @Override
    public Hospitalizacion registrarHospitalizacion(Hospitalizacion hospitalizacion) {
        Hospitalizacion nuevaHosp = hospitalizacionDAO.save(hospitalizacion);

        Habitacion habitacion = habitacionDAO.findById(hospitalizacion.getIdHabitacion()).orElse(null);
        if (habitacion != null) {
            habitacion.setEstado("ocupada");
            habitacionDAO.save(habitacion);
        }

        return nuevaHosp;
    }

    @Override
    public Hospitalizacion buscarPorId(Integer id) {
        return hospitalizacionDAO.findById(id).orElse(null);
    }

    @Override
    public List<Hospitalizacion> listarTodas() {
        return hospitalizacionDAO.findAll();
    }

    @Override
    public List<Hospitalizacion> listarPorPaciente(Integer idPaciente) {
        return hospitalizacionDAO.findByIdPaciente(idPaciente);
    }

    @Override
    public List<Hospitalizacion> listarPorHabitacion(Integer idHabitacion) {
        return hospitalizacionDAO.findByIdHabitacion(idHabitacion);
    }

    @Override
    public List<Hospitalizacion> listarPorEstado(String estado) {
        return hospitalizacionDAO.findByEstado(estado);
    }

    @Override
    public List<Hospitalizacion> listarActivasPorPaciente(Integer idPaciente) {
        return hospitalizacionDAO.findByIdPacienteAndEstado(idPaciente, "activo");
    }

    @Override
    public Hospitalizacion actualizarHospitalizacion(Hospitalizacion hospitalizacion) {
        return hospitalizacionDAO.save(hospitalizacion);
    }

    @Override
    public Hospitalizacion darAlta(Integer id, LocalDate fechaAlta) {
        Hospitalizacion hosp = hospitalizacionDAO.findById(id).orElse(null);
        if (hosp != null) {
            hosp.setFechaAlta(fechaAlta);
            hosp.setEstado("dado de alta");

            Habitacion habitacion = habitacionDAO.findById(hosp.getIdHabitacion()).orElse(null);
            if (habitacion != null) {
                habitacion.setEstado("disponible");
                habitacionDAO.save(habitacion);
            }

            return hospitalizacionDAO.save(hosp);
        }
        return null;
    }

    @Override
    public void eliminarHospitalizacion(Integer id) {
        hospitalizacionDAO.deleteById(id);
    }
}