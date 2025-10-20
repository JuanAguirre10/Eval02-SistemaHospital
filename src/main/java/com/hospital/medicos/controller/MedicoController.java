package com.hospital.medicos.controller;

import com.hospital.medicos.model.Medico;
import com.hospital.medicos.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicos")
@CrossOrigin(origins = "*")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @PostMapping
    public ResponseEntity<Medico> registrarMedico(@RequestBody Medico medico) {
        Medico nuevoMedico = medicoService.registrarMedico(medico);
        return new ResponseEntity<>(nuevoMedico, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Medico> buscarPorId(@PathVariable Integer id) {
        Medico medico = medicoService.buscarPorId(id);
        if (medico != null) {
            return new ResponseEntity<>(medico, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Medico>> listarTodos() {
        List<Medico> medicos = medicoService.listarTodos();
        return new ResponseEntity<>(medicos, HttpStatus.OK);
    }

    @GetMapping("/activos")
    public ResponseEntity<List<Medico>> listarActivos() {
        List<Medico> medicos = medicoService.listarActivos();
        return new ResponseEntity<>(medicos, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Medico> actualizarMedico(@PathVariable Integer id, @RequestBody Medico medico) {
        medico.setIdMedico(id);
        Medico medicoActualizado = medicoService.actualizarMedico(medico);
        return new ResponseEntity<>(medicoActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMedico(@PathVariable Integer id) {
        medicoService.eliminarMedico(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}