package com.hospital.seguridad.controller;

import com.hospital.seguridad.model.Bitacora;
import com.hospital.seguridad.service.BitacoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bitacora")
@CrossOrigin(origins = "*")
public class BitacoraController {

    @Autowired
    private BitacoraService bitacoraService;

    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<List<Bitacora>> listarPorUsuario(@PathVariable Integer idUsuario) {
        List<Bitacora> bitacoras = bitacoraService.listarPorUsuario(idUsuario);
        return new ResponseEntity<>(bitacoras, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Bitacora>> listarTodas() {
        List<Bitacora> bitacoras = bitacoraService.listarTodas();
        return new ResponseEntity<>(bitacoras, HttpStatus.OK);
    }
}