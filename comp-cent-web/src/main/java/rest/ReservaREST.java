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
import datatypes.DTReservaWS;
import datatypes.DTUbicacion;
import datatypes.DTVacunatorio;
import negocio.CiudadanoNegocioLocal;
import negocio.DepartamentoNegocioLocal;
import negocio.PlanVacunacionNegocioLocal;
import negocio.ReservaNegocioLocal;
import negocio.VacunatorioNegocioLocal;


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
	
	@Inject
	private VacunatorioNegocioLocal vnl;
	
	public ReservaREST() throws NamingException {		

	}
	
	@POST
	public Response crearReserva(DTReservaWS dtrws) {
		DTReserva dtReserva = new DTReserva(); 
		try{
            int numeroCi = Integer.parseInt(dtrws.getCi());
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
		
		DTPlanVacunacion dtPlanVacunacion = pvnl.obtenerPlanVacunacion(dtrws.getPlanVacunacion());
		if(dtPlanVacunacion == null) {
			return Response
					.status(Response.Status.NOT_FOUND)
					.build();
		}
		else {
			dtReserva.setPlanVacunacion(dtPlanVacunacion);
		}
		DTUbicacion dtUbicacion = dnl.obtenerDepartamentoUbicacion(dtrws.getDepartamento(), dtrws.getUbicacion());
		if(dtUbicacion == null) {
			return Response
					.status(Response.Status.NOT_FOUND)
					.build();
		}
		else {
			DTVacunatorio dtVacunatorio = dtUbicacion.getVacunatorio();
			DTAgenda dtAgenda = vnl.obtenerAgendaActiva(dtVacunatorio.getId());
			dtReserva.setAgenda(dtAgenda);
		}
		rnl.crearReserva(dtReserva);
		return Response
				.status(Response.Status.OK)
				.build();
	}
	
}
