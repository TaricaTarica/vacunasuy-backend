package negocio;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import datos.VacunadorDatoLocal;
import entidades.Vacunador;

/**
 * Session Bean implementation class VacunadorNegocio
 */
@Stateless
@LocalBean
public class VacunadorNegocio implements VacunadorNegocioLocal {

	@EJB
	VacunadorDatoLocal vdl;
	
    /**
     * Default constructor. 
     */
    public VacunadorNegocio() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public boolean esVacunador(int ci) {
    	Vacunador vacunador = vdl.obteneVacunadorPorCI(ci);
    	if(vacunador == null) {
    		return false;
    	}
    	else {
    		return true;
    	}
    }

}
