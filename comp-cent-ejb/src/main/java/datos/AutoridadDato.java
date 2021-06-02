package datos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entidades.Autoridad;

/**
 * Session Bean implementation class AutoridadDato
 */
@Stateless
@LocalBean
public class AutoridadDato implements AutoridadDatoLocal {

	@PersistenceContext(name = "comp-centPersistenceUnit")
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public AutoridadDato() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void guardarAutoridad(Autoridad autoridad) {
		em.persist(autoridad);		
	}

	@Override
	public void editarAutoridad(Autoridad autoridad) {
		em.merge(autoridad);		
	}

	@Override
	public List<Autoridad> obtenerAutoridades() {
		return em.createQuery("SELECT a FROM Autoridad a", Autoridad.class).getResultList();
	}

	@Override
	public Autoridad obtenerAutoridadPorCI(int ci) {
		return em.find(Autoridad.class, ci);	
	}

}
