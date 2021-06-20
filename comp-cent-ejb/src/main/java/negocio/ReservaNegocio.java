package negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import datatypes.DTConsultaReservaCiudadano;
import datatypes.DTReserva;
import datatypes.DTReservaVacunatorio;
import datos.AgendaDatoLocal;
import datos.CiudadanoDatoLocal;
import datos.DepartamentoDatoLocal;
import datos.PlanVacunacionDatoLocal;
import datos.ReservaDatoLocal;
import datos.VacunatorioDatoLocal;
import entidades.Agenda;
import entidades.Ciudadano;
import entidades.Departamento;
import entidades.PlanVacunacion;
import entidades.Reserva;
import entidades.Vacunatorio;
import entidades.Ubicacion;
import enumeradores.EstadoReserva;

/**
 * Session Bean implementation class ReservaNegocio
 */
@Stateless
@LocalBean
public class ReservaNegocio implements ReservaNegocioLocal {
	
	@Inject
	ReservaDatoLocal rdl;
	
	@Inject
	AgendaNegocioLocal anl;
	
	@Inject
	VacunatorioDatoLocal vdl;
	
	@Inject
	CiudadanoDatoLocal cdl;
	
	@Inject
	AgendaDatoLocal adl;
	
	@Inject
	PlanVacunacionDatoLocal pvdl;
	
	
	@Inject
	DepartamentoDatoLocal ddl;
	
    /**
     * Default constructor. 
     */
    public ReservaNegocio() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<DTReserva> obtenerReservas() {
    	ArrayList<Reserva> reservas = (ArrayList<Reserva>) rdl.obtenerReservas();
    	ArrayList<DTReserva> dTReservas = new ArrayList<DTReserva>();
    	reservas.forEach( (r) -> { dTReservas.add( new DTReserva(r) ) ; } );
		return dTReservas;
	}

	@Override
	public void crearReserva(DTReserva res) {
		Reserva reserva = new Reserva(res);
		Ciudadano ciudadano = cdl.obtenerCiudadano(res.getCiudadano().getCi());
		PlanVacunacion planVacunacion = pvdl.obtenerPlanVacunacion(res.getPlanVacunacion().getNombre());
		Ubicacion ubicacion = ddl.obtenerDepartamentoUbicacion(res.getDepartamento().getDescripcion(), res.getUbicacion().getDescription());
		Departamento departamento = ddl.obtenerDepartamentoPorNombre(res.getDepartamento().getDescripcion());
		reserva.setCiudadano(ciudadano);
		reserva.setPlanVacunacion(planVacunacion);	
		reserva.setEstado(EstadoReserva.Pendiente);
		reserva.setDepartamento(departamento);
		reserva.setUbicacion(ubicacion);
		rdl.crearReserva(reserva);		
	}
	@Override
	public List<DTConsultaReservaCiudadano> ciudadanoReservas(int ci){
		ArrayList<Reserva> reservas = (ArrayList<Reserva>) rdl.obtenerReservas();
		List<DTConsultaReservaCiudadano> dtReservas = new ArrayList<DTConsultaReservaCiudadano>();
		for(Reserva r: reservas) {
			if(r.getCiudadano().getCi() == ci) {
				DTConsultaReservaCiudadano  dtcrc = new DTConsultaReservaCiudadano (r);
				dtcrc.setEnfermedad(r.getPlanVacunacion().getEnfermedad().getNombre());
				if(r.getAgenda() != null) {
					dtcrc.setVacunatorio(r.getAgenda().getVacunatorio().getNombre());
				}
				else {
					dtcrc.setVacunatorio("N/A");
				}
				dtReservas.add(dtcrc);
				
			}
		}
		return dtReservas;
	}
	@Override
	public void cancelarReserva(String idReserva){
		long id = Long.parseLong(idReserva);
		Reserva reserva = rdl.obtenerReserva(id);
		reserva.setEstado(EstadoReserva.Cancelada);
		rdl.editarReserva(reserva);
	}
	
	public Boolean existeReservaPorAgenda (long idAgenda) {
		return rdl.existeReserva(idAgenda);
	}
	
	public List<DTReservaVacunatorio> obtenerReservasVacunatorio (LocalDate fecha, long idVac){
		Vacunatorio vacunatorio = vdl.obtenerVacunatorio(idVac);
		List<DTReservaVacunatorio> reservas = new ArrayList<DTReservaVacunatorio>();
		Agenda agenda = anl.obtenerAgendaActiva (vacunatorio.getId(), fecha);
		if (agenda != null) {
			List<Reserva> reservasAux =  rdl.obtenerReservasAgenda(fecha, agenda.getId());
				if (reservas != null) {
					for (Reserva res: reservasAux) {
						DTReservaVacunatorio reserva = new DTReservaVacunatorio ();
						reserva.setCi(res.getCiudadano().getCi());
						reserva.setIdVacuna(res.getVacuna().getId());
						reserva.setFecha(res.getFecha().toString());
						reservas.add(reserva);
					}
					return reservas;
				}
				
				
		}
		return null;
	}
	
	@Override
	public int countAgendadosHoy(long vacunaId) {
		int retorno = 0;
		ArrayList<Reserva> reservas = (ArrayList<Reserva>) rdl.obtenerReservas();
		for(Reserva r: reservas) {
			if(
					r.getEstado().equals(EstadoReserva.Agendado) &&
					r.getFecha().equals(LocalDate.now()) &&
					r.getVacuna().getId() == vacunaId
			){
				retorno++;
			}
		}
		
		return retorno;
	}

}
