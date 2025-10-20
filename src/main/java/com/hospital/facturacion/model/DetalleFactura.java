package com.hospital.facturacion.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "DetalleFactura")
public class DetalleFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idDetalleFactura;

    @Column(nullable = false)
    private Integer idFactura;

    @Column(length = 200)
    private String concepto;

    @Column(precision = 10, scale = 2)
    private BigDecimal monto;

    public DetalleFactura() {
    }

    public DetalleFactura(Integer idDetalleFactura, Integer idFactura, String concepto, BigDecimal monto) {
        this.idDetalleFactura = idDetalleFactura;
        this.idFactura = idFactura;
        this.concepto = concepto;
        this.monto = monto;
    }

    public Integer getIdDetalleFactura() {
        return idDetalleFactura;
    }

    public void setIdDetalleFactura(Integer idDetalleFactura) {
        this.idDetalleFactura = idDetalleFactura;
    }

    public Integer getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Integer idFactura) {
        this.idFactura = idFactura;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
}