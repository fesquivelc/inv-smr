package com.proyecto.beans;

import java.io.Serializable;

import java.lang.Integer;
import java.lang.String;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "bien")
public class Bien implements Serializable {

    @ManyToOne(optional = false, targetEntity = Clase.class)
    @JoinColumn(name = "clase_id", referencedColumnName = "id", insertable = true, nullable = true, unique = false, updatable = true)
    private Clase claseId;

    @Column(name = "nombre", table = "bien", length = 45)
    @Basic
    private String nombre;

    @Column(name = "id", table = "bien", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(targetEntity = Desplazo.class, mappedBy = "bienId")
    private Collection<Desplazo> desplazoCollection;

    @Column(name = "estado", table = "bien", length = 45)
    @Basic
    private String estado;

    @Column(name = "precio", table = "bien")
    @Basic
    private Integer precio;
    
    @Column(name = "stock", table = "bien")
    @Basic
    private Integer stock;

    @ManyToOne(optional = false, targetEntity = Ambiente.class)
    @JoinColumn(name = "ambiente_id", referencedColumnName = "id", insertable = true, nullable = true, unique = false, updatable = true)
    private Ambiente ambienteId;

    @ManyToOne(optional = false, targetEntity = Periodo.class)
    @JoinColumn(name = "periodo_id", referencedColumnName = "id", insertable = true, nullable = true, unique = false, updatable = true)
    private Periodo periodoId;

    @ManyToOne(optional = false, targetEntity = Codigo.class)
    @JoinColumn(name = "codigo_id", referencedColumnName = "id", insertable = true, nullable = true, unique = false, updatable = true)
    private Codigo codigoId;

    @Column(name = "fotos", table = "bien")
    @Basic
    private String fotos;

    @Column(name = "detalle", table = "bien")
    @Basic
    private String detalle;

    public Bien() {

    }

    public Clase getClaseId() {
        return this.claseId;
    }

    public void setClaseId(Clase claseId) {
        this.claseId = claseId;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStock() {
        return this.stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Collection<Desplazo> getDesplazoCollection() {
        return this.desplazoCollection;
    }

    public void setDesplazoCollection(Collection<Desplazo> desplazoCollection) {
        this.desplazoCollection = desplazoCollection;
    }

    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getPrecio() {
        return this.precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Ambiente getAmbienteId() {
        return this.ambienteId;
    }

    public void setAmbienteId(Ambiente ambienteId) {
        this.ambienteId = ambienteId;
    }

    public Periodo getPeriodoId() {
        return this.periodoId;
    }

    public void setPeriodoId(Periodo periodoId) {
        this.periodoId = periodoId;
    }

    public Codigo getCodigoId() {
        return this.codigoId;
    }

    public void setCodigoId(Codigo codigoId) {
        this.codigoId = codigoId;
    }

    public String getFotos() {
        return this.fotos;
    }

    public void setFotos(String fotos) {
        this.fotos = fotos;
    }

    public String getDetalle() {
        return this.detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

}
