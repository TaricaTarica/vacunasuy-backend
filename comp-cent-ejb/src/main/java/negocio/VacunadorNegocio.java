package negocio;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class VacunadorNegocio
 */
@Stateless
@LocalBean
public class VacunadorNegocio implements VacunadorNegocioRemote, VacunadorNegocioLocal {

    /**
     * Default constructor. 
     */
    public VacunadorNegocio() {
        // TODO Auto-generated constructor stub
    }

}
