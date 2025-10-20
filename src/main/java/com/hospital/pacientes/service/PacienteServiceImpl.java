package com.hospital.pacientes.service;

import com.hospital.pacientes.dao.PacienteDAO;
import com.hospital.pacientes.dao.HistoriaClinicaDAO;
import com.hospital.pacientes.model.Paciente;
import com.hospital.pacientes.model.HistoriaClinica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    private PacienteDAO pacienteDAO;

    @Autowired
    private HistoriaClinicaDAO historiaClinicaDAO;

    @Override
    public Paciente registrarPaciente(Paciente paciente) {
        Paciente pacienteGuardado = pacienteDAO.save(paciente);

        HistoriaClinica historia = new HistoriaClinica();
        historia.setIdPaciente(pacienteGuardado.getIdPaciente());
        historia.setFechaApertura(LocalDate.now());
        historia.setObservaciones("Historia clínica creada automáticamente");
        historiaClinicaDAO.save(historia);

        return pacienteGuardado;
    }

    @Override
    public Paciente buscarPorDni(String dni) {
        return pacienteDAO.findByDni(dni).orElse(null);
    }

    @Override
    public Paciente buscarPorId(Integer id) {
        return pacienteDAO.findById(id).orElse(null);
    }

    @Override
    public List<Paciente> listarTodos() {
        return pacienteDAO.findAll();
    }

    @Override
    public Paciente actualizarPaciente(Paciente paciente) {
        return pacienteDAO.save(paciente);
    }

    @Override
    public void eliminarPaciente(Integer id) {
        pacienteDAO.deleteById(id);
    }
}