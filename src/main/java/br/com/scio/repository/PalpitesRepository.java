package br.com.scio.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.scio.model.Palpites;
import br.com.scio.util.HibernateUtil;

/**Classe de persistência para Palpites.

 * @author Solon Junior

 * @version 1.00

 */
public class PalpitesRepository implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	 public void saveOrUpdate(Palpites palpites) {
	        EntityManager em = HibernateUtil.geteEntityManagerFactory().createEntityManager();
	        try {
	            em.getTransaction().begin();
	            if (palpites.getId() == null)
	                em.persist(palpites);
	            else
	                em.merge(palpites);
	            em.getTransaction().commit();
	        } catch (Exception e) {
	            em.getTransaction().rollback();
	        }
	    }
	    public void delete(Palpites palpites) {
	        EntityManager em = HibernateUtil
	                .geteEntityManagerFactory().createEntityManager();
	        try {
	            em.getTransaction().begin();
	            Palpites p = em.find(Palpites.class, palpites.getId());
	            em.remove(p);
	            em.getTransaction().commit();
	        } catch (Exception e) {
	            em.getTransaction().rollback();
	        }
	    }
	    public List<Palpites> findAll() {
	        List<Palpites> result = null;
	        try {
	            EntityManager em = HibernateUtil
	                    .geteEntityManagerFactory().createEntityManager();
	            Query query = em.createQuery("FROM Palpites");
	            result = query.getResultList();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return result;
	    }
}
