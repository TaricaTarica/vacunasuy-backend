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
import datatypes.DTDepartamento;
import datatypes.DTUbicacion;
import negocio.DepartamentoNegocioLocal;

@RequestScoped
@Path("/departamentos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DepartamentosREST {
	
	@Inject
	DepartamentoNegocioLocal dn;	

	public DepartamentosREST() throws NamingException {		

	}
		
	@GET
	public Response getVacunadores() {
		ArrayList<DTDepartamento> dtDepartamentos = (ArrayList<DTDepartamento>) dn.obtenerDepartamentos();
    	//return vacunadoresWs;
    	
        if (!dtDepartamentos.isEmpty()) {
        	return Response
		            .status(Response.Status.OK)
		            .entity(dtDepartamentos)
		            .build();        	
        } else {
            return Response
            		.status(Response.Status.NOT_FOUND)
            		.build();
        }
	}    
        
	@GET
	@Path("/ubicaciones/{departamento}")
	public Response getDepartamentoUbicaciones(@PathParam("departamento") String departamento) {
		ArrayList<DTUbicacion> dTUbicaciones = (ArrayList<DTUbicacion>) dn.obtenerDepartamentoUbicaciones(departamento);
    	
        if (!dTUbicaciones.isEmpty()) {
        	return Response
		            .status(Response.Status.OK)
		            .entity(dTUbicaciones)
		            .build();        	
        } else {
            return Response
            		.status(Response.Status.NOT_FOUND)
            		.build();
        }          
	}	
	
}
