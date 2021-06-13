package datos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


import entidades.SocioLogistico;

/**
 * Session Bean implementation class SocioLogisticoDato
 */
@Stateless
@LocalBean
public class SocioLogisticoDato implements SocioLogisticoDatoLocal {

	@PersistenceContext(name = "comp-centPersistenceUnit")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public SocioLogisticoDato() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public void agregarSocioLogistico(SocioLogistico socio) {
    	em.persist(socio);
	}
	
    @Override
	public void editarSocioLogistico(SocioLogistico socio) {
		em.merge(socio);
	}
	
    @Override
	public void eliminarSocioLosgistico(SocioLogistico socio) {
		em.remove(socio);
	}
	
    @Override
	public Boolean existeSocioLogistico(String codigo) {
		return em.createQuery("select sl from SocioLogistico sl where sl.codigo =:codigo")
			.setParameter("codigo", codigo).getResultList().size()>0;
	}
	
    @Override
	public SocioLogistico obtenerSocioLogistico(String codigo) {
    	return em.createQuery("select sl from SocioLogistico sl where sl.codigo = :codigo", SocioLogistico.class)
    		.setParameter("codigo", codigo).getSingleResult();
	}

    @Override
	public SocioLogistico obtenerSocioLogisticoPorId(long id) {
		return em.createQuery("select sl from SocioLogistico sl where sl.id = :id", SocioLogistico.class)
			.setParameter("id", id).getSingleResult();
	}
    
    @Override
	public List<SocioLogistico> listarSocioLogistico() {
    	ArrayList<SocioLogistico> lista = new ArrayList<SocioLogistico>();
		for (Object obj : em.createQuery("Select e from SocioLogistico e").getResultList()) {
			SocioLogistico e = (SocioLogistico) obj;
			lista.add(e);
		}

		return lista;
    }
    
    
}
