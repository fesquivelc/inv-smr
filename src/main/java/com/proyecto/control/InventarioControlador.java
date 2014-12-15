/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.control;

import com.proyecto.beans.Ambiente;
import com.proyecto.beans.Area;
import com.proyecto.beans.Bien;
import com.proyecto.beans.Clase;
import com.proyecto.beans.Inventario;
import com.proyecto.beans.Periodo;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;

/**
 *
 * @author Documentos
 */
public class InventarioControlador extends AbstractControlador<Inventario> {

    public InventarioControlador() {
        super(Inventario.class);
    }

    public List<Inventario> buscarXSerie(String buscar) {
        String jpql = "SELECT a FROM Inventario a WHERE (a.codigoFabrica = :buscar OR (CONCAT(a.bien.clase.codigo, a.serie) = :buscar)) AND a.periodo.vigente = false ORDER BY a.periodo.fechaCreacion DESC";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("buscar", buscar);
        return this.getDao().buscar(jpql, parametros);
    }

    public int buscarXBien(Bien bien, Periodo periodo) {
        String jpql = "SELECT COUNT(a) FROM Inventario a WHERE a.bien = :bien AND a.periodo = :periodo";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("bien", bien);
        parametros.put("periodo", periodo);
        return this.getDao().contarFiltro(jpql, parametros);
    }

    public List<Inventario> buscarXBien2(Bien bien) {
        Clase clase = bien.getClase();
        String jpql = "SELECT a FROM Inventario a WHERE a.bien.clase = :clase";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("clase", clase);
        return this.getDao().buscar(jpql, parametros);
    }

    public List<Inventario> buscarXBien3(Bien bien) {
        String jpql = "SELECT a FROM Inventario a WHERE a.bien = :bien AND a.periodo.vigente = false ORDER BY a.periodo.fechaCreacion DESC";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("bien", bien);
        return this.getDao().buscar(jpql, parametros);
    }

    public List<Inventario> buscarXFecha(Date inicio, Date fin) {
        String jpql = "SELECT a FROM Inventario a WHERE a.fechaIngreso BETWEEN :inicio AND :fin";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("inicio", inicio);
        parametros.put("fin", fin);
        return this.getDao().buscar(jpql, parametros);
    }

    public String obtenerUltimaSerie(String serie) {
        String jpql = "SELECT MAX(i.serie) FROM Inventario i WHERE i.bien.clase.codigo = :serie";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("serie", serie);
        return this.getDao().buscarUltimo(jpql, parametros);
    }

    public List<Inventario> buscarXPeriodo(Periodo periodo) {
        String jpql = "SELECT a FROM Inventario a WHERE a.periodo = :periodo ";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("periodo", periodo);
        return this.getDao().buscar(jpql, parametros);
    }

    public List<Inventario> buscarXAmbiente(Ambiente ambiente) {
        String jpql = "SELECT a FROM Inventario a WHERE a.ambiente= :ambiente ORDER By a.bien.clase.codigo,a.serie,a.bien.nombre";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("ambiente", ambiente);
        return this.getDao().buscar(jpql, parametros);
    }

    public List<Inventario> buscarXArea(Area area) {
        String jpql = "SELECT a FROM Inventario a WHERE a.ambiente.area = :area ORDER By a.bien.clase.codigo,a.serie,a.bien.nombre";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("area", area);
        return this.getDao().buscar(jpql, parametros);
    }

//    public Inventario buscarInventarioXSerie(String buscar) {
//        String jpql = "SELECT a FROM Inventario a WHERE CONCAT(a.bien.clase.codigo, a.serie) = :buscar ";
//        Map<String, Object> parametros = new HashMap<>();
//        parametros.put("buscar", buscar);
//        List<Inventario> inventarios = new ArrayList();
//        inventarios.clear();
//        inventarios.addAll(this.getDao().buscar(jpql, parametros));
//        System.out.println("TAMAÑO: "+inventarios.size());
//        Inventario elInventario = inventarios.get(0);
//        return elInventario;
//    }
    public List<Inventario> buscarLazyXFechas(Date inicio, Date fin, int desde, int tamanio) {
        String jpql = "SELECT a FROM Inventario a WHERE a.fechaIngreso BETWEEN :inicio AND :fin";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("inicio", inicio);
        parametros.put("fin", fin);
        return this.getDao().buscar(jpql, parametros, desde, tamanio);
    }

    public int totalXFechas(Date inicio, Date fin) {
        String jpql = "SELECT COUNT(a) FROM Inventario a WHERE a.fechaIngreso BETWEEN :inicio AND :fin";
        Long cont = (Long) this.getDao().getEntityManager().createQuery(jpql).setParameter("inicio", inicio).setParameter("fin", fin).getSingleResult();
        int conteo = cont.intValue();
        return conteo;
    }

    public List<Inventario> buscarXAmbiente(Ambiente ambiente, Periodo periodo) {
        String jpql = "SELECT a FROM Inventario a WHERE a.ambiente = :ambiente AND a.periodo = :periodo";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("ambiente", ambiente);
        parametros.put("periodo", periodo);
        return this.getDao().buscar(jpql, parametros);
    }

    public List<Inventario> buscarInventarioXNombreBien(String nombre, Ambiente ambiente, Periodo periodo) {
        String jpql = "SELECT a FROM Inventario a WHERE a.bien.nombre LIKE CONCAT('%',:nombre,'%') AND a.ambiente = :ambiente AND a.periodo = :periodo";
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("nombre", nombre);
        parametros.put("ambiente", ambiente);
        parametros.put("periodo", periodo);
        return this.getDao().buscar(jpql, parametros);
    }
}
