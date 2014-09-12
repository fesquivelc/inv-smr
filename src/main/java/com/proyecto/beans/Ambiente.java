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
@Table(name="ambiente")
public  class Ambiente implements Serializable {


    @Column(name="responsable",table="ambiente",length=45)
    @Basic
    private String responsable;


    @Column(name="nombre",table="ambiente",length=45)
    @Basic
    private String nombre;


    @Column(name="id",table="ambiente",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;


    @OneToMany(targetEntity=Desplazo.class,mappedBy="ambientedestinoId")
    private Collection<Desplazo> desplazoCollection;


    @OneToMany(targetEntity=Bien.class,mappedBy="ambienteId")
    private Collection<Bien> bienCollection;


    @OneToMany(targetEntity=Desplazo.class,mappedBy="ambienteorigenId")
    private Collection<Desplazo> desplazoCollection1;

    public Ambiente(){

    }


   public String getResponsable() {
        return this.responsable;
    }


  public void setResponsable (String responsable) {
        this.responsable = responsable;
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



   public Collection<Desplazo> getDesplazoCollection() {
        return this.desplazoCollection;
    }


  public void setDesplazoCollection (Collection<Desplazo> desplazoCollection) {
        this.desplazoCollection = desplazoCollection;
    }



   public Collection<Bien> getBienCollection() {
        return this.bienCollection;
    }


  public void setBienCollection (Collection<Bien> bienCollection) {
        this.bienCollection = bienCollection;
    }



   public Collection<Desplazo> getDesplazoCollection1() {
        return this.desplazoCollection1;
    }


  public void setDesplazoCollection1 (Collection<Desplazo> desplazoCollection1) {
        this.desplazoCollection1 = desplazoCollection1;
    }

}

