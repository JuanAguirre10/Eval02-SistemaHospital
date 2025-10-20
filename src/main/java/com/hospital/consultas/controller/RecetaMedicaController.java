package com.hospital.consultas.controller;

import com.hospital.consultas.model.RecetaMedica;
import com.hospital.consultas.service.RecetaMedicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recetas")
@CrossOrigin(origins = "*")
public class RecetaMedicaController {

    @Autowired
    private RecetaMedicaService recetaMedicaService;

    @PostMapping
    public ResponseEntity<RecetaMedica> registrarReceta(@RequestBody RecetaMedica receta) {
        RecetaMedica nuevaReceta = recetaMedicaService.registrarReceta(receta);
        return new ResponseEntity<>(nuevaReceta, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RecetaMedica> buscarPorId(@PathVariable Integer id) {
        RecetaMedica receta = recetaMedicaService.buscarPorId(id);
        if (receta != null) {
            return new ResponseEntity<>(receta, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/consulta/{idConsulta}")
    public ResponseEntity<List<RecetaMedica>> listarPorConsulta(@PathVariable Integer idConsulta) {
        List<RecetaMedica> recetas = recetaMedicaService.listarPorConsulta(idConsulta);
        return new ResponseEntity<>(recetas, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RecetaMedica> actualizarReceta(@PathVariable Integer id, @RequestBody RecetaMedica receta) {
        receta.setIdReceta(id);
        RecetaMedica recetaActualizada = recetaMedicaService.actualizarReceta(receta);
        return new ResponseEntity<>(recetaActualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReceta(@PathVariable Integer id) {
        recetaMedicaService.eliminarReceta(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}