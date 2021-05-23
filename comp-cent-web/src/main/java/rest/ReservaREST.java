package rest;

import java.util.List;

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

import datatypes.DTAgenda;
import datatypes.DTCiudadano;
import datatypes.DTConsultaReservaCiudadano;
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
            			.entity("ERROR: no existe el ciudadano")
            			.build();
            }
            else {
            	dtReserva.setCiudadano(dtCiudadano);
            }
        }
        catch (NumberFormatException ex){
             return Response
            		 .status(Response.Status.BAD_REQUEST)
            		 .entity("ERROR: la cedula debe ser numerica")
            		 .build();
        }
		
		DTPlanVacunacion dtPlanVacunacion;
		try {
			dtPlanVacunacion = pvnl.obtenerPlanVacunacion(dtrws.getPlanVacunacion());
			dtReserva.setPlanVacunacion(dtPlanVacunacion);
		} catch (Exception e) {
			return Response
					.status(Response.Status.NOT_FOUND)
					.entity("ERROR: Plan de vacunacion no encontrado")
					.build();
		}
	
		DTUbicacion dtUbicacion = dnl.obtenerDepartamentoUbicacion(dtrws.getDepartamento(), dtrws.getUbicacion());
		if(dtUbicacion == null) {
			return Response
					.status(Response.Status.NOT_FOUND)
					.entity("ERROR: Ubicacion no encontrada")
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
				.entity("INFO: Reserva creada!")
				.build();
	}
	@GET
	@Path("/{ci}")
	public Response consultaReservas(@PathParam("ci") String ci) {
		try{
			int numeroCi = Integer.parseInt(ci);
			List<DTConsultaReservaCiudadano> dtReservas = rnl.ciudadanoReservas(numeroCi);
			if(!dtReservas.isEmpty()) {
				return Response
						.status(Response.Status.OK)
						.entity(dtReservas)
						.build();
			}
			else {
				return Response
          		 .status(Response.Status.NOT_FOUND)
          		 .entity("El ciudadano no tiene reservas")
          		 .build();
			}
		}
		catch (NumberFormatException ex){
            return Response
           		 .status(Response.Status.BAD_REQUEST)
           		 .entity("Ha ocurrido un error procesando la cedula")
           		 .build();
       }
	}
	
}
