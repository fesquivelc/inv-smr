/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.proyecto.control;

import com.proyecto.beans.Bien;
import com.proyecto.beans.DetalleBienCampo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Documentos
 */
public class DetalleBienCampoControlador extends AbstractControlador<DetalleBienCampo>{
    public DetalleBienCampoControlador(){
        super(DetalleBienCampo.class);
    }
    
    public List<DetalleBienCampo> buscarXBien(Bien bien) {
        String jpql = "SELECT a FROM DetalleBienCampo a WHERE a.bien = :bien";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("bien", bien);
        return this.getDao().buscar(jpql, parametros);
    }
}
