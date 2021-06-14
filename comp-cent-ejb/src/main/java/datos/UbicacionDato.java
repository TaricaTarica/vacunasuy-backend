package datos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entidades.Ubicacion;

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
	public void actualizarVacunatorio(Ubicacion ubi) {
		em.merge(ubi);
	}
}
