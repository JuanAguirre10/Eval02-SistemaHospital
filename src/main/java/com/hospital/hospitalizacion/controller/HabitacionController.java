package com.hospital.hospitalizacion.controller;

import com.hospital.hospitalizacion.model.Habitacion;
import com.hospital.hospitalizacion.service.HabitacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/habitaciones")
@CrossOrigin(origins = "*")
public class HabitacionController {

    @Autowired
    private HabitacionService habitacionService;

    @PostMapping
    public ResponseEntity<Habitacion> registrarHabitacion(@RequestBody Habitacion habitacion) {
        Habitacion nuevaHabitacion = habitacionService.registrarHabitacion(habitacion);
        return new ResponseEntity<>(nuevaHabitacion, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Habitacion> buscarPorId(@PathVariable Integer id) {
        Habitacion habitacion = habitacionService.buscarPorId(id);
        if (habitacion != null) {
            return new ResponseEntity<>(habitacion, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Habitacion>> listarTodas() {
        List<Habitacion> habitaciones = habitacionService.listarTodas();
        return new ResponseEntity<>(habitaciones, HttpStatus.OK);
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Habitacion>> listarPorEstado(@PathVariable String estado) {
        List<Habitacion> habitaciones = habitacionService.listarPorEstado(estado);
        return new ResponseEntity<>(habitaciones, HttpStatus.OK);
    }

    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<Habitacion>> listarPorTipo(@PathVariable String tipo) {
        List<Habitacion> habitaciones = habitacionService.listarPorTipo(tipo);
        return new ResponseEntity<>(habitaciones, HttpStatus.OK);
    }

    @GetMapping("/disponibles/{tipo}")
    public ResponseEntity<List<Habitacion>> listarDisponiblesPorTipo(@PathVariable String tipo) {
        List<Habitacion> habitaciones = habitacionService.listarDisponiblesPorTipo(tipo);
        return new ResponseEntity<>(habitaciones, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Habitacion> actualizarHabitacion(@PathVariable Integer id, @RequestBody Habitacion habitacion) {
        habitacion.setIdHabitacion(id);
        Habitacion habitacionActualizada = habitacionService.actualizarHabitacion(habitacion);
        return new ResponseEntity<>(habitacionActualizada, HttpStatus.OK);
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<Habitacion> cambiarEstado(@PathVariable Integer id, @RequestParam String estado) {
        Habitacion habitacionActualizada = habitacionService.cambiarEstado(id, estado);
        if (habitacionActualizada != null) {
            return new ResponseEntity<>(habitacionActualizada, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarHabitacion(@PathVariable Integer id) {
        habitacionService.eliminarHabitacion(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}