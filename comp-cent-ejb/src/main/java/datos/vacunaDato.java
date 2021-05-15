package datos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
    public void agregarVacuna(Vacuna vac) {
		em.persist(vac);
	}
    
    @Override
	public List<Vacuna> obtenerVacunas(){
    	Query query = em.createQuery("SELECT v FROM Vacuna v");
    	List<Vacuna> resul = query.getResultList();
    	return resul;
    }
    
    public Vacuna obtenerVacuna(long id) {
	    Vacuna vac = new Vacuna();
		vac = em.find(Vacuna.class, id);
		return vac;
    }
    
}
