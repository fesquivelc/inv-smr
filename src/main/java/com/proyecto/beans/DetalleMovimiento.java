package com.proyecto.beans;

import java.io.Serializable;

import java.lang.Long;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="detalle_movimiento")
public  class DetalleMovimiento implements Serializable {


    @Column(name="id",table="detalle_movimiento",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(optional=false,targetEntity=Inventario.class)
    @JoinColumn(name="inventario_id",referencedColumnName="id",insertable=true,nullable=true,unique=false,updatable=true)
    private Inventario inventario;


    @ManyToOne(optional=false,targetEntity=Movimiento.class)
    @JoinColumn(name="movimiento_id",referencedColumnName="id",insertable=true,nullable=true,unique=false,updatable=true)
    private Movimiento movimiento;

    public DetalleMovimiento(){

    }


   public Long getId() {
        return this.id;
    }


  public void setId (Long id) {
        this.id = id;
    }



   public Inventario getInventario() {
        return this.inventario;
    }


  public void setInventario (Inventario inventario) {
        this.inventario = inventario;
    }



   public Movimiento getMovimiento() {
        return this.movimiento;
    }


  public void setMovimiento (Movimiento movimiento) {
        this.movimiento = movimiento;
    }

}

