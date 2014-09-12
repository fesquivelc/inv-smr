package com.proyecto.beans;


import java.io.Serializable;

import java.lang.Integer;
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
@Table(name="periodo")
public  class Periodo implements Serializable {


    @Column(name="id",table="periodo",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;


    @OneToMany(targetEntity=Bien.class,mappedBy="periodoId")
    private Collection<Bien> bienCollection;


    @Column(name="periodo",table="periodo")
    @Basic
    private Integer periodo;

    public Periodo(){

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



   public Integer getPeriodo() {
        return this.periodo;
    }


  public void setPeriodo (Integer periodo) {
        this.periodo = periodo;
    }

}

