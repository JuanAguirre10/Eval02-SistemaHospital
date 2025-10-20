package com.hospital.consultas.controller;

import com.hospital.consultas.model.Diagnostico;
import com.hospital.consultas.service.DiagnosticoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/diagnosticos")
@CrossOrigin(origins = "*")
public class DiagnosticoController {

    @Autowired
    private DiagnosticoService diagnosticoService;

    @PostMapping
    public ResponseEntity<Diagnostico> registrarDiagnostico(@RequestBody Diagnostico diagnostico) {
        Diagnostico nuevoDiagnostico = diagnosticoService.registrarDiagnostico(diagnostico);
        return new ResponseEntity<>(nuevoDiagnostico, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Diagnostico> buscarPorId(@PathVariable Integer id) {
        Diagnostico diagnostico = diagnosticoService.buscarPorId(id);
        if (diagnostico != null) {
            return new ResponseEntity<>(diagnostico, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/consulta/{idConsulta}")
    public ResponseEntity<List<Diagnostico>> listarPorConsulta(@PathVariable Integer idConsulta) {
        List<Diagnostico> diagnosticos = diagnosticoService.listarPorConsulta(idConsulta);
        return new ResponseEntity<>(diagnosticos, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Diagnostico> actualizarDiagnostico(@PathVariable Integer id, @RequestBody Diagnostico diagnostico) {
        diagnostico.setIdDiagnostico(id);
        Diagnostico diagnosticoActualizado = diagnosticoService.actualizarDiagnostico(diagnostico);
        return new ResponseEntity<>(diagnosticoActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDiagnostico(@PathVariable Integer id) {
        diagnosticoService.eliminarDiagnostico(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}