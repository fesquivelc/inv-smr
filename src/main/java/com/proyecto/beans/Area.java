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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="area")
public  class Area implements Serializable {


    @Column(name="codigo")
    @Basic
    private String codigo;


    @Column(name="nombre",table="area",length=45)
    @Basic
    private String nombre;


    @Column(name="id",table="area",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


    @OneToMany(fetch=FetchType.LAZY,targetEntity=Ambiente.class,mappedBy="area")
    private List<Ambiente> ambientes;

    public Area(){

    }


   public String getCodigo() {
        return this.codigo;
    }


  public void setCodigo (String codigo) {
        this.codigo = codigo;
    }



   public String getNombre() {
        return this.nombre;
    }


  public void setNombre (String nombre) {
        this.nombre = nombre;
    }



   public Long getId() {
        return this.id;
    }


  public void setId (Long id) {
        this.id = id;
    }



   public List<Ambiente> getAmbientes() {
        return this.ambientes;
    }


  public void setAmbientes (List<Ambiente> ambientes) {
        this.ambientes = ambientes;
    }

    @Override
    public String toString() {
        return nombre;
    }

  
}

