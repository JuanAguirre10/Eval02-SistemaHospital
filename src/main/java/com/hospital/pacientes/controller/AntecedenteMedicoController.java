package com.hospital.pacientes.controller;

import com.hospital.pacientes.model.AntecedenteMedico;
import com.hospital.pacientes.service.AntecedenteMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/antecedentes")
@CrossOrigin(origins = "*")
public class AntecedenteMedicoController {

    @Autowired
    private AntecedenteMedicoService antecedenteMedicoService;

    @PostMapping
    public ResponseEntity<AntecedenteMedico> registrarAntecedente(@RequestBody AntecedenteMedico antecedente) {
        AntecedenteMedico nuevoAntecedente = antecedenteMedicoService.registrarAntecedente(antecedente);
        return new ResponseEntity<>(nuevoAntecedente, HttpStatus.CREATED);
    }

    @GetMapping("/historia/{idHistoria}")
    public ResponseEntity<List<AntecedenteMedico>> listarPorHistoria(@PathVariable Integer idHistoria) {
        List<AntecedenteMedico> antecedentes = antecedenteMedicoService.listarPorHistoria(idHistoria);
        return new ResponseEntity<>(antecedentes, HttpStatus.OK);
    }
}