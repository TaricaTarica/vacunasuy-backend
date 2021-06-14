package rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import datatypes.DTCiudadano;
import negocio.CiudadanoNegocioLocal;
import servicios.DtPersona;
import servicios.ServicioAgesic;
import servicios.ServicioAgesicService;

@RequestScoped
@Path("/ciudadano")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CiudadanoREST {
	
	@Inject
	private CiudadanoNegocioLocal cnl;
	
	public CiudadanoREST() throws NamingException {		

	}
	
	@POST
	public Response agregarCiudadano(DTCiudadano c) {
		try {
				ServicioAgesic servicioAgesic = new ServicioAgesicService().getServicioAgesicPort();
				DtPersona personaAgesic = servicioAgesic.obtenerPersona(c.getCi());
				
				DTCiudadano ciudadano = new DTCiudadano();
				ciudadano.setCi(c.getCi());
				ciudadano.setEmail(c.getEmail());
				ciudadano.setPrimerNombre(c.getPrimerNombre());
				ciudadano.setSegundoNombre(c.getSegundoNombre());
				ciudadano.setPrimerApellido(c.getPrimerApellido());
				ciudadano.setSegundoApellido(c.getSegundoApellido());
				ciudadano.setFnac(personaAgesic.getFnac());
				ciudadano.setTipoCiudadano(personaAgesic.getTipo());
				cnl.agregarCiudadano(ciudadano);
				return Response
		           		 .status(Response.Status.BAD_REQUEST)
		           		 .entity("Creado")
		           		 .build();
		}
		catch(Exception e){
			return Response
	           		 .status(Response.Status.BAD_REQUEST)
	           		 .entity("Error creando el ciudadano")
	           		 .build();
		}
	}
	
	@GET
	@Path("/existe-ciudadano/{ci}")
	public Response existeCiudadano(@PathParam("ci") String ci) {
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
