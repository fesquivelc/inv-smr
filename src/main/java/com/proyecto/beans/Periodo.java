package com.proyecto.beans;

import java.io.Serializable;

import java.lang.Integer;
import java.lang.Long;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "periodo")
public class Periodo implements Serializable {

    @Column(name = "id", table = "periodo", nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Inventario.class, mappedBy = "periodo")
    private List<Inventario> inventarios;

    @Column(name = "periodo", table = "periodo")
    @Basic
    private Integer periodo;
    
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    @Basic
    private Date fechaCreacion;
    
    @Column(name = "vigente")
    @Basic
    private Boolean vigente;
    

    public Periodo() {

    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Inventario> getInventarios() {
        return this.inventarios;
    }

    public void setInventarios(List<Inventario> inventarios) {
        this.inventarios = inventarios;
    }

    public Integer getPeriodo() {
        return this.periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    
    

    public Boolean getVigente() {
        return vigente;
    }

    public void setVigente(Boolean vigente) {
        this.vigente = vigente;
    }

    
    
    @Override
    public String toString() {
        return periodo + "";
    }

}
