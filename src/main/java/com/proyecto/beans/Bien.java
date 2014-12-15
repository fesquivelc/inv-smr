package com.proyecto.beans;

import java.io.Serializable;

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
@Table(name = "bien")
public class Bien implements Serializable {

    @Column(name = "nombre", table = "bien", length = 45,unique = true)
    @Basic
    private String nombre;

    @Column(name = "id", table = "bien", nullable = false, length = 45)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descripcion", table = "bien", length = 45)
    @Basic
    private String descripcion;

    @ManyToOne(optional = false, targetEntity = Clase.class)
    @JoinColumn(name = "clase_codigo", referencedColumnName = "codigo", insertable = true, nullable = true, unique = false, updatable = true)
    private Clase clase;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = DetalleBienCampo.class, mappedBy = "bien")
    private List<DetalleBienCampo> ListaCampos;

    @Column(name = "foto", table = "bien")
    @Basic
    private String foto;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Inventario.class, mappedBy = "bien")
    private List<Inventario> inventarios;

    public Bien() {

    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Clase getClase() {
        return this.clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public List<DetalleBienCampo> getListaCampos() {
        return this.ListaCampos;
    }

    public void setListaCampos(List<DetalleBienCampo> ListaCampos) {
        this.ListaCampos = ListaCampos;
    }

    public String getFoto() {
        return this.foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public List<Inventario> getInventarios() {
        return this.inventarios;
    }

    public void setInventarios(List<Inventario> inventarios) {
        this.inventarios = inventarios;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
