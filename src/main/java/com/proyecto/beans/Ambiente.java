package com.proyecto.beans;

import java.io.Serializable;

import java.lang.String;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "ambiente")
public class Ambiente implements Serializable {

    @Column(name = "nombre", table = "ambiente", length = 45)
    @Basic
    private String nombre;

    @Column(name = "codigo", table = "ambiente", nullable = false, length = 10)
    @Id
    private String codigo;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Movimiento.class, mappedBy = "ambienteOrigen")
    private List<Movimiento> movimientosOrigen;

    @ManyToOne(optional = false, fetch = FetchType.EAGER, targetEntity = Area.class)
    @JoinColumn(name = "area_id", referencedColumnName = "id", insertable = true, nullable = true, unique = false, updatable = true)
    private Area area;

    @ManyToOne(optional = false, targetEntity = Empleado.class)
    @JoinColumn(name = "empleado_dni", referencedColumnName = "dni", insertable = true, nullable = true, unique = false, updatable = true)
    private Empleado empleado;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Movimiento.class, mappedBy = "ambienteDestino")
    private List<Movimiento> movimientosDestino;

    @OneToMany(fetch = FetchType.LAZY, targetEntity = Inventario.class, mappedBy = "ambiente")
    private List<Inventario> inventarios;

    public Ambiente() {

    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Movimiento> getMovimientosOrigen() {
        return this.movimientosOrigen;
    }

    public void setMovimientosOrigen(List<Movimiento> movimientosOrigen) {
        this.movimientosOrigen = movimientosOrigen;
    }

    public Area getArea() {
        return this.area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Empleado getEmpleado() {
        return this.empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public List<Movimiento> getMovimientosDestino() {
        return this.movimientosDestino;
    }

    public void setMovimientosDestino(List<Movimiento> movimientosDestino) {
        this.movimientosDestino = movimientosDestino;
    }

    public List<Inventario> getInventarios() {
        return this.inventarios;
    }

    public void setInventarios(List<Inventario> inventarios) {
        this.inventarios = inventarios;
    }

    @Override
    public String toString() {
        return codigo + " : " + nombre;
    }

}
