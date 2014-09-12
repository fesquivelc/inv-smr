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
@Table(name="codigo")
public  class Codigo implements Serializable {


    @Column(name="serie",table="codigo",length=45)
    @Basic
    private String serie;


    @Column(name="codigo",table="codigo",nullable=false,length=45)
    @Basic
    private String codigo;


    @Column(name="id",table="codigo",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;


    @OneToMany(targetEntity=Bien.class,mappedBy="codigoId")
    private Collection<Bien> bienCollection;

    public Codigo(){

    }


   public String getSerie() {
        return this.serie;
    }


  public void setSerie (String serie) {
        this.serie = serie;
    }



   public String getCodigo() {
        return this.codigo;
    }


  public void setCodigo (String codigo) {
        this.codigo = codigo;
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

