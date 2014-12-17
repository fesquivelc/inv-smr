/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.control;

import com.proyecto.beans.Ambiente;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Documentos
 */
public class AmbienteControlador extends AbstractControlador<Ambiente> {

    public AmbienteControlador() {
        super(Ambiente.class);
    }
    
    public List<Ambiente> buscarXNombre(String nombre){
        String jpql = "SELECT a FROM Ambiente a WHERE a.nombre LIKE CONCAT('%',:nombre,'%') ";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("nombre", nombre);
        return this.getDao().buscar(jpql, parametros);
    }
    
    public List<Ambiente> buscarXIdLazy(int limite, int offset) {
        String jpql = "SELECT a FROM Clase a ORDER BY a.codigo";
        
        return this.getDao().buscar(jpql, null, limite, offset);
    }
    
    public List<Ambiente> buscarXNombreXCodigo(String buscar){
        String jpql = "SELECT a FROM Ambiente a WHERE a.nombre LIKE CONCAT('%',:buscar,'%') OR a.codigo LIKE CONCAT('%',:buscar,'%')";
        Map<String, Object> parametros = new HashMap<>();       
        parametros.put("buscar", buscar);
        return this.getDao().buscar(jpql, parametros);      
        
    }
}
