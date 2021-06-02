package negocio;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import datos.AdministradorDatoLocal;
import entidades.Administrador;

/**
 * Session Bean implementation class AdministradorNegocio
 */
@Stateless
@LocalBean
public class AdministradorNegocio implements AdministradorNegocioRemote, AdministradorNegocioLocal {

	
	
	@EJB
	private AdministradorDatoLocal administradorLocal; 
    /**
     * Default constructor. 
     */
    public AdministradorNegocio() {
        // TODO Auto-generated constructor stub
    }

    
    public Administrador obtenerAdministradorPorCi (int ci) {
    	return administradorLocal.obtenerAdministradorPorCI(ci);
    }
}
