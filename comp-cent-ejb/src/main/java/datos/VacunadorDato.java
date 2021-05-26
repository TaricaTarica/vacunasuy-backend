package datos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entidades.Vacunador;

/**
 * Session Bean implementation class VacunadorDato
 */
@Stateless
@LocalBean
public class VacunadorDato implements VacunadorDatoLocal {
	
	@PersistenceContext(name = "comp-centPersistenceUnit")
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public VacunadorDato() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void guardarVacunador(Vacunador vacunador) {
		em.persist(vacunador);		
	}

	@Override
	public void editarVacunador(Vacunador vacunador) {
		em.merge(vacunador);		
	}

	@Override
	public List<Vacunador> obtenerVacunadores() {
		return em.createQuery("SELECT r FROM Vacunador r", Vacunador.class).getResultList();
	}

	@Override
	public Vacunador obteneVacunadorPorCI(int ci) {
		return em.find(Vacunador.class, ci);
	}

}
