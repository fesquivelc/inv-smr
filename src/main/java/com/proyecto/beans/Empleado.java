package com.proyecto.beans;

import java.io.Serializable;

import java.lang.String;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="empleado")
public  class Empleado implements Serializable {


    @OneToMany(targetEntity=Usuario.class,mappedBy="empleado")
    private Collection<Usuario> usuarioCollection;


    @Column(name="nombres",table="empleado",nullable=false,length=45)
    @Basic
    private String nombres;


    @OneToMany(targetEntity=Ambiente.class,mappedBy="empleado")
    private Collection<Ambiente> ambienteCollection;


    @Column(name="telefono",table="empleado",length=45)
    @Basic
    private String telefono;


    @Column(name="apellido_materno",table="empleado",nullable=false,length=45)
    @Basic
    private String apellidoMaterno;


    @Column(name="apellido_paterno",table="empleado",nullable=false,length=45)
    @Basic
    private String apellidoPaterno;


    @Column(name="dni",table="empleado",nullable=false,length=8)
    @Id
    private String dni;

    public Empleado(){

    }


   public Collection<Usuario> getUsuarioCollection() {
        return this.usuarioCollection;
    }


  public void setUsuarioCollection (Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }



   public String getNombres() {
        return this.nombres;
    }


  public void setNombres (String nombres) {
        this.nombres = nombres;
    }



   public Collection<Ambiente> getAmbienteCollection() {
        return this.ambienteCollection;
    }


  public void setAmbienteCollection (Collection<Ambiente> ambienteCollection) {
        this.ambienteCollection = ambienteCollection;
    }



   public String getTelefono() {
        return this.telefono;
    }


  public void setTelefono (String telefono) {
        this.telefono = telefono;
    }



   public String getApellidoMaterno() {
        return this.apellidoMaterno;
    }


  public void setApellidoMaterno (String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }



   public String getApellidoPaterno() {
        return this.apellidoPaterno;
    }


  public void setApellidoPaterno (String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }



   public String getDni() {
        return this.dni;
    }


  public void setDni (String dni) {
        this.dni = dni;
    }

}

