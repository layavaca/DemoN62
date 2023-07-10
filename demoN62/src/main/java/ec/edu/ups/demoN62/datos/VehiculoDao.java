package ec.edu.ups.demoN62.datos;

import java.io.Serializable;
import java.util.List;

import ec.edu.ups.demoN62.modelo.Vehiculo;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class VehiculoDao implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Vehiculo vehiculo) {
		em.persist(vehiculo);
	}
	
	public void update(Vehiculo vehiculo) {
		em.merge(vehiculo);
	}
	
	public Vehiculo read(String idVeh) {
		Vehiculo v = em.find(Vehiculo.class, idVeh);
		return v;
	}
	
	public void delete(String idVeh) {
		Vehiculo v = em.find(Vehiculo.class, idVeh);
		em.remove(v);
	}
	
	public List<Vehiculo> getAll(){
		String jpql = "SELECT p FROM Vehiculo p";
		Query q = em.createQuery(jpql, Vehiculo.class);
		return q.getResultList();
	}

}
