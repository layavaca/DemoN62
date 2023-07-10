package ec.edu.ups.demoN62.datos;

import java.io.Serializable;
import java.util.List;

import ec.edu.ups.demoN62.modelo.TickecDet;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class TickecDetDao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext
	private EntityManager em;
	
	public void insert(TickecDet tickecDet) {
		em.persist(tickecDet);
	}
	
	public void update(TickecDet tickecDet) {
		em.merge(tickecDet);
	}
	
	public TickecDet read(int idTiDet) {
		TickecDet p = em.find(TickecDet.class, idTiDet);
		return p;
	}
	
	public void delete(int idTiDet) {
		TickecDet p = em.find(TickecDet.class, idTiDet);
		em.remove(p);
	}
	
	public List<TickecDet> getAll(){
		String jpql = "SELECT p FROM TickecDet p";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}

}
