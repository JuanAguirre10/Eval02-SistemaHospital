package com.hospital.citas.controller;

import com.hospital.citas.model.Cita;
import com.hospital.citas.service.CitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/citas")
@CrossOrigin(origins = "*")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @PostMapping
    public ResponseEntity<Cita> agendarCita(@RequestBody Cita cita) {
        Cita nuevaCita = citaService.agendarCita(cita);
        return new ResponseEntity<>(nuevaCita, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cita> buscarPorId(@PathVariable Integer id) {
        Cita cita = citaService.buscarPorId(id);
        if (cita != null) {
            return new ResponseEntity<>(cita, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Cita>> listarTodas() {
        List<Cita> citas = citaService.listarTodas();
        return new ResponseEntity<>(citas, HttpStatus.OK);
    }

    @GetMapping("/paciente/{idPaciente}")
    public ResponseEntity<List<Cita>> listarPorPaciente(@PathVariable Integer idPaciente) {
        List<Cita> citas = citaService.listarPorPaciente(idPaciente);
        return new ResponseEntity<>(citas, HttpStatus.OK);
    }

    @GetMapping("/medico/{idMedico}")
    public ResponseEntity<List<Cita>> listarPorMedico(@PathVariable Integer idMedico) {
        List<Cita> citas = citaService.listarPorMedico(idMedico);
        return new ResponseEntity<>(citas, HttpStatus.OK);
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Cita>> listarPorEstado(@PathVariable String estado) {
        List<Cita> citas = citaService.listarPorEstado(estado);
        return new ResponseEntity<>(citas, HttpStatus.OK);
    }

    @GetMapping("/fecha/{fecha}")
    public ResponseEntity<List<Cita>> listarPorFecha(@PathVariable String fecha) {
        LocalDate fechaCita = LocalDate.parse(fecha);
        List<Cita> citas = citaService.listarPorFecha(fechaCita);
        return new ResponseEntity<>(citas, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cita> actualizarCita(@PathVariable Integer id, @RequestBody Cita cita) {
        cita.setIdCita(id);
        Cita citaActualizada = citaService.actualizarCita(cita);
        return new ResponseEntity<>(citaActualizada, HttpStatus.OK);
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<Cita> cambiarEstado(@PathVariable Integer id, @RequestParam String estado) {
        Cita citaActualizada = citaService.cambiarEstado(id, estado);
        if (citaActualizada != null) {
            return new ResponseEntity<>(citaActualizada, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/{id}/cancelar")
    public ResponseEntity<Void> cancelarCita(@PathVariable Integer id) {
        citaService.cancelarCita(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}