package com.proyecto.beans;

import java.io.Serializable;

import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="factura")
public  class Factura implements Serializable {


    @OneToMany(targetEntity=Inventario.class,mappedBy="factura")
    private List<Inventario> inventarioList;


    @Column(name="id",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


    @Column(name="numero_factura")
    @Basic
    private String numeroFactura;


    @Column(name="ruta")
    @Basic
    private String ruta;

    public Factura(){

    }


   public List<Inventario> getInventarioList() {
        return this.inventarioList;
    }


  public void setInventarioList (List<Inventario> inventarioList) {
        this.inventarioList = inventarioList;
    }



   public Long getId() {
        return this.id;
    }


  public void setId (Long id) {
        this.id = id;
    }



   public String getNumeroFactura() {
        return this.numeroFactura;
    }


  public void setNumeroFactura (String numeroFactura) {
        this.numeroFactura = numeroFactura;
    }



   public String getRuta() {
        return this.ruta;
    }


  public void setRuta (String ruta) {
        this.ruta = ruta;
    }

}

