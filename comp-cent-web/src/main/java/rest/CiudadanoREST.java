package rest;

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

import negocio.CiudadanoNegocioLocal;

@RequestScoped
@Path("/ciudadano")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CiudadanoREST {
	
	@Inject
	private CiudadanoNegocioLocal cnl;
	
	public CiudadanoREST() throws NamingException {		

	}
	
	@GET
	@Path("/existe-ciudadano/{ci}")
	public Response consultaReservas(@PathParam("ci") String ci) {
		try {
			int numeroCi = Integer.parseInt(ci);
			return Response
					.status(Response.Status.OK)
					.entity(cnl.existeCiudadano(numeroCi))
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
