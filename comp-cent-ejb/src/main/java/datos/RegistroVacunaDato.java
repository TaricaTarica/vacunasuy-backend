package datos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entidades.RegistroVacuna;

/**
 * Session Bean implementation class RegistroVacunaDato
 */
@Stateless
@LocalBean
public class RegistroVacunaDato implements RegistroVacunaDatoLocal {

	@PersistenceContext(name = "comp-centPersistenceUnit")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public RegistroVacunaDato() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void agregarRegistroVacuna(RegistroVacuna regVac) {
		em.persist(regVac);
	}
    
    @Override
	public List<RegistroVacuna> obtenerRegistroPorCi (int ci) {
    	
		List<RegistroVacuna> listRegVac = new ArrayList<RegistroVacuna>();
		for	(RegistroVacuna rv :em.createQuery("Select rv from RegistroVacuna rv where rv.ciudadano.ci = :ci",RegistroVacuna.class).setParameter("ci", ci).getResultList()) {
			listRegVac.add(rv);
		}
		return listRegVac;	
		    	
	}
    
    
    @Override
	public List<RegistroVacuna> obtenerRegistro(){
    	ArrayList<RegistroVacuna> lista = new ArrayList<RegistroVacuna>();
    	for(Object obj : em.createQuery("Select r from RegistroVacuna r").getResultList()) {
    		RegistroVacuna r = (RegistroVacuna) obj;
    		lista.add(r);
    	}
    	
    	return lista;
    }
}
