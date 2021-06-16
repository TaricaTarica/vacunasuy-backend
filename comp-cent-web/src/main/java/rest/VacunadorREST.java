package rest;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import negocio.VacunadorNegocioLocal;

@RequestScoped
@Path("/vacunador")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VacunadorREST {

	@EJB
	VacunadorNegocioLocal vnl;
	
	@GET
	@Path("/es-vacunador/{ci}")
	public Response existeCiudadano(@PathParam("ci") String ci) {
		try {
			int numeroCi = Integer.parseInt(ci);
			return Response
					.status(Response.Status.OK)
					.entity(vnl.esVacunador(numeroCi))
					.build();
		}
		catch(NumberFormatException ex){
			return Response
	           		 .status(Response.Status.BAD_REQUEST)
	           		 .entity("Ha ocurrido un error procesando la cedula")
	           		 .build();
		}
	}
}
