package com.hospital.facturacion.controller;

import com.hospital.facturacion.model.DetalleFactura;
import com.hospital.facturacion.service.DetalleFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalle-facturas")
@CrossOrigin(origins = "*")
public class DetalleFacturaController {

    @Autowired
    private DetalleFacturaService detalleFacturaService;

    @PostMapping
    public ResponseEntity<DetalleFactura> agregarDetalle(@RequestBody DetalleFactura detalle) {
        DetalleFactura nuevoDetalle = detalleFacturaService.agregarDetalle(detalle);
        return new ResponseEntity<>(nuevoDetalle, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleFactura> buscarPorId(@PathVariable Integer id) {
        DetalleFactura detalle = detalleFacturaService.buscarPorId(id);
        if (detalle != null) {
            return new ResponseEntity<>(detalle, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/factura/{idFactura}")
    public ResponseEntity<List<DetalleFactura>> listarPorFactura(@PathVariable Integer idFactura) {
        List<DetalleFactura> detalles = detalleFacturaService.listarPorFactura(idFactura);
        return new ResponseEntity<>(detalles, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleFactura> actualizarDetalle(@PathVariable Integer id, @RequestBody DetalleFactura detalle) {
        detalle.setIdDetalleFactura(id);
        DetalleFactura detalleActualizado = detalleFacturaService.actualizarDetalle(detalle);
        return new ResponseEntity<>(detalleActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDetalle(@PathVariable Integer id) {
        detalleFacturaService.eliminarDetalle(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}