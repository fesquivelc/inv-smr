package com.proyecto.beans;


import java.io.Serializable;

import java.lang.Integer;
import java.lang.String;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="desplazo")
public  class Desplazo implements Serializable {


    @ManyToOne(optional=false,targetEntity=Bien.class)
    @JoinColumn(name="bien_id",referencedColumnName="id",insertable=true,nullable=true,unique=false,updatable=true)
    private Bien bienId;


    @Column(name="id",table="desplazo",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;


    @Column(name="fecha",table="desplazo",nullable=false)
    @Temporal(TemporalType.DATE)
    @Basic
    private Date fecha;


    @ManyToOne(optional=false,targetEntity=Ambiente.class)
    @JoinColumn(name="ambientedestino_id",referencedColumnName="id",insertable=true,nullable=true,unique=false,updatable=true)
    private Ambiente ambientedestinoId;


    @ManyToOne(optional=false,targetEntity=Ambiente.class)
    @JoinColumn(name="ambienteorigen_id",referencedColumnName="id",insertable=true,nullable=true,unique=false,updatable=true)
    private Ambiente ambienteorigenId;


    @Column(name="detalle",table="desplazo",length=45)
    @Basic
    private String detalle;

    public Desplazo(){

    }


   public Bien getBienId() {
        return this.bienId;
    }


  public void setBienId (Bien bienId) {
        this.bienId = bienId;
    }



   public Integer getId() {
        return this.id;
    }


  public void setId (Integer id) {
        this.id = id;
    }



   public Date getFecha() {
        return this.fecha;
    }


  public void setFecha (Date fecha) {
        this.fecha = fecha;
    }



   public Ambiente getAmbientedestinoId() {
        return this.ambientedestinoId;
    }


  public void setAmbientedestinoId (Ambiente ambientedestinoId) {
        this.ambientedestinoId = ambientedestinoId;
    }



   public Ambiente getAmbienteorigenId() {
        return this.ambienteorigenId;
    }


  public void setAmbienteorigenId (Ambiente ambienteorigenId) {
        this.ambienteorigenId = ambienteorigenId;
    }



   public String getDetalle() {
        return this.detalle;
    }


  public void setDetalle (String detalle) {
        this.detalle = detalle;
    }

}

