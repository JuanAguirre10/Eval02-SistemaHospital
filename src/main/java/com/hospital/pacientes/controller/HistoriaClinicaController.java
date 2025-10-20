package com.hospital.pacientes.controller;

import com.hospital.pacientes.model.HistoriaClinica;
import com.hospital.pacientes.service.HistoriaClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/historias")
@CrossOrigin(origins = "*")
public class HistoriaClinicaController {

    @Autowired
    private HistoriaClinicaService historiaClinicaService;

    @GetMapping("/paciente/{idPaciente}")
    public ResponseEntity<HistoriaClinica> buscarPorPaciente(@PathVariable Integer idPaciente) {
        HistoriaClinica historia = historiaClinicaService.buscarPorPaciente(idPaciente);
        if (historia != null) {
            return new ResponseEntity<>(historia, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HistoriaClinica> actualizarHistoria(@PathVariable Integer id, @RequestBody HistoriaClinica historia) {
        historia.setIdHistoria(id);
        HistoriaClinica historiaActualizada = historiaClinicaService.actualizarHistoria(historia);
        return new ResponseEntity<>(historiaActualizada, HttpStatus.OK);
    }
}