package com.hospital.consultas.controller;

import com.hospital.consultas.model.Consulta;
import com.hospital.consultas.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/consultas")
@CrossOrigin(origins = "*")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @PostMapping
    public ResponseEntity<Consulta> registrarConsulta(@RequestBody Consulta consulta) {
        Consulta nuevaConsulta = consultaService.registrarConsulta(consulta);
        return new ResponseEntity<>(nuevaConsulta, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Consulta> buscarPorId(@PathVariable Integer id) {
        Consulta consulta = consultaService.buscarPorId(id);
        if (consulta != null) {
            return new ResponseEntity<>(consulta, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Consulta>> listarTodas() {
        List<Consulta> consultas = consultaService.listarTodas();
        return new ResponseEntity<>(consultas, HttpStatus.OK);
    }

    @GetMapping("/paciente/{idPaciente}")
    public ResponseEntity<List<Consulta>> listarPorPaciente(@PathVariable Integer idPaciente) {
        List<Consulta> consultas = consultaService.listarPorPaciente(idPaciente);
        return new ResponseEntity<>(consultas, HttpStatus.OK);
    }

    @GetMapping("/medico/{idMedico}")
    public ResponseEntity<List<Consulta>> listarPorMedico(@PathVariable Integer idMedico) {
        List<Consulta> consultas = consultaService.listarPorMedico(idMedico);
        return new ResponseEntity<>(consultas, HttpStatus.OK);
    }

    @GetMapping("/cita/{idCita}")
    public ResponseEntity<List<Consulta>> listarPorCita(@PathVariable Integer idCita) {
        List<Consulta> consultas = consultaService.listarPorCita(idCita);
        return new ResponseEntity<>(consultas, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Consulta> actualizarConsulta(@PathVariable Integer id, @RequestBody Consulta consulta) {
        consulta.setIdConsulta(id);
        Consulta consultaActualizada = consultaService.actualizarConsulta(consulta);
        return new ResponseEntity<>(consultaActualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarConsulta(@PathVariable Integer id) {
        consultaService.eliminarConsulta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}