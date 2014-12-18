/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.proyecto.control;

import com.proyecto.beans.Empleado;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Documentos
 */
public class EmpleadoControlador extends Controlador<Empleado>{

    public EmpleadoControlador() {
        super(Empleado.class);
    }
    
    public List<Empleado> buscarXNombre(String nombre) {
        String jpql = "SELECT a FROM Empleado a WHERE a.nombres LIKE CONCAT('%',:nombre,'%')";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("nombre", nombre);
        return this.getDao().buscar(jpql, parametros);
    }
    
    public List<Empleado> buscarXIdLazy(int limite, int offset) {
        String jpql = "SELECT a FROM Empleado a ORDER BY a.dni";
        
        return this.getDao().buscar(jpql, null, limite, offset);
    }
        
}
