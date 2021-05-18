package rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import datatypes.DTAgenda;
import datatypes.DTCiudadano;
import datatypes.DTPlanVacunacion;
import datatypes.DTReserva;
import datatypes.DTUbicacion;
import datatypes.DTVacunatorio;
import negocio.CiudadanoNegocioLocal;
import negocio.DepartamentoNegocioLocal;
import negocio.PlanVacunacionNegocioLocal;
import negocio.ReservaNegocioLocal;


@RequestScoped
@Path("/reserva")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ReservaREST {

	@Inject
	private ReservaNegocioLocal rnl;
	
	@Inject
	private CiudadanoNegocioLocal cnl;
	
	@Inject
	private PlanVacunacionNegocioLocal pvnl;
	
	@Inject 
	private DepartamentoNegocioLocal dnl;
	
	public ReservaREST() throws NamingException {		

	}
	
	@POST
	public Response crearReserva(String ci, String planVacunacion, String departamento, String ubicacion) {
		DTReserva dtReserva = new DTReserva(); 
		try{
            int numeroCi = Integer.parseInt(ci);
            DTCiudadano dtCiudadano = cnl.obtenerCiudadano(numeroCi);
            if(dtCiudadano == null) {
            	return Response
            			.status(Response.Status.NOT_FOUND)
            			.build();
            }
            else {
            	dtReserva.setCiudadano(dtCiudadano);
            }
        }
        catch (NumberFormatException ex){
             return Response
            		 .status(Response.Status.BAD_REQUEST)
            		 .build();
        }
		
		DTPlanVacunacion dtPlanVacunacion = pvnl.obtenerPlanVacunacion(planVacunacion);
		if(dtPlanVacunacion == null) {
			return Response
					.status(Response.Status.NOT_FOUND)
					.build();
		}
		else {
			dtReserva.setPlanVacunacion(dtPlanVacunacion);
		}
		DTUbicacion dtUbicacion = dnl.obtenerDepartamentoUbicacion(departamento, ubicacion);
		if(dtUbicacion == null) {
			return Response
					.status(Response.Status.NOT_FOUND)
					.build();
		}
		else {
			DTVacunatorio dtVacunatorio = dtUbicacion.getVacunatorio();
			DTAgenda dtAgenda = dtVacunatorio.getAgenda();
			dtReserva.setAgenda(dtAgenda);
		}
		rnl.crearReserva(dtReserva);
		return Response
				.status(Response.Status.OK)
				.build();
	}
	
}
