package datos;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entidades.PlanVacunacion;

/**
 * Session Bean implementation class PlanVacunacionDato
 */
@Stateless
@LocalBean
public class PlanVacunacionDato implements PlanVacunacionDatoLocal {

	@PersistenceContext(name = "comp-centPersistenceUnit")
	private EntityManager em;
	
    public PlanVacunacionDato() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public void agregarPlanVacunacion(PlanVacunacion plan) {
			em.persist(plan);
				
	}
    
    @Override
    public void editarPlanVacunacion(PlanVacunacion plan) {
		em.merge(plan);
			
    }
    
    @Override
    public void eliminarPlanVacunacion(PlanVacunacion plan) {
		em.remove(plan);
			
    }
    
    @Override
	public List<PlanVacunacion> listarPlanesDeVacunacion (){
		ArrayList<PlanVacunacion> lista = new ArrayList<PlanVacunacion>();
		for (Object obj : em.createQuery("Select p from PlanVacunacion p").getResultList()) {
			PlanVacunacion p = (PlanVacunacion) obj;
			lista.add(p);
		}

		return lista;
	}
    
    @Override
	public Boolean existePlanVacunacion(String nombre) {
		Boolean existe = (em.createQuery("Select p from PlanVacunacion p where p.nombre = :nombre").setParameter("nombre", nombre).getResultList().size() > 0);	
		return existe;

	}
    
    @Override
    public PlanVacunacion obtenerPlanVacunacionPorId(long id) {
    	PlanVacunacion planVacunacion = em.find(PlanVacunacion.class, id);
		return planVacunacion;

	}
    
    @Override
    public PlanVacunacion obtenerPlanVacunacion(String nombre) {
    	PlanVacunacion planVacunacion = (em.createQuery("Select p from PlanVacunacion p where p.nombre = :nombre", PlanVacunacion.class).setParameter("nombre", nombre).getSingleResult());
    	return planVacunacion;
    }
    
    @Override
    public List<PlanVacunacion> obtenerPlanesVacunacionObjetivoEdad(String poblacionObjetivo, String fnac){
    	List<PlanVacunacion> planesVacunacion = this.listarPlanesDeVacunacion();
    	List<PlanVacunacion> retorno = new ArrayList<>();
    	
    	int edad = Period.between(LocalDate.parse(fnac), LocalDate.now()).getYears();
    	
    	for(PlanVacunacion p: planesVacunacion) {
    		if(
    			p.getPoblacionObjetivo().toString().equals(poblacionObjetivo) &&
    			(p.getEdadMinima() < edad && edad < p.getEdadMaxima())
    		){
    			retorno.add(p);
    		}
    	}
    	return retorno;
    }

}
