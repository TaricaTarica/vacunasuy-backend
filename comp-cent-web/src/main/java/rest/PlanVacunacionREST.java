package rest;

import java.util.ArrayList;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import datatypes.DTPlanVacunacion;
import negocio.PlanVacunacionNegocioLocal;

@RequestScoped
@Path("/planvacunacion")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PlanVacunacionREST {
	
	@Inject
	PlanVacunacionNegocioLocal pn;
	
	public PlanVacunacionREST() throws NamingException {		

	}
	
	@GET
	public Response getPlanVacunacion() {
		ArrayList<DTPlanVacunacion> dtPlanVacunacion = (ArrayList<DTPlanVacunacion>) pn.listarPlanesDeVacunacion();
		
		 if (!dtPlanVacunacion.isEmpty()) {
	        	return Response
			            .status(Response.Status.OK)
			            .entity(dtPlanVacunacion)
			            .build();        	
	        } else {
	            return Response
	            		.status(Response.Status.NOT_FOUND)
	            		.build();
	        }
		
	}
}
