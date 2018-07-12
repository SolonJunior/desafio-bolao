package br.com.scio.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.scio.model.Usuario;
import br.com.scio.util.HibernateUtil;

/**Classe de persistência para Usuarios.

 * @author Solon Junior

 * @version 1.00

 */

public class UsuarioRepository  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public Usuario login(String name, String password) {
		Usuario result = null;
        try {
            EntityManager em = HibernateUtil
                    .geteEntityManagerFactory().createEntityManager();
            Query query = em.createQuery("select u FROM Usuario u WHERE u.name =:name and u.password =:password");
            query.setParameter("name", name);
            query.setParameter("password", password);
            result = (Usuario) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
	
	public List<Usuario> findUserNotAdmin() {
        List<Usuario> result = null;
        try {
            EntityManager em = HibernateUtil
                    .geteEntityManagerFactory().createEntityManager();
            Query query = em.createQuery("select u FROM Usuario u WHERE u.admin is false");
            result = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
