package negocio;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class AutoridadNegocio
 */
@Stateless
@LocalBean
public class AutoridadNegocio implements AutoridadNegocioRemote, AutoridadNegocioLocal {

    /**
     * Default constructor. 
     */
    public AutoridadNegocio() {
        // TODO Auto-generated constructor stub
    }

}
