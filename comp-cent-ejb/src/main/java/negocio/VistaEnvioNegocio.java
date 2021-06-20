package negocio;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import datatypes.DTVistaEnvio;
import datos.EnvioDatoLocal;

/**
 * Session Bean implementation class VistaEnvioNegocio
 */
@Stateless
@LocalBean
public class VistaEnvioNegocio implements VistaEnvioNegocioLocal {
	
	
	@EJB
	private EnvioDatoLocal envioLocal;
	
	

    /**
     * Default constructor. 
     */
    public VistaEnvioNegocio() {
        // TODO Auto-generated constructor stub
    }
    
    
    
    @Override
	public List<DTVistaEnvio> listarEnvios(){
    	List<DTVistaEnvio> envios = new ArrayList<DTVistaEnvio>();
    	envios = envioLocal.ListarEnviosVista();
    	return envios;
    }

}
