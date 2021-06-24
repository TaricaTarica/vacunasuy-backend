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
@Path("/vacunatorio")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VacunatorioREST {

	@EJB
	private ReservaNegocioLocal reservaNegocio;
	
	@EJB
	private RegistroVacunaNegocioLocal registroNegocio;
	
	
	
	public VacunatorioREST() throws NamingException {		

	}
	
	@POST
	@Path("/obtenerRegistroVacuna")
	public void altaRegistroVacuna(List<DTRegistroVacuna> regVacuna) {
		
		registroNegocio.altaRegistroVacuna(regVacuna);
	}
	
	@GET
	@Path("/obtenerAgenda")
	public List<DTReservaVacunatorio> obtenerReservasVacunatorio (@QueryParam("id") long id, @QueryParam("fecha") String fecha){
		
		return reservaNegocio.obtenerReservasVacunatorio(LocalDate.parse(fecha), id);
	}
}