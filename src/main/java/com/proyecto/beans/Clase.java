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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="clase")
public  class Clase implements Serializable {


    @Column(name="nombre",table="clase",length=45)
    @Basic
    private String nombre;


    @Column(name="id",table="clase",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;


    @OneToMany(targetEntity=Bien.class,mappedBy="claseId")
    private Collection<Bien> bienCollection;

    public Clase(){

    }


   public String getNombre() {
        return this.nombre;
    }


  public void setNombre (String nombre) {
        this.nombre = nombre;
    }



   public Integer getId() {
        return this.id;
    }


  public void setId (Integer id) {
        this.id = id;
    }



   public Collection<Bien> getBienCollection() {
        return this.bienCollection;
    }


  public void setBienCollection (Collection<Bien> bienCollection) {
        this.bienCollection = bienCollection;
    }

}

