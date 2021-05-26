package negocio;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class AdministradorNegocio
 */
@Stateless
@LocalBean
public class AdministradorNegocio implements AdministradorNegocioRemote, AdministradorNegocioLocal {

    /**
     * Default constructor. 
     */
    public AdministradorNegocio() {
        // TODO Auto-generated constructor stub
    }

}
