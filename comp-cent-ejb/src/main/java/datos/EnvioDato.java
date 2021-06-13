package datos;

import java.util.ArrayList;
import java.util.List;


import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entidades.Enfermedad;
import entidades.Envio;

/**
 * Session Bean implementation class EnvioDato
 */
@Stateless
@LocalBean
public class EnvioDato implements EnvioDatoLocal {

	

	@PersistenceContext(name = "comp-centPersistenceUnit")
	private EntityManager em;
	
	
    /**
     * Default constructor. 
     */
    public EnvioDato() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public void guardarEnvio(Envio envio) {
    	em.persist(envio);
    }

	@Override
	public void editarEnvio(Envio envio) {
		em.merge(envio);
	}
	
	
	@Override
	public List<Envio> listarEnvios(){
		ArrayList<Envio> lista = new ArrayList<Envio>();
		for (Object obj : em.createQuery("Select e from Envio e").getResultList()) {
			Envio e = (Envio) obj;
			lista.add(e);
		}

		return lista;
	}

}
