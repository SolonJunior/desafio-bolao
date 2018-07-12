package br.com.scio.repository;

import java.io.Serializable;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.scio.model.Partida;
import br.com.scio.util.HibernateUtil;

/**Classe de persistência para Partidas.

 * @author Solon Junior

 * @version 1.00

 */
public class PartidaRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	 public void saveOrUpdate(Partida partida) {
	        EntityManager em = HibernateUtil.geteEntityManagerFactory().createEntityManager();
	        try {
	            em.getTransaction().begin();
	            if (partida.getId() == null)
	                em.persist(partida);
	            else
	                em.merge(partida);
	            em.getTransaction().commit();
	        } catch (Exception e) {
	            em.getTransaction().rollback();
	        }
	    }
	    public void delete(Partida partida) {
	        EntityManager em = HibernateUtil
	                .geteEntityManagerFactory().createEntityManager();
	        try {
	            em.getTransaction().begin();
	            Partida p = em.find(Partida.class, partida.getId());
	            em.remove(p);
	            em.getTransaction().commit();
	        } catch (Exception e) {
	            em.getTransaction().rollback();
	        }
	    }
	    public List<Partida> findAll() {
	        List<Partida> result = null;
	        try {
	            EntityManager em = HibernateUtil
	                    .geteEntityManagerFactory().createEntityManager();
	            Query query = em.createQuery("FROM Partida");
	            result = query.getResultList();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return result;
	    }
}
