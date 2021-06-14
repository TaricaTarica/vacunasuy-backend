package datos;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entidades.Enfermedad;

/**
 * Session Bean implementation class EnfermedadDato
 */
@Stateless
@LocalBean
public class EnfermedadDato implements EnfermedadDatoLocal {

	@PersistenceContext(name = "comp-centPersistenceUnit")
	private EntityManager em;

		
	public EnfermedadDato() {
		
	 
    }
	
	@Override
	public void agregarEnfermedad(Enfermedad enfermedad) {
			em.persist(enfermedad);
				
	}
		
	@Override
	public List<Enfermedad> listarEnfermedades (){
		ArrayList<Enfermedad> lista = new ArrayList<Enfermedad>();
		for (Object obj : em.createQuery("Select e from Enfermedad e").getResultList()) {
			Enfermedad e = (Enfermedad) obj;
			lista.add(e);
		}

		return lista;
	}
	
	@Override
	public Enfermedad buscarEnfermedad (String nombre) {
		Enfermedad enfermedad =(Enfermedad) em.createQuery("Select e from Enfermedad e where e.nombre = :nombre").setParameter("nombre", nombre).getSingleResult();	
		return enfermedad;	
		    	
	}
	
	
	@Override
	public Boolean existeEnfermedad(String nombre) {
		Boolean existe = (em.createQuery("Select e from Enfermedad e where e.nombre = :nombre").setParameter("nombre", nombre).getResultList().size() > 0);	
		return existe;

	}

	@Override
    public void eliminarEnfermedad(Enfermedad enfermedad) {
		em.remove(enfermedad);
	}
	
	@Override
	public Enfermedad obtenerEnfermedadPorId(long id) {
		Enfermedad enf = em.find(Enfermedad.class, id);
		return enf;
	}
	
	@Override
	public void editarEnfermedad(Enfermedad enf) {
    	em.merge(enf);
    }
}
