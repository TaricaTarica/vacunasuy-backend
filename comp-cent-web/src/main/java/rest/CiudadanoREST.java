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

import com.google.gson.Gson;

import datatypes.DTCiudadano;
import datatypes.DTNotificacionToken;
import negocio.CiudadanoNegocioLocal;
import negocio.NotificacionTokenNegocioLocal;
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
	
	@Inject
	private NotificacionTokenNegocioLocal notificacionTokenNegocio;	
	
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
				if(c.getSegundoNombre().isEmpty()) {
					ciudadano.setSegundoNombre(" ");
				}
				else {
					ciudadano.setSegundoNombre(c.getSegundoNombre());
				}
				ciudadano.setPrimerApellido(c.getPrimerApellido());
				if(c.getSegundoApellido().isEmpty()) {
					ciudadano.setSegundoApellido(" ");
				}
				else {
					ciudadano.setSegundoApellido(c.getSegundoApellido());
				}
				ciudadano.setFnac(personaAgesic.getFnac());
				ciudadano.setTipoCiudadano(personaAgesic.getTipo());
				cnl.agregarCiudadano(ciudadano);
				return Response
		           		 .status(Response.Status.OK)
		           		 .entity(new Gson().toJson("INFO: Creado"))
		           		 .build();
		}
		catch(Exception e){
			return Response
	           		 .status(Response.Status.BAD_REQUEST)
	           		 .entity(new Gson().toJson("ERROR: creando el ciudadano"))
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
	@GET
	@Path("/perfil/{ci}")
	public Response perfilCiudadano(@PathParam("ci") String ci) {
		try {
			int numeroCi = Integer.parseInt(ci);
			
			ServicioAgesic servicioAgesic = new ServicioAgesicService().getServicioAgesicPort();
			DtPersona perfilCiudadano = servicioAgesic.obtenerPersona(numeroCi);
			
			return Response
					.status(Response.Status.OK)
					.entity(perfilCiudadano)
					.build();
		}
		catch(NumberFormatException ex){
			return Response
	           		 .status(Response.Status.BAD_REQUEST)
	           		 .entity("Ha ocurrido un error procesando la cedula")
	           		 .build();
		}
	}
	
	@POST
	@Path("/notificacion-token")
	public Response setNotificacionToken(DTNotificacionToken notificacionToken) {
		try {
			notificacionTokenNegocio.saveUserToken(notificacionToken);
			return Response
					.status(Response.Status.OK)
					.entity(notificacionToken)
					.build();			
		}
		catch(Exception ex){
			return Response
	           		 .status(Response.Status.BAD_REQUEST)
	           		 .entity("Ha ocurrido un error" + ex.getMessage())
	           		 .build();
		}		
	}
	
}
