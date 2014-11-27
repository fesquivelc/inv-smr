/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.proyecto.control;

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
    
    public List<Inventario> buscarXCodigo(String codigo) {
        String jpql = "SELECT a FROM Inventario a WHERE a.bien.codigo = :codigo";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("codigo", codigo);
        return this.getDao().buscar(jpql, parametros);
    }
    
}
