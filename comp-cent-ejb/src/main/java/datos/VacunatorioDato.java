package datos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entidades.Vacunatorio;

/**
 * Session Bean implementation class VacunatorioDato
 */
@Stateless
@LocalBean
public class VacunatorioDato implements VacunatorioDatoRemote, VacunatorioDatoLocal {

	@PersistenceContext(name = "comp-centPersistenceUnit")
	private EntityManager em;
    /**
     * Default constructor. 
     */
    public VacunatorioDato() {
        // TODO Auto-generated constructor stub
    }

	public void agregarVacunatorio(Vacunatorio vacunatorio){
		em.persist(vacunatorio);
	}
	
	public List<Vacunatorio> listarVacunatorio(){
		List<Vacunatorio> lista = new ArrayList<Vacunatorio>();
		for (Object obj : em.createQuery("Select v from Vacunatorio v").getResultList()) {
			Vacunatorio v = (Vacunatorio) obj;
			lista.add(v);
		}
		return lista;
	}
	public Vacunatorio obtenerVacunatorio(long id) {
		return em.find(Vacunatorio.class, id);
	}
	
	public Vacunatorio obtenerVacunatorioPorCodigo( String codigo) {
		Vacunatorio vacunatorio = (em.createQuery("Select p from Vacunatorio p where p.codigo = :codigo", Vacunatorio.class).setParameter("codigo", codigo).getSingleResult());
    	return vacunatorio;
	}
	public Boolean existeVacunatorio(String codigo) {
		Boolean existe = (em.createQuery("Select p from Vacunatorio p where p.codigo = :codigo").setParameter("codigo", codigo).getResultList().size() > 0);	
		return existe;


	}

	@Override
	public void editarVacunatorio(Vacunatorio vac) {
		em.merge(vac);
		
	}

	@Override
	public void eliminarVacunatorio(Vacunatorio vac) {
		em.remove(vac);
	}
}
