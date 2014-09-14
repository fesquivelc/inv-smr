package com.proyecto.beans;

import java.io.Serializable;

import java.lang.Long;
import java.lang.String;
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
@Table(name="movimiento")
public  class Movimiento implements Serializable {


    @ManyToOne(optional=false,targetEntity=Ambiente.class)
    @JoinColumn(name="ambiente_codigo_destino",referencedColumnName="codigo",insertable=true,nullable=true,unique=false,updatable=true)
    private Ambiente ambienteDestino;


    @Column(name="id",table="movimiento",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


    @Column(name="fecha",table="movimiento")
    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    private Date fecha;


    @ManyToOne(optional=false,targetEntity=Usuario.class)
    @JoinColumn(name="usuario_id",referencedColumnName="id",insertable=true,nullable=true,unique=false,updatable=true)
    private Usuario usuario;


    @OneToMany(fetch=FetchType.LAZY,targetEntity=DetalleMovimiento.class,mappedBy="movimiento")
    private List<DetalleMovimiento> detalles;


    @ManyToOne(optional=false,targetEntity=Ambiente.class)
    @JoinColumn(name="ambiente_codigo_origen",referencedColumnName="codigo",insertable=true,nullable=true,unique=false,updatable=true)
    private Ambiente ambienteOrigen;


    @Column(name="detalle",table="movimiento",length=45)
    @Basic
    private String detalle;

    public Movimiento(){

    }


   public Ambiente getAmbienteDestino() {
        return this.ambienteDestino;
    }


  public void setAmbienteDestino (Ambiente ambienteDestino) {
        this.ambienteDestino = ambienteDestino;
    }



   public Long getId() {
        return this.id;
    }


  public void setId (Long id) {
        this.id = id;
    }



   public Date getFecha() {
        return this.fecha;
    }


  public void setFecha (Date fecha) {
        this.fecha = fecha;
    }



   public Usuario getUsuario() {
        return this.usuario;
    }


  public void setUsuario (Usuario usuario) {
        this.usuario = usuario;
    }



   public List<DetalleMovimiento> getDetalles() {
        return this.detalles;
    }


  public void setDetalles (List<DetalleMovimiento> detalles) {
        this.detalles = detalles;
    }



   public Ambiente getAmbienteOrigen() {
        return this.ambienteOrigen;
    }


  public void setAmbienteOrigen (Ambiente ambienteOrigen) {
        this.ambienteOrigen = ambienteOrigen;
    }



   public String getDetalle() {
        return this.detalle;
    }


  public void setDetalle (String detalle) {
        this.detalle = detalle;
    }

}

