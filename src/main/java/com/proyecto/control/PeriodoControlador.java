/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.proyecto.control;

import com.proyecto.beans.Periodo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;

/**
 *
 * @author Documentos
 */
public class PeriodoControlador extends Controlador<Periodo>{
     public PeriodoControlador() {
        super(Periodo.class);
    }
     
     public Periodo buscarPeriodoVigente() {
        String jpql = "SELECT a FROM Periodo a WHERE a.vigente = true";
        List<Periodo> periodo = this.getDao().buscar(jpql, null, -1, 1);
        Periodo elPeriodo = periodo.get(0);
        return elPeriodo;
    }
     
     public Periodo buscarPeriodoAnterior() {
        String jpql = "SELECT a FROM Periodo a WHERE a.vigente = false ORDER BY a.fechaRegistro DESC";
        List<Periodo> periodo = this.getDao().buscar(jpql, null, -1, 1);
        Periodo elPeriodo = periodo.get(0);
        return elPeriodo;
    }
     
     public void setearVigenteFalse() {
        String jpql = "UPDATE Periodo d SET d.vigente = false WHERE p.vigente = true";
        this.getDao().ejecutarQuery(jpql, null, -1, -1);
    }
     
     public List<Periodo> buscarPeriodosXAnio(int anio) {
        String jpql = "SELECT a FROM Periodo a WHERE a.periodo = :anio";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("anio", anio);
        return this.getDao().buscar(jpql, parametros);
    }
}
