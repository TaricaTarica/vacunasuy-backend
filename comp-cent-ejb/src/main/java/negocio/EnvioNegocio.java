package negocio;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import datatypes.DTEnfermedad;
import datatypes.DTEnvio;
import datos.EnvioDatoLocal;
import entidades.Envio;

/**
 * Session Bean implementation class EnvioNegocio
 */
@Stateless
@LocalBean
public class EnvioNegocio implements EnvioNegocioLocal {
	
	@EJB
	private EnvioDatoLocal envioLocal;

    /**
     * Default constructor. 
     */
    public EnvioNegocio() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
	public List<DTEnvio> listarEnvios(){
    	List<Envio> envios = envioLocal.listarEnvios();
    	List<DTEnvio> lista = new ArrayList<DTEnvio>(); 
    	for(Envio en: envios) {
    		DTEnvio envio = new DTEnvio(en);
    		lista.add(envio);
    	}
    	return lista;
    	
    }
    
    
    

}
