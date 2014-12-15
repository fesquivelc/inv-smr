package com.proyecto.beans;

import java.io.Serializable;

import java.lang.String;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "empleado")
public class Empleado implements Serializable {

    @Column(name = "nombres", table = "empleado", nullable = false, length = 45)
    @Basic
    private String nombres;

    @OneToOne(targetEntity = Usuario.class, mappedBy = "empleado")
    private Usuario usuario;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Ambiente.class, mappedBy = "empleado")
    private List<Ambiente> ambienteList;

    @Column(name = "telefono", table = "empleado", length = 45)
    @Basic
    private String telefono;

    @Column(name = "apellido_materno", table = "empleado", nullable = false, length = 45)
    @Basic
    private String apellidoMaterno;

    @Column(name = "apellido_paterno", table = "empleado", nullable = false, length = 45)
    @Basic
    private String apellidoPaterno;

    @Column(name = "dni", table = "empleado", nullable = false, length = 8)
    @Id
    private String dni;

    public Empleado() {

    }

    public String getNombres() {
        return this.nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Ambiente> getAmbienteList() {
        return this.ambienteList;
    }

    public void setAmbienteList(List<Ambiente> ambienteList) {
        this.ambienteList = ambienteList;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getApellidoMaterno() {
        return this.apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return this.apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return nombres + " " + apellidoPaterno + " " + apellidoMaterno;
    }
}
