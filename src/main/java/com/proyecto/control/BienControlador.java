/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.proyecto.control;

import com.proyecto.beans.Ambiente;
import com.proyecto.beans.Bien;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Documentos
 */
public class BienControlador extends AbstractControlador<Bien>{
     public BienControlador() {
        super(Bien.class);
    }
     
     public List<Bien> buscarXIdLazy(int limite, int offset) {
        String jpql = "SELECT a FROM Bien a ORDER BY a.id";
        
        return this.getDao().buscar(jpql, null, limite, offset);
    }
     
     public List<Bien> buscarXCodigo(String id) {
        String jpql = "SELECT a FROM Bien a WHERE a.id = :id";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("id", id);
        return this.getDao().buscar(jpql, parametros);
    }
     
     public List<Bien> buscarXNombre(String nombre) {
        String jpql = "SELECT a FROM Bien a WHERE a.nombre LIKE CONCAT('%',:nombre,'%')";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("nombre", nombre);
        return this.getDao().buscar(jpql, parametros);
    }
     
    public List<Bien> buscarLazyXNombre(String nombre,int desde, int tamanio){
        String jpql = "SELECT a FROM Bien a WHERE a.nombre LIKE CONCAT('%',:nombre,'%')";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("nombre", nombre);
        return this.getDao().buscar(jpql, parametros, desde, tamanio);
    }
    
    public int totalXNombre(String nombre){
        String jpql = "SELECT COUNT(a) FROM Bien a WHERE a.nombre LIKE CONCAT('%',:nombre,'%')";
//        Map<String, Object> parametros = new HashMap<>();
//        parametros.put("nombre", nombre);
        Long cont = (Long)this.getDao().getEntityManager().createQuery(jpql).setParameter("nombre", nombre).getSingleResult();
        int conteo = cont.intValue();
        return conteo;
    }
}
