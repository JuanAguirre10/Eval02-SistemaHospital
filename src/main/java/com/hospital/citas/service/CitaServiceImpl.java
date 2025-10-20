package com.hospital.citas.service;

import com.hospital.citas.dao.CitaDAO;
import com.hospital.citas.model.Cita;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CitaServiceImpl implements CitaService {

    @Autowired
    private CitaDAO citaDAO;

    @Override
    public Cita agendarCita(Cita cita) {
        return citaDAO.save(cita);
    }

    @Override
    public Cita buscarPorId(Integer id) {
        return citaDAO.findById(id).orElse(null);
    }

    @Override
    public List<Cita> listarTodas() {
        return citaDAO.findAll();
    }

    @Override
    public List<Cita> listarPorPaciente(Integer idPaciente) {
        return citaDAO.findByIdPaciente(idPaciente);
    }

    @Override
    public List<Cita> listarPorMedico(Integer idMedico) {
        return citaDAO.findByIdMedico(idMedico);
    }

    @Override
    public List<Cita> listarPorEstado(String estado) {
        return citaDAO.findByEstado(estado);
    }

    @Override
    public List<Cita> listarPorFecha(LocalDate fecha) {
        return citaDAO.findByFecha(fecha);
    }

    @Override
    public Cita actualizarCita(Cita cita) {
        return citaDAO.save(cita);
    }

    @Override
    public Cita cambiarEstado(Integer id, String estado) {
        Cita cita = citaDAO.findById(id).orElse(null);
        if (cita != null) {
            cita.setEstado(estado);
            return citaDAO.save(cita);
        }
        return null;
    }

    @Override
    public void cancelarCita(Integer id) {
        Cita cita = citaDAO.findById(id).orElse(null);
        if (cita != null) {
            cita.setEstado("cancelada");
            citaDAO.save(cita);
        }
    }
}