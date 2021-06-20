package datos;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entidades.Lote;

/**
 * Session Bean implementation class LoteDato
 */
@Stateless
@LocalBean
public class LoteDato implements LoteDatoLocal {

	@PersistenceContext(name = "comp-centPersistenceUnit")
	private EntityManager em;
	
    public LoteDato() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public void agregarLote(Lote lote) {
			em.persist(lote);
				
	}
		
	@Override
	public List<Lote> listarLotes (){
		ArrayList<Lote> lista = new ArrayList<Lote>();
		for (Object obj : em.createQuery("Select l from Lote l").getResultList()) {
			Lote l = (Lote) obj;
			lista.add(l);
		}

		return lista;
	}

	
	@Override
	public Lote obtenerLote (String nombre) {
		Lote lote =(Lote) em.createQuery("Select l from Lote l where l.nombre = :nombre").setParameter("nombre", nombre).getSingleResult();	
		return lote;	
		    	
	}
	
	
	
	@Override
	public Boolean existeLote(String nombre) {
		Boolean existe = (em.createQuery("Select l from Lote l where l.nombre = :nombre").setParameter("nombre", nombre).getResultList().size() > 0);	
		return existe;

	}

	@Override
    public void eliminarLote(Lote lote) {
		em.remove(lote);
	}
	
	 @Override
	    public Lote obtenerLotePorId(long id) {
	    	Lote lote = em.find(Lote.class, id);
			return lote;

		}
	 
	 @Override
	    public void editarLote(Lote lote) {
			em.merge(lote);
				
	    }

}
