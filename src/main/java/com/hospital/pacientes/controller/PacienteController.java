package com.hospital.pacientes.controller;

import com.hospital.pacientes.model.Paciente;
import com.hospital.pacientes.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pacientes")
@CrossOrigin(origins = "*")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Paciente> registrarPaciente(@RequestBody Paciente paciente) {
        Paciente nuevoPaciente = pacienteService.registrarPaciente(paciente);
        return new ResponseEntity<>(nuevoPaciente, HttpStatus.CREATED);
    }

    @GetMapping("/dni/{dni}")
    public ResponseEntity<Paciente> buscarPorDni(@PathVariable String dni) {
        Paciente paciente = pacienteService.buscarPorDni(dni);
        if (paciente != null) {
            return new ResponseEntity<>(paciente, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscarPorId(@PathVariable Integer id) {
        Paciente paciente = pacienteService.buscarPorId(id);
        if (paciente != null) {
            return new ResponseEntity<>(paciente, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> listarTodos() {
        List<Paciente> pacientes = pacienteService.listarTodos();
        return new ResponseEntity<>(pacientes, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Paciente> actualizarPaciente(@PathVariable Integer id, @RequestBody Paciente paciente) {
        paciente.setIdPaciente(id);
        Paciente pacienteActualizado = pacienteService.actualizarPaciente(paciente);
        return new ResponseEntity<>(pacienteActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPaciente(@PathVariable Integer id) {
        pacienteService.eliminarPaciente(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}