/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.proyecto.control;

import com.proyecto.beans.Proveedor;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Documentos
 */
public class ProveedorControlador extends Controlador<Proveedor>{

    public ProveedorControlador() {
        super(Proveedor.class);
    }
    
    public List<Proveedor> buscarXNombre(String nombre) {
        String jpql = "SELECT a FROM Proveedor a WHERE a.nombreProveedor LIKE CONCAT('%',:nombre,'%')";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("nombre", nombre);
        return this.getDao().buscar(jpql, parametros);
    }
}
