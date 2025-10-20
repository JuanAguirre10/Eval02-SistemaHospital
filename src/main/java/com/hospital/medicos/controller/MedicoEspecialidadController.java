package com.hospital.medicos.controller;

import com.hospital.medicos.model.MedicoEspecialidad;
import com.hospital.medicos.service.MedicoEspecialidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medico-especialidad")
@CrossOrigin(origins = "*")
public class MedicoEspecialidadController {

    @Autowired
    private MedicoEspecialidadService medicoEspecialidadService;

    @PostMapping
    public ResponseEntity<MedicoEspecialidad> asociarMedicoEspecialidad(@RequestBody MedicoEspecialidad medicoEspecialidad) {
        MedicoEspecialidad nuevaAsociacion = medicoEspecialidadService.asociarMedicoEspecialidad(medicoEspecialidad);
        return new ResponseEntity<>(nuevaAsociacion, HttpStatus.CREATED);
    }

    @GetMapping("/medico/{idMedico}")
    public ResponseEntity<List<MedicoEspecialidad>> listarPorMedico(@PathVariable Integer idMedico) {
        List<MedicoEspecialidad> asociaciones = medicoEspecialidadService.listarPorMedico(idMedico);
        return new ResponseEntity<>(asociaciones, HttpStatus.OK);
    }

    @GetMapping("/especialidad/{idEspecialidad}")
    public ResponseEntity<List<MedicoEspecialidad>> listarPorEspecialidad(@PathVariable Integer idEspecialidad) {
        List<MedicoEspecialidad> asociaciones = medicoEspecialidadService.listarPorEspecialidad(idEspecialidad);
        return new ResponseEntity<>(asociaciones, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAsociacion(@PathVariable Integer id) {
        medicoEspecialidadService.eliminarAsociacion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}