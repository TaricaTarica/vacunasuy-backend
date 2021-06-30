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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import datatypes.DTRegistroVacuna;
import datatypes.DTReservaVacunatorio;
import negocio.RegistroVacunaNegocioLocal;
import negocio.ReservaNegocioLocal;
import negocio.VacunatorioGeomNegocioLocal;

@RequestScoped
@Path("/vacunatorio")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VacunatorioREST {

	@EJB
	private ReservaNegocioLocal reservaNegocio;
	
	@EJB
	private RegistroVacunaNegocioLocal registroNegocio;
	
	@EJB
	private VacunatorioGeomNegocioLocal vgnl;
	
	
	
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
	
	@GET
	@Path("/cercanos/{lat}/{lon}")
	public Response vacunatoriosCercanos(@PathParam("lat") String lat, @PathParam("lon") String lon){
		try {
			return Response.status(Status.OK).entity(vgnl.vacunatoriosCercanos(lat, lon)).build();
		}
		catch(Exception e) {
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
	}
}