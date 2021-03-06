package rest;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.naming.NamingException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import datatypes.DTCiudadano;
import datatypes.DTConsultaReservaCiudadano;
import datatypes.DTDepartamento;
import datatypes.DTPlanVacunacion;
import datatypes.DTReserva;
import datatypes.DTReservaWS;
import datatypes.DTUbicacion;
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
	public Response crearReserva(DTReservaWS dtrws) {
		DTReserva dtReserva = new DTReserva(); 
		try{
            int numeroCi = Integer.parseInt(dtrws.getCi());
            DTCiudadano dtCiudadano = cnl.obtenerCiudadano(numeroCi);
            if(dtCiudadano == null) {
            	return Response
            			.status(Response.Status.NOT_FOUND)
            			.entity(new Gson().toJson("ERROR: no existe el ciudadano"))
            			.build();
            }
            else {
            	dtReserva.setCiudadano(dtCiudadano);
            }
        }
        catch (NumberFormatException ex){
             return Response
            		 .status(Response.Status.BAD_REQUEST)
            		 .entity(new Gson().toJson("ERROR: la cedula debe ser numerica"))
            		 .build();
        }
		
		DTPlanVacunacion dtPlanVacunacion;
		try {
			dtPlanVacunacion = pvnl.obtenerPlanVacunacion(dtrws.getPlanVacunacion());
			dtReserva.setPlanVacunacion(dtPlanVacunacion);
		} catch (Exception e) {
			return Response
					.status(Response.Status.NOT_FOUND)
					.entity(new Gson().toJson("ERROR: Plan de vacunacion no encontrado"))
					.build();
		}
	
		DTUbicacion dtUbicacion = dnl.obtenerDepartamentoUbicacion(dtrws.getDepartamento(), dtrws.getUbicacion());
		DTDepartamento dtDepartamento = new DTDepartamento(dtrws.getDepartamento());
		if(dtUbicacion == null || dtDepartamento == null) {
			return Response
					.status(Response.Status.NOT_FOUND)
					.entity(new Gson().toJson("ERROR: Ubicacion o departamento no encontrado"))
					.build();
		}
		else {
			dtReserva.setUbicacion(dtUbicacion);
			dtReserva.setDepartamento(dtDepartamento);
		}
		rnl.crearReserva(dtReserva);
		return Response
				.status(Response.Status.OK)
				.entity(new Gson().toJson("INFO: Reserva creada!"))
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
	@PUT
	@Path("/cancelar")
	public Response cancelarReserva(String idReserva) {
		try {
			rnl.cancelarReserva(idReserva);
			return Response
					.status(Response.Status.OK)
					.entity(new Gson().toJson("INFO: Reserva cancelada"))
					.build();
		}
		catch (Exception e) {
			return Response
					.status(Response.Status.INTERNAL_SERVER_ERROR)
					.build();
		}
	}
	@GET
	@Path("/count-agendados/{id}")
	public Response countAgendadosHoy(@PathParam("id") long vacunaId) {
		try {
			return Response
					.status(Response.Status.OK)
					.entity(rnl.countAgendadosHoy(vacunaId))
					.build();
		}
		catch(Exception e){
			return Response
					.status(Response.Status.INTERNAL_SERVER_ERROR)
					.build();
		}
	}
}
