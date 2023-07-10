package ec.edu.ups.demoN62.datos;

import java.io.Serializable;
import java.util.List;

import ec.edu.ups.demoN62.modelo.TickecCab;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;


@Stateless
public class TickecCabDao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;
	
	public void insert(TickecCab tickecCab) {
		em.persist(tickecCab);
	}
	
	public void update(TickecCab tickecCab) {
		em.merge(tickecCab);
	}
	
	public TickecCab read(int idTiCab) {
		TickecCab p = em.find(TickecCab.class, idTiCab);
		return p;
	}
	
	public void delete(int idTiCab) {
		TickecCab p = em.find(TickecCab.class, idTiCab);
		em.remove(p);
	}
	
	public List<TickecCab> getAll(){
		String jpql = "SELECT p FROM TickecCab p";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}

}
