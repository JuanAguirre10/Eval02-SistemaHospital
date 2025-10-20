package com.hospital.facturacion.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Factura")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idFactura;

    @Column(nullable = false)
    private Integer idPaciente;

    @Column(nullable = false)
    private LocalDate fechaEmision;

    @Column(precision = 10, scale = 2)
    private BigDecimal total;

    @Column(length = 20)
    private String estado = "pendiente";

    public Factura() {
    }

    public Factura(Integer idFactura, Integer idPaciente, LocalDate fechaEmision, BigDecimal total, String estado) {
        this.idFactura = idFactura;
        this.idPaciente = idPaciente;
        this.fechaEmision = fechaEmision;
        this.total = total;
        this.estado = estado;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public Integer getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Integer idPaciente) {
        this.idPaciente = idPaciente;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDate fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}