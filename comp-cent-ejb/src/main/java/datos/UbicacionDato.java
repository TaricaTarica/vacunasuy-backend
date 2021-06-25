package datos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entidades.Ubicacion;
import entidades.VacunatorioVacunador;

/**
 * Session Bean implementation class UbicacionDato
 */
@Stateless
@LocalBean
public class UbicacionDato implements UbicacionDatoLocal {

	@PersistenceContext(name = "comp-centPersistenceUnit")
	private EntityManager em;
	
    public UbicacionDato() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public Ubicacion obtenerUbicacionPorId(long id) {
    	Ubicacion ubicacion = em.find(Ubicacion.class, id);
		return ubicacion;

	}
    
    @Override
    public Ubicacion obtenerUbicacionVacunatorio(long id) {
    	return em.createQuery("Select u from Ubicacion u where u.vacunatorio.id = :id", Ubicacion.class)
				.setParameter("id", id).getSingleResult();

	}

	@Override
	public void actualizarVacunatorio(Ubicacion ubi) {
		em.merge(ubi);
	}
	
	@Override
	public void eliminarVacunatorio(long id) {
		
		em.createNativeQuery("UPDATE public.ubicacion SET vacunatorio_id=null WHERE vacunatorio_id = :id").setParameter("id", id).executeUpdate();
	}
	
}
