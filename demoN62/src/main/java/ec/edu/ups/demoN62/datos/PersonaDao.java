package ec.edu.ups.demoN62.datos;

import java.io.Serializable;
import java.util.List;

import ec.edu.ups.demoN62.modelo.Persona;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class PersonaDao implements Serializable{

	private static final long serialVersionUID = 1L;
	@PersistenceContext
	private EntityManager em;
	
	public void insert(Persona persona) {
		em.persist(persona);
	}
	
	public void update(Persona persona) {
		em.merge(persona);
	}
	
	public Persona read(String cedulaPer) {
		Persona p = em.find(Persona.class, cedulaPer);
		return p;
	}
	
	public void delete(String cedulaPer) {
		Persona p = em.find(Persona.class, cedulaPer);
		em.remove(p);
	}
	
	public List<Persona> getAll(){
		String jpql = "SELECT p FROM Persona p";
		Query q = em.createQuery(jpql);
		return q.getResultList();
	}
}


