package com.proyecto.beans;

import java.io.Serializable;

import java.lang.Long;
import java.lang.String;
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

@Entity
@Table(name="inventario")
public  class Inventario implements Serializable {


    @Column(name="codigo_fabrica")
    @Basic
    private String codigoFabrica;


    @Column(name="serie",table="inventario")
    @Basic
    private String serie;


    @Column(name="id",table="inventario",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


    @Column(name="estado",table="inventario",length=45)
    @Basic
    private String estado;


    @ManyToOne(targetEntity=Factura.class)
    @JoinColumn(name="factura_id",referencedColumnName="id",insertable=true,nullable=true,unique=false,updatable=true)
    private Factura factura;


    @Column(name="precio",table="inventario")
    @Basic
    private Double precio;


    @ManyToOne(optional=false,targetEntity=Ambiente.class)
    @JoinColumn(name="ambiente_codigo",referencedColumnName="codigo",insertable=true,nullable=true,unique=false,updatable=true)
    private Ambiente ambiente;


    @ManyToOne(targetEntity=Proveedor.class)
    private Proveedor proveedor;


    @ManyToOne(optional=false,targetEntity=Periodo.class)
    @JoinColumn(name="periodo_id",referencedColumnName="id",insertable=true,nullable=true,unique=false,updatable=true)
    private Periodo periodo;


    @ManyToOne(optional=false,targetEntity=Bien.class)
    @JoinColumn(name="bien_id",referencedColumnName="id",insertable=true,nullable=true,unique=false,updatable=true)
    private Bien bien;


    @OneToMany(fetch=FetchType.LAZY,targetEntity=DetalleMovimiento.class,mappedBy="inventario")
    private List<DetalleMovimiento> detalleMovimientos;

    public Inventario(){

    }


   public String getCodigoFabrica() {
        return this.codigoFabrica;
    }


  public void setCodigoFabrica (String codigoFabrica) {
        this.codigoFabrica = codigoFabrica;
    }



   public String getSerie() {
        return this.serie;
    }


  public void setSerie (String serie) {
        this.serie = serie;
    }



   public Long getId() {
        return this.id;
    }


  public void setId (Long id) {
        this.id = id;
    }



   public String getEstado() {
        return this.estado;
    }


  public void setEstado (String estado) {
        this.estado = estado;
    }



   public Factura getFactura() {
        return this.factura;
    }


  public void setFactura (Factura factura) {
        this.factura = factura;
    }



   public Double getPrecio() {
        return this.precio;
    }


  public void setPrecio (Double precio) {
        this.precio = precio;
    }



   public Ambiente getAmbiente() {
        return this.ambiente;
    }


  public void setAmbiente (Ambiente ambiente) {
        this.ambiente = ambiente;
    }



   public Proveedor getProveedor() {
        return this.proveedor;
    }


  public void setProveedor (Proveedor proveedor) {
        this.proveedor = proveedor;
    }



   public Periodo getPeriodo() {
        return this.periodo;
    }


  public void setPeriodo (Periodo periodo) {
        this.periodo = periodo;
    }



   public Bien getBien() {
        return this.bien;
    }


  public void setBien (Bien bien) {
        this.bien = bien;
    }



   public List<DetalleMovimiento> getDetalleMovimientos() {
        return this.detalleMovimientos;
    }


  public void setDetalleMovimientos (List<DetalleMovimiento> detalleMovimientos) {
        this.detalleMovimientos = detalleMovimientos;
    }

}

