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
@Table(name="usuario")
public  class Usuario implements Serializable {


    @Column(name="nombre",table="usuario",length=45)
    @Basic
    private String nombre;


    @Column(name="id",table="usuario",nullable=false)
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(optional=false,targetEntity=TipoUsuario.class)
    @JoinColumn(name="tipo_usuario_id",referencedColumnName="id",insertable=true,nullable=true,unique=false,updatable=true)
    private TipoUsuario tipoUsuario;


    @ManyToOne(optional=false,targetEntity=Empleado.class)
    @JoinColumn(name="empleado_dni",referencedColumnName="dni",insertable=true,nullable=true,unique=false,updatable=true)
    private Empleado empleado;


    @OneToMany(fetch=FetchType.LAZY,targetEntity=Movimiento.class,mappedBy="usuario")
    private List<Movimiento> movimientos;


    @Column(name="password",table="usuario")
    @Basic
    private String password;

    public Usuario(){

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



   public TipoUsuario getTipoUsuario() {
        return this.tipoUsuario;
    }


  public void setTipoUsuario (TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }



   public Empleado getEmpleado() {
        return this.empleado;
    }


  public void setEmpleado (Empleado empleado) {
        this.empleado = empleado;
    }



   public List<Movimiento> getMovimientos() {
        return this.movimientos;
    }


  public void setMovimientos (List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }



   public String getPassword() {
        return this.password;
    }


  public void setPassword (String password) {
        this.password = password;
    }

}

