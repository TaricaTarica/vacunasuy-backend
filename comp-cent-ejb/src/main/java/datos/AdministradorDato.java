package datos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entidades.Administrador;

/**
 * Session Bean implementation class AdministradorDato
 */
@Stateless
@LocalBean
public class AdministradorDato implements AdministradorDatoLocal {
	
	@PersistenceContext(name = "comp-centPersistenceUnit")
	private EntityManager em;

    /**
     * Default constructor. 
     */
    public AdministradorDato() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void guardarAdministrador(Administrador administrador) {
		em.persist(administrador);		
	}

	@Override
	public void editarAdministrador(Administrador administrador) {
		em.merge(administrador);		
	}

	@Override
	public List<Administrador> obtenerAdministradores() {
		return em.createQuery("SELECT r FROM Administrador r", Administrador.class).getResultList();
	}

	@Override
	public Administrador obtenerAdministradorPorCI(int ci) {
		return em.find(Administrador.class, ci);		
	}

}
