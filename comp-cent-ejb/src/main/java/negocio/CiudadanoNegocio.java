package negocio;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import datatypes.DTCiudadano;
import datos.CiudadanoDatoLocal;
import entidades.Ciudadano;



/**
 * Session Bean implementation class CiudadanoNegocio
 */
@Stateless
@LocalBean
public class CiudadanoNegocio implements CiudadanoNegocioLocal {

	@EJB
	private CiudadanoDatoLocal cdl;
	
    /**
     * Default constructor. 
     */
    public CiudadanoNegocio() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void agregarCiudadano(DTCiudadano dtCiudadano){
    	
    	
    	Ciudadano ciudadano = new Ciudadano(dtCiudadano);
    	this.cdl.agregarCiudadano(ciudadano);
    }
    
    @Override
    public DTCiudadano obtenerCiudadano(int ci) {
    	Ciudadano ciudadano = cdl.obtenerCiudadano(ci);
    	if(ciudadano != null) {
    		DTCiudadano dtCiudadano = new DTCiudadano(ciudadano);
        	return dtCiudadano;
    	}
    	else {
    		return null;
    	}
    	
    }
    
    @Override
    public boolean existeCiudadano(int ci) {
    	return cdl.existeCiudadano(ci);
    }

}
