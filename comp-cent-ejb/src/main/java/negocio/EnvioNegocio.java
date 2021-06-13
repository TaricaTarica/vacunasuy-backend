package negocio;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import datatypes.DTEnvio;
import datos.EnvioDatoLocal;
import entidades.Envio;
import enumeradores.EstadoEnvio;

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
    
    @Override
	public List<DTEnvio> listarEnviosPorSocioLogistico(String cod){
    	List<Envio> envios =  envioLocal.listarEnviosPorSocioLogistico(cod);
		List<DTEnvio> lista = new ArrayList<DTEnvio>();
		for(Envio en: envios) {
    		DTEnvio envio = new DTEnvio(en);
    		lista.add(envio);
    	}
    	return lista;
    }
    
    public void cambiarEstadoEnvio(EstadoEnvio estado, long idEnvio) {
    	Envio envio = envioLocal.obtenerEnvio(idEnvio);
    	envio.setEstado(estado);
    	envioLocal.editarEnvio(envio);
    }

}
