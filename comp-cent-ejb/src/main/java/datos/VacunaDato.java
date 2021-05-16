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
public class VacunaDato implements VacunaDatoRemote, VacunaDatoLocal {

	
	
	@PersistenceContext(name = "comp-centPersistenceUnit")
	private EntityManager em;
	
	
    /**
     * Default constructor. 
     */
    public VacunaDato() {
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
    
    public void agregarVacunas() {
    	
    	Vacuna vac1 = new Vacuna("Vacuna1","XC1","LosPepes");
    	Vacuna vac2 = new Vacuna("Vacuna2","JK2","LosPedros");
    	Vacuna vac3 = new Vacuna("Vacuna3","PL4","LosRodo");
    	Vacuna vac4 = new Vacuna("Vacuna4","JK5","LosClavos");
    	Vacuna vac5 = new Vacuna("Vacuna5","YT7","LosMemes");
    	em.persist(vac1);
    	em.persist(vac2);
    	em.persist(vac3);
    	em.persist(vac4);
    	em.persist(vac5);
    
    }
    
}