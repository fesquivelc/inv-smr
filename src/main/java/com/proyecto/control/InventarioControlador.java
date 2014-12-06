/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.proyecto.control;

import com.proyecto.beans.Bien;
import com.proyecto.beans.Inventario;
import com.proyecto.beans.Periodo;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    
    public List<Inventario> buscarXBien2(Bien bien, Periodo periodo) {
        String jpql = "SELECT a FROM Inventario a WHERE a.bien = :bien AND a.periodo = :periodo";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("bien", bien);
        parametros.put("periodo", periodo);
        return this.getDao().buscar(jpql, parametros);
    }
    
    public List<Inventario> buscarXPeriodoXFecha(Periodo periodo, Date inicio, Date fin) {
        String jpql = "SELECT a FROM Inventario a WHERE a.periodo = :periodo OR a.fechaIngreso BETWEEN :inicio AND :fin";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("periodo", periodo);
        parametros.put("inicio", inicio);
        parametros.put("fin", fin);
        return this.getDao().buscar(jpql, parametros);
    }
    
    
}
