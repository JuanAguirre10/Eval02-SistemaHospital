package com.hospital.consultas.controller;

import com.hospital.consultas.model.DetalleReceta;
import com.hospital.consultas.service.DetalleRecetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalle-recetas")
@CrossOrigin(origins = "*")
public class DetalleRecetaController {

    @Autowired
    private DetalleRecetaService detalleRecetaService;

    @PostMapping
    public ResponseEntity<DetalleReceta> registrarDetalle(@RequestBody DetalleReceta detalle) {
        DetalleReceta nuevoDetalle = detalleRecetaService.registrarDetalle(detalle);
        return new ResponseEntity<>(nuevoDetalle, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleReceta> buscarPorId(@PathVariable Integer id) {
        DetalleReceta detalle = detalleRecetaService.buscarPorId(id);
        if (detalle != null) {
            return new ResponseEntity<>(detalle, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/receta/{idReceta}")
    public ResponseEntity<List<DetalleReceta>> listarPorReceta(@PathVariable Integer idReceta) {
        List<DetalleReceta> detalles = detalleRecetaService.listarPorReceta(idReceta);
        return new ResponseEntity<>(detalles, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleReceta> actualizarDetalle(@PathVariable Integer id, @RequestBody DetalleReceta detalle) {
        detalle.setIdDetalleReceta(id);
        DetalleReceta detalleActualizado = detalleRecetaService.actualizarDetalle(detalle);
        return new ResponseEntity<>(detalleActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDetalle(@PathVariable Integer id) {
        detalleRecetaService.eliminarDetalle(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}