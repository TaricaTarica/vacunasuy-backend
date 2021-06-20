package soap;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import datatypes.DTEnvio;
import datatypes.DTRegistroVacuna;
import datatypes.DTReservaVacunatorio;
import enumeradores.EstadoEnvio;
import negocio.EnvioNegocioLocal;
import negocio.RegistroVacunaNegocioLocal;
import negocio.ReservaNegocioLocal;

@WebService
public class EnviosSOAP {

	@Inject
	EnvioNegocioLocal enl;	
	@Inject
	RegistroVacunaNegocioLocal registroNegocio;
	@Inject
	ReservaNegocioLocal reservaNegocio;
	
	@WebMethod 
	public void altaRegistroVacuna(DTRegistroVacuna regVacuna) {
		registroNegocio.altaRegistroVacuna(regVacuna);
	}
	
	@WebMethod 
	public List<DTReservaVacunatorio> obtenerReservasVacunatorio (String fecha, long idVac){
		return reservaNegocio.obtenerReservasVacunatorio(LocalDate.parse(fecha), idVac);
	}

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
			System.out.println(estadoEnvio);
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
