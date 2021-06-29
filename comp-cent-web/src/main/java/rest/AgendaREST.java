package rest;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import datatypes.DTAgenda;
import negocio.AgendaNegocioLocal;

@RequestScoped
@Path("/agendas")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AgendaREST {
	
	@Inject
	private AgendaNegocioLocal an;
	public AgendaREST() throws NamingException {		

	}

	@GET
	public Response getAgenda() {
		ArrayList<DTAgenda> dtAgenda = (ArrayList<DTAgenda>) an.listarAgenda();
		
		 if (!dtAgenda.isEmpty()) {
	        	return Response
			            .status(Response.Status.OK)
			            .entity(dtAgenda)
			            .build();        	
	        } else {
	            return Response
	            		.status(Response.Status.NOT_FOUND)
	            		.build();
	        }
	}
	@GET
	@Path("/activas")
	public Response agendasActivas() {
		ArrayList<DTAgenda> agendas = (ArrayList<DTAgenda>) an.listarAgendasActivas();
		if(!agendas.isEmpty()) {
			return Response
			.status(Response.Status.OK)
            .entity(agendas)
            .build(); 
		}
		else {
			return Response
					.status(Response.Status.OK)
		            .entity("Por el momento no hay agendas activas!")
		            .build(); 
		}
	}
	@GET
	@Path("/count-activas/{id}")
	public Response countAgendasActivasHoy(@PathParam("id")long vacunaId) {
		try {
			return Response
					.status(Response.Status.OK)
		            .entity(an.countAgendasActivasHoy(vacunaId))
		            .build();
		}
		catch(Exception e){
			return Response
					.status(Response.Status.OK)
		            .entity("Error")
		            .build();
		}
	}
	
	@GET
	@Path("/agendas-vacunador/{ci}")
	public Response agendasVacunador(@PathParam("ci")int ci) {
		try {
			return Response.status(Response.Status.OK)
					.entity(an.agendasVacunador(ci))
					.build();
		}
		catch(Exception e) {
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}
