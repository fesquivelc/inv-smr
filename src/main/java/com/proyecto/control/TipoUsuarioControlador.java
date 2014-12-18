/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.proyecto.control;

import com.proyecto.beans.TipoUsuario;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Documentos
 */
public class TipoUsuarioControlador extends Controlador<TipoUsuario>{

    public TipoUsuarioControlador() {
        super(TipoUsuario.class);
    }
    
    public List<TipoUsuario> buscarXNombre(String nombre){
        String jpql = "SELECT a FROM TipoUsuario a WHERE a.nombre LIKE CONCAT('%',:nombre,'%')";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("nombre", nombre);
        return this.getDao().buscar(jpql, parametros);
    }
}
