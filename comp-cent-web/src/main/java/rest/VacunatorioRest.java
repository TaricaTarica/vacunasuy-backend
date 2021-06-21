package rest;


import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import negocio.VacunatorioNegocioLocal;


@RequestScoped
@Path("/vacunatorio")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class VacunatorioRest {
	
	@EJB
	VacunatorioNegocioLocal vnl;

	public VacunatorioRest() throws NamingException {		

	}
	/*
	@WebMethod 
	public void altaRegistroVacuna(DTRegistroVacuna regVacuna) {
		registroNegocio.altaRegistroVacuna(regVacuna);
	}
	
	@WebMethod 
	public List<DTReservaVacunatorio> obtenerReservasVacunatorio (String fecha, long idVac){
		return reservaNegocio.obtenerReservasVacunatorio(LocalDate.parse(fecha), idVac);
	}*/
	
	@GET
	@Path("/listar")
	public Response listarVacunatorios() {
		try {
			return Response
					.status(Response.Status.OK)
					.entity(vnl.listarVacunatorio())
					.build();
		}
		catch(Exception e){
			return Response
					.status(Response.Status.INTERNAL_SERVER_ERROR)
					.build();
		}
	}
	
}
