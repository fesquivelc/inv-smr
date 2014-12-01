/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.proyecto.control;

import com.proyecto.beans.Bien;
import com.proyecto.beans.Inventario;
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
    
    public List<Inventario> buscarXSerie(String buscar) {
        String jpql = "SELECT a FROM Inventario a WHERE CONCAT(a.bien.clase.codigo, a.serie) = :buscar";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("buscar", buscar);
        return this.getDao().buscar(jpql, parametros);
    }
    
    public int buscarXBien(Bien bien) {
        String jpql = "SELECT COUNT(a) FROM Inventario a WHERE a.bien = :bien";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("bien", bien);
        return this.getDao().contarFiltro(jpql, parametros);
    }
    
    public List<Inventario> buscarXBien2(Bien bien) {
        String jpql = "SELECT a FROM Inventario a WHERE a.bien = :bien";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("bien", bien);
        return this.getDao().buscar(jpql, parametros);
    }
    
   
    
}
