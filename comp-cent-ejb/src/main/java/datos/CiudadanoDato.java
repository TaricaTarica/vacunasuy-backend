package datos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entidades.Ciudadano;

/**
 * Session Bean implementation class CiudadanoDato
 */
@Stateless
@LocalBean
public class CiudadanoDato implements CiudadanoDatoLocal {

	@PersistenceContext(name = "comp-centPersistenceUnit")
	private EntityManager em;
	
    /**
     * Default constructor. 
     */
    public CiudadanoDato() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void agregarCiudadano(Ciudadano ciudadano) {
		em.persist(ciudadano);
	}
    
    @Override
    public Ciudadano obtenerCiudadano(int ci) {
	    Ciudadano ciudadano = em.find(Ciudadano.class, ci);
		return ciudadano;
    }    
    
    @Override
	public List<Ciudadano> obtenerCiudadanos() {
		return em.createQuery("SELECT a FROM Ciudadano a", Ciudadano.class).getResultList();
	}
    
    @Override
    public void editarCiudadano(Ciudadano ciudadano) {
		em.merge(ciudadano);
			
    }
    @Override
    public boolean existeCiudadano(int ci) {
    	 Ciudadano ciudadano = em.find(Ciudadano.class, ci);
    	 if(ciudadano != null){
    		return true;
    	 }
    	 else {
    		 return false;
    	 }
    }

}
