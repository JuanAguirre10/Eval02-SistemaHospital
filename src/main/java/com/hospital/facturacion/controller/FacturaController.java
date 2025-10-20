package com.hospital.facturacion.controller;

import com.hospital.facturacion.model.Factura;
import com.hospital.facturacion.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
@CrossOrigin(origins = "*")
public class FacturaController {

    @Autowired
    private FacturaService facturaService;

    @PostMapping
    public ResponseEntity<Factura> generarFactura(@RequestBody Factura factura) {
        Factura nuevaFactura = facturaService.generarFactura(factura);
        return new ResponseEntity<>(nuevaFactura, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Factura> buscarPorId(@PathVariable Integer id) {
        Factura factura = facturaService.buscarPorId(id);
        if (factura != null) {
            return new ResponseEntity<>(factura, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity<List<Factura>> listarTodas() {
        List<Factura> facturas = facturaService.listarTodas();
        return new ResponseEntity<>(facturas, HttpStatus.OK);
    }

    @GetMapping("/paciente/{idPaciente}")
    public ResponseEntity<List<Factura>> listarPorPaciente(@PathVariable Integer idPaciente) {
        List<Factura> facturas = facturaService.listarPorPaciente(idPaciente);
        return new ResponseEntity<>(facturas, HttpStatus.OK);
    }

    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Factura>> listarPorEstado(@PathVariable String estado) {
        List<Factura> facturas = facturaService.listarPorEstado(estado);
        return new ResponseEntity<>(facturas, HttpStatus.OK);
    }

    @GetMapping("/pendientes/paciente/{idPaciente}")
    public ResponseEntity<List<Factura>> listarPendientesPorPaciente(@PathVariable Integer idPaciente) {
        List<Factura> facturas = facturaService.listarPendientesPorPaciente(idPaciente);
        return new ResponseEntity<>(facturas, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Factura> actualizarFactura(@PathVariable Integer id, @RequestBody Factura factura) {
        factura.setIdFactura(id);
        Factura facturaActualizada = facturaService.actualizarFactura(factura);
        return new ResponseEntity<>(facturaActualizada, HttpStatus.OK);
    }

    @PatchMapping("/{id}/pagar")
    public ResponseEntity<Factura> marcarComoPagada(@PathVariable Integer id) {
        Factura facturaActualizada = facturaService.marcarComoPagada(id);
        if (facturaActualizada != null) {
            return new ResponseEntity<>(facturaActualizada, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarFactura(@PathVariable Integer id) {
        facturaService.eliminarFactura(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}