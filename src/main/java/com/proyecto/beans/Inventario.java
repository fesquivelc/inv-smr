package com.proyecto.beans;

import java.io.Serializable;

import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "inventario")
public class Inventario implements Serializable {

    @Column(name = "codigo_fabrica")
    @Basic
    private String codigoFabrica;

    @ManyToOne(targetEntity = Factura.class)
    @JoinColumn(name = "factura_id", referencedColumnName = "id", insertable = true, nullable = true, unique = false, updatable = true)
    private Factura factura;


    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    @Basic
    private Date fechaIngreso;

    @ManyToOne(optional = false, targetEntity = Ambiente.class)
    @JoinColumn(name = "ambiente_codigo", referencedColumnName = "codigo", insertable = true, nullable = true, unique = false, updatable = true)
    private Ambiente ambiente;

    @ManyToOne(optional = false, targetEntity = Bien.class)
    @JoinColumn(name = "bien_id", referencedColumnName = "id", insertable = true, nullable = true, unique = false, updatable = true)
    private Bien bien;

    @Column(name = "baja")
    @Basic
    private Boolean baja;

    @Column(name = "impresion_pendiente")
    @Basic
    private Boolean impresionPendiente;

    @Column(name = "id", table = "inventario", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "serie", table = "inventario")
    @Basic
    private String serie;

    @Column(name = "estado", table = "inventario", length = 45)
    @Basic
    private String estado;

    @Column(name = "precio", table = "inventario")
    @Basic
    private Double precio;

    @ManyToOne(optional = false, targetEntity = Periodo.class)
    @JoinColumn(name = "periodo_id", referencedColumnName = "id", insertable = true, nullable = true, unique = false, updatable = true)
    private Periodo periodo;

    @ManyToOne(targetEntity = Proveedor.class)
    private Proveedor proveedor;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = DetalleMovimiento.class, mappedBy = "inventario")
    private List<DetalleMovimiento> detalleMovimientos;

    public Inventario() {

    }

    public String getCodigoFabrica() {
        return this.codigoFabrica;
    }

    public void setCodigoFabrica(String codigoFabrica) {
        this.codigoFabrica = codigoFabrica;
    }

    public Factura getFactura() {
        return this.factura;
    }

    public void setFactura(Factura factura) {
        this.factura = factura;
    }


    public Date getFechaIngreso() {
        return this.fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Ambiente getAmbiente() {
        return this.ambiente;
    }

    public void setAmbiente(Ambiente ambiente) {
        this.ambiente = ambiente;
    }

    public Bien getBien() {
        return this.bien;
    }

    public void setBien(Bien bien) {
        this.bien = bien;
    }

    public Boolean isBaja() {
        return this.baja;
    }

    public void setBaja(Boolean baja) {
        this.baja = baja;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerie() {
        return this.serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getPrecio() {
        return this.precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Periodo getPeriodo() {
        return this.periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public Proveedor getProveedor() {
        return this.proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public List<DetalleMovimiento> getDetalleMovimientos() {
        return this.detalleMovimientos;
    }

    public void setDetalleMovimientos(List<DetalleMovimiento> detalleMovimientos) {
        this.detalleMovimientos = detalleMovimientos;
    }

    public Boolean getImpresionPendiente() {
        return impresionPendiente;
    }

    public void setImpresionPendiente(Boolean impresionPendiente) {
        this.impresionPendiente = impresionPendiente;
    }

}
