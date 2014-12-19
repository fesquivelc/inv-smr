/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.proyecto.dao;

import biz.juvitec.util.ParametrosUtil;
import biz.juvitec.util.PropertiesUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author Kyon
 * @param <T>
 */
public class DAO<T> {

    private final String PU = "postgresql-PU";
    private static EntityManager em;
    private final Class<T> clase;
    public static String url;
    public static String usuario;
    public static String password;
    public static String driver;
    
    private static final Logger LOG = Logger.getLogger(DAO.class.getName());

    public DAO(Class<T> clase) {
        this.clase = clase;
    }

    public EntityManager getEntityManager() {
        if (em == null) {
            Properties configuracion = PropertiesUtil.cargarProperties("configuracion/bd-config.properties");
            int tipoBD = Integer.parseInt(configuracion.getProperty("tipo"));

            driver = ParametrosUtil.obtenerDriver(tipoBD);
            url = configuracion.getProperty("url");
            usuario = configuracion.getProperty("usuario");
            password = configuracion.getProperty("password");

            Map<String, String> properties = new HashMap<>();
            properties.put("javax.persistence.jdbc.user", usuario);
            properties.put("javax.persistence.jdbc.password", password);
            properties.put("javax.persistence.jdbc.driver", driver);
            properties.put("javax.persistence.jdbc.url", url);
            
            EntityManagerFactory emf = Persistence.createEntityManagerFactory(this.PU, properties);
            em = emf.createEntityManager();
        }
        return em;
    }

    public boolean guardar(T objeto) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(objeto);
            getEntityManager().getTransaction().commit();
            return true;
        } catch (Exception e) {
            LOG.error("ERROR EN EL GUARDADO: " + e.getLocalizedMessage() + " " + e.getMessage());
            return false;
        }

    }

    public boolean modificar(T objeto) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().merge(objeto);
            getEntityManager().getTransaction().commit();
            return true;
        } catch (Exception e) {
            LOG.error("ERROR AL MODIFICAR: " + e.getLocalizedMessage() + " " + e.getMessage());
            return false;
        }

    }

    public boolean eliminar(T objeto) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().remove(objeto);
            getEntityManager().getTransaction().commit();
            return true;
        } catch (Exception e) {
            LOG.error("ERROR AL ELIMINAR: " + e.getLocalizedMessage() + " " + e.getMessage());
            return false;
        }
    }

    public List<T> buscar(String queryJPQL) {
        return this.buscar(queryJPQL, null, -1, -1);
    }

    public List<T> buscar(String queryJPQL, Map<String, Object> parametros) {
        return this.buscar(queryJPQL, parametros, -1, -1);
    }

    public List<T> buscar(String queryJPQL, Map<String, Object> parametros, int offset, int limit) {
        Query query = getEntityManager().createQuery(queryJPQL);

        if (parametros != null) {
            for (Map.Entry<String, Object> entry : parametros.entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
        }

        if (offset != -1) {
            query.setFirstResult(offset);
        }

        if (limit != -1) {
            query.setMaxResults(limit);
        }

        List<T> lista = query.getResultList();

        return lista;
    }

    public void ejecutarQuery(String queryJPQL, Map<String, Object> parametros, int offset, int limit) {
        Query query = getEntityManager().createQuery(queryJPQL);

        if (parametros != null) {
            for (Map.Entry<String, Object> entry : parametros.entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
        }

        if (offset != -1) {
            query.setFirstResult(offset);
        }

        if (limit != -1) {
            query.setMaxResults(limit);
        }

        query.executeUpdate();
    }

    public List<T> buscarTodos() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(clase));
        return getEntityManager().createQuery(cq).getResultList();
    }

    public int contar() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(clase);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }

    public int contarFiltro(String queryJPQL, Map<String, Object> parametros) {
        Query query = getEntityManager().createQuery(queryJPQL);

        if (parametros != null) {
            for (Map.Entry<String, Object> entry : parametros.entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
        }
        return ((Long) query.getSingleResult()).intValue();
    }

    public String buscarUltimo(String queryJPQL, Map<String, Object> parametros) {
        Query query = getEntityManager().createQuery(queryJPQL);

        if (parametros != null) {
            for (Map.Entry<String, Object> entry : parametros.entrySet()) {
                query.setParameter(entry.getKey(), entry.getValue());
            }
        }
        return query.getSingleResult().toString();
    }

    public T buscarPorId(Object id) {
        return getEntityManager().find(clase, id);
    }
}
