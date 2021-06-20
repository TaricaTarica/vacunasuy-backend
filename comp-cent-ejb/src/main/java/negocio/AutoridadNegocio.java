package negocio;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import datos.AutoridadDatoLocal;
import entidades.Autoridad;

/**
 * Session Bean implementation class AutoridadNegocio
 */
@Stateless
@LocalBean
public class AutoridadNegocio implements AutoridadNegocioLocal {

	@EJB
	private AutoridadDatoLocal datoLocal ;
	
    public AutoridadNegocio() {
        // TODO Auto-generated constructor stub
    }
    
    
    public Autoridad obtenerAutoridadPorCi (int ci) {
    	return datoLocal.obtenerAutoridadPorCI(ci);
    }
    

}
