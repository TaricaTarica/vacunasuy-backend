package rest;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import datatypes.DTRegistroVacuna;
import datatypes.DTReservaVacunatorio;
import negocio.RegistroVacunaNegocioLocal;
import negocio.ReservaNegocioLocal;

@RequestScoped
@Path("/vacunatorioPereira")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VacunatorioPereiraREST {

	@EJB
	private ReservaNegocioLocal reservaNegocio;
	
	@EJB
	private RegistroVacunaNegocioLocal registroNegocio;
	
	
	
	public VacunatorioPereiraREST() throws NamingException {		

	}
	
	@POST
	@Path("/obtenerRegistroVacuna")
	public void altaRegistroVacuna(List<DTRegistroVacuna> regVacuna) {
		for (DTRegistroVacuna v : regVacuna) {
			v.setIdVacunatorio(1);
		}
		registroNegocio.altaRegistroVacuna(regVacuna);
	}
	
	@GET
	@Path("/obtenerAgenda")
	public List<DTReservaVacunatorio> obtenerReservasVacunatorio (@QueryParam("fecha") String fecha){
		
		return reservaNegocio.obtenerReservasVacunatorio(LocalDate.parse(fecha), 1);
	}
}