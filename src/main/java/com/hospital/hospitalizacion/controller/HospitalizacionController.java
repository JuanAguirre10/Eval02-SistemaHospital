package com.hospital.hospitalizacion.controller;

import com.hospital.hospitalizacion.model.Hospitalizacion;
import com.hospital.hospitalizacion.service.HospitalizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/hospitalizaciones")
@CrossOrigin(origins = "*")
public class HospitalizacionController {

    @Autowired
    private HospitalizacionService hospitalizacionService;

    @PostMapping
    public ResponseEntity<Hospitalizacion> registrarHospitalizacion(@RequestBody Hospitalizacion hospitalizacion) {
        Hospitalizacion nuevaHosp = hospitalizacionService.registrarHospitalizacion(hospitalizacion);
        return new ResponseEntity<>(nuevaHosp, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Hospitalizacion> buscarPorId(@PathVariable Integer id) {
        Hospitalizacion hospitalizacion = hospitalizacionService.buscarPorId(id);
        if (hospitalizacion != null) {
            return new ResponseEntity<>(hospitalizacion, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Hospitalizacion>> listarTodas() {
        List<Hospitalizacion> hospitalizaciones = hospitalizacionService.listarTodas();
        return new ResponseEntity<>(hospitalizaciones, HttpStatus.OK);
    }

    @GetMapping("/paciente/{idPaciente}")
    public ResponseEntity<List<Hospitalizacion>> listarPorPaciente(@PathVariable Integer idPaciente) {
        List<Hospitalizacion> hospitalizaciones = hospitalizacionService.listarPorPaciente(idPaciente);
        return new ResponseEntity<>(hospitalizaciones, HttpStatus.OK);
    }

    @GetMapping("/habitacion/{idHabitacion}")
    public ResponseEntity<List<Hospitalizacion>> listarPorHabitacion(@PathVariable Integer idHabitacion) {
        List<Hospitalizacion> hospitalizaciones = hospitalizacionService.listarPorHabitacion(idHabitacion);
        return new ResponseEntity<>(hospitalizaciones, HttpStatus.OK);
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Hospitalizacion>> listarPorEstado(@PathVariable String estado) {
        List<Hospitalizacion> hospitalizaciones = hospitalizacionService.listarPorEstado(estado);
        return new ResponseEntity<>(hospitalizaciones, HttpStatus.OK);
    }

    @GetMapping("/activas/paciente/{idPaciente}")
    public ResponseEntity<List<Hospitalizacion>> listarActivasPorPaciente(@PathVariable Integer idPaciente) {
        List<Hospitalizacion> hospitalizaciones = hospitalizacionService.listarActivasPorPaciente(idPaciente);
        return new ResponseEntity<>(hospitalizaciones, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Hospitalizacion> actualizarHospitalizacion(@PathVariable Integer id, @RequestBody Hospitalizacion hospitalizacion) {
        hospitalizacion.setIdHosp(id);
        Hospitalizacion hospActualizada = hospitalizacionService.actualizarHospitalizacion(hospitalizacion);
        return new ResponseEntity<>(hospActualizada, HttpStatus.OK);
    }

    @PatchMapping("/{id}/alta")
    public ResponseEntity<Hospitalizacion> darAlta(@PathVariable Integer id, @RequestParam String fechaAlta) {
        LocalDate fecha = LocalDate.parse(fechaAlta);
        Hospitalizacion hospActualizada = hospitalizacionService.darAlta(id, fecha);
        if (hospActualizada != null) {
            return new ResponseEntity<>(hospActualizada, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarHospitalizacion(@PathVariable Integer id) {
        hospitalizacionService.eliminarHospitalizacion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}