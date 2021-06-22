package rest;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import negocio.VacunaNegocioLocal;

@RequestScoped
@Path("/vacuna")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VacunaREST {
	
	@EJB
	VacunaNegocioLocal vnl;
	
	
	@GET
	@Path("/listar")
	public Response listarVacunas() {
		try {
			return Response
					.status(Response.Status.OK)
					.entity(vnl.obtenerVacunas())
					.build();
		}
		catch(Exception e){
			return Response
					.status(Response.Status.INTERNAL_SERVER_ERROR)
					.build();
		}
	}
	
}
