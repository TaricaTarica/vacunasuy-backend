package datos;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entidades.Usuario;

/**
 * Session Bean implementation class UsuarioDato
 */
@Stateless
@LocalBean
public class UsuarioDato implements UsuarioDatoLocal {

	@PersistenceContext(name = "comp-centPersistenceUnit")
	private EntityManager em;
    public UsuarioDato() {
        // TODO Auto-generated constructor stub
    }

    @Override
	public Boolean existeUsuario(int ci) {
		Usuario user = em.find(Usuario.class, ci);	
		if (user == null)
			return false;
		else
			return true;
		
	}
    
    @Override
	public Usuario obtenerUsuarioPorCI(int ci) {
		return em.find(Usuario.class, ci);	
	}
    
    @Override
    public void eliminarUsuario (int ci) {
    	
    	em.remove(em.find(Usuario.class, ci));
    }
    
    @Override
	public void editarUsuario(Usuario usuario) {
		em.merge(usuario);		
	}
}
