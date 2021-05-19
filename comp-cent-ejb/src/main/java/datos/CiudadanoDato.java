package datos;

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
public class CiudadanoDato implements CiudadanoDatoRemote, CiudadanoDatoLocal {

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
    
    

}
