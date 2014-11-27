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
@Table(name="tipo_usuario")
public  class TipoUsuario implements Serializable {


    @Column(name="nombre",table="tipo_usuario",length=45)
    @Basic
    private String nombre;


    @Column(name="id",table="tipo_usuario",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


    @OneToMany(fetch=FetchType.LAZY,targetEntity=Usuario.class,mappedBy="tipoUsuario")
    private List<Usuario> usuarios;

    public TipoUsuario(){

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



   public List<Usuario> getUsuarios() {
        return this.usuarios;
    }


  public void setUsuarios (List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
  
  

}

