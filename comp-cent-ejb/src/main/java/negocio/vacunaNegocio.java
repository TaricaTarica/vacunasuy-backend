package negocio;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.vacunaDato;

/**
 * Session Bean implementation class vacunaNegocio
 */
@Stateless
@LocalBean
public class vacunaNegocio implements vacunaNegocioRemote, vacunaNegocioLocal {

	@SuppressWarnings("unused")
	private static final long serialVersionUID = 1L;
	
	@Inject
	private vacunaDato puenteDatos;
	
    /**
     * Default constructor. 
     */
    public vacunaNegocio() {
        // TODO Auto-generated constructor stub
    }
    
    public void addVacuna() {
    	
    }

}
