package soap;

import java.util.Collection;
import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import datatypes.DTEnvio;
import enumeradores.EstadoEnvio;
import negocio.EnvioNegocioLocal;

@WebService
public class EnviosSOAP {

	@Inject
	EnvioNegocioLocal enl;	

	@WebMethod 
	public void cambiarEstadoEnvio(String codigoSocioLogistico, String estado, long codigoEnvio) {	
		EstadoEnvio estadoEnvio = EstadoEnvio.Entransito;
		try {
			switch(estado) {
			  case "Entransito":
				  estadoEnvio = EstadoEnvio.Entransito;
				  break;
			  case "Entregado":
				  estadoEnvio = EstadoEnvio.Entregado;
				  break;
			}			
			enl.cambiarEstadoEnvio(estadoEnvio, codigoEnvio);
		} catch (Exception e) {
			 System.out.println("Error camiar estado");
		}	    	
	}
	
	@WebMethod
    public Collection<DTEnvio> obtenerEnviosPendientesSocioLogistico(String codigoSocioLogistico){
    	return enl.listarEnviosPorSocioLogistico(codigoSocioLogistico);
    }
	
}
