package rest;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import datatypes.DTCertificado;
import negocio.RegistroVacunaNegocioLocal;

@RequestScoped
@Path("/certificado")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class RegistroVacunaREST {
	
	@EJB
	RegistroVacunaNegocioLocal regVacLocal;	

	public RegistroVacunaREST() throws NamingException {		

	}
	
	@GET
	@Path("/ciudadano/{ci}")
	public Response getCertificadosPorCi(@PathParam("ci") String ci) {
		if (ci != null && !ci.equals("")) {
			List<DTCertificado> listDTCert = regVacLocal.obtenerCertificados(ci);
	    	
	        if (!listDTCert.isEmpty()) {
	        	return Response
			            .status(Response.Status.OK)
			            .entity(listDTCert)
			            .build();        	
	        } else {
	            return Response
	            		.status(Response.Status.NOT_FOUND)
	            		.entity("No se encontraron certificados para la ci.")
	            		.build();
	        } 
		} else {
			return Response
            		.status(Response.Status.BAD_REQUEST)
            		.entity("Falta paramentro ci.")
            		.build();			
		}
	}
	@GET
	@Path("count-registros/{id}")
	public Response countVacunadosHoy(@PathParam("id") long vacunaId) {
		try {
			return Response
		            .status(Response.Status.OK)
		            .entity(regVacLocal.countVacunadosHoy(vacunaId))
		            .build(); 
		}
		catch(Exception e) {
			return Response
            		.status(Response.Status.BAD_REQUEST)
            		.entity("Error")
            		.build();
		}
	}
	
}
