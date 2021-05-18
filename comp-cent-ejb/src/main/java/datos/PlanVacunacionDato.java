package datos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entidades.Enfermedad;
import entidades.PlanVacunacion;

/**
 * Session Bean implementation class PlanVacunacionDato
 */
@Stateless
@LocalBean
public class PlanVacunacionDato implements PlanVacunacionDatoRemote, PlanVacunacionDatoLocal {

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
    public PlanVacunacion obtenerPlanVacunacion(String nombre) {
    	PlanVacunacion planVacunacion = em.find(PlanVacunacion.class, nombre);
    	return planVacunacion;
    }

}
