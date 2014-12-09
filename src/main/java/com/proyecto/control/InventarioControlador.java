/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.proyecto.control;

import com.proyecto.beans.Bien;
import com.proyecto.beans.Clase;
import com.proyecto.beans.Inventario;
import com.proyecto.beans.Periodo;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;

/**
 *
 * @author Documentos
 */
public class InventarioControlador extends AbstractControlador<Inventario>{

    public InventarioControlador() {
        super(Inventario.class);
    }
    
    public List<Inventario> buscarXSerie(String buscar, Periodo periodo) {
        String jpql = "SELECT a FROM Inventario a WHERE CONCAT(a.bien.clase.codigo, a.serie) = :buscar AND a.periodo = :periodo";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("buscar", buscar);
        parametros.put("periodo", periodo);
        return this.getDao().buscar(jpql, parametros);
    }
    
    public int buscarXBien(Bien bien, Periodo periodo) {
        String jpql = "SELECT COUNT(a) FROM Inventario a WHERE a.bien = :bien AND a.periodo = :periodo";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("bien", bien);
        parametros.put("periodo", periodo);
        return this.getDao().contarFiltro(jpql, parametros);
    }
    
    public List<Inventario> buscarXBien2(Bien bien) {
        Clase clase = bien.getClase();
        String jpql = "SELECT a FROM Inventario a WHERE a.bien.clase = :clase";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("clase", clase);
        return this.getDao().buscar(jpql, parametros);
    }
    
    public List<Inventario> buscarXBien3(Bien bien, Periodo periodo) {
        String jpql = "SELECT a FROM Inventario a WHERE a.bien = :bien AND a.periodo = :periodo";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("bien", bien);
        parametros.put("periodo", periodo);
        return this.getDao().buscar(jpql, parametros);
    }
    
    public List<Inventario> buscarXFecha(Date inicio, Date fin) {
        String jpql = "SELECT a FROM Inventario a WHERE a.fechaIngreso BETWEEN :inicio AND :fin";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("inicio", inicio);
        parametros.put("fin", fin);
        return this.getDao().buscar(jpql, parametros);
    }
    
    public String obtenerUltimaSerie(String serie) {
        String jpql = "SELECT MAX(i.serie) FROM Inventario i WHERE i.bien.clase.codigo = :serie";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("serie", serie);
        return this.getDao().buscarUltimo(jpql, parametros);
    }
    
    public List<Inventario> buscarXPeriodo(Periodo periodo) {
        String jpql = "SELECT a FROM Inventario a WHERE a.periodo = :periodo ";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("periodo", periodo);
        return this.getDao().buscar(jpql, parametros);
    }
}
