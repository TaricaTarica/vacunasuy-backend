package datos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entidades.Vacuna;

/**
 * Session Bean implementation class vacunaDato
 */
@Stateless
@LocalBean
public class vacunaDato implements vacunaDatoRemote, vacunaDatoLocal {

	
	
	@PersistenceContext(name = "comp-centPersistenceUnit")
	private EntityManager em;
	
	
    /**
     * Default constructor. 
     */
    public vacunaDato() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void addVacuna(Vacuna vac) {
		em.persist(vac);
	}

}
