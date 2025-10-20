package com.hospital.consultas.service;

import com.hospital.consultas.dao.ConsultaDAO;
import com.hospital.consultas.model.Consulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsultaServiceImpl implements ConsultaService {

    @Autowired
    private ConsultaDAO consultaDAO;

    @Override
    public Consulta registrarConsulta(Consulta consulta) {
        return consultaDAO.save(consulta);
    }

    @Override
    public Consulta buscarPorId(Integer id) {
        return consultaDAO.findById(id).orElse(null);
    }

    @Override
    public List<Consulta> listarTodas() {
        return consultaDAO.findAll();
    }

    @Override
    public List<Consulta> listarPorPaciente(Integer idPaciente) {
        return consultaDAO.findByIdPaciente(idPaciente);
    }

    @Override
    public List<Consulta> listarPorMedico(Integer idMedico) {
        return consultaDAO.findByIdMedico(idMedico);
    }

    @Override
    public List<Consulta> listarPorCita(Integer idCita) {
        return consultaDAO.findByIdCita(idCita);
    }

    @Override
    public Consulta actualizarConsulta(Consulta consulta) {
        return consultaDAO.save(consulta);
    }

    @Override
    public void eliminarConsulta(Integer id) {
        consultaDAO.deleteById(id);
    }
}