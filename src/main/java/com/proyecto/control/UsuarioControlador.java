/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.control;

import com.proyecto.beans.Usuario;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Documentos
 */
public class UsuarioControlador extends Controlador<Usuario> {

    public UsuarioControlador() {
        super(Usuario.class);
    }
    
    public List<Usuario> buscarXNombre(String nombre){
        String jpql = "SELECT a FROM Usuario a WHERE a.nombre = :nombre";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("nombre", nombre);
        return this.getDao().buscar(jpql, parametros);
    }
}
