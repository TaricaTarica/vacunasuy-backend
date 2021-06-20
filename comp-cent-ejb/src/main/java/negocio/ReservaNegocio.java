package negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import datatypes.DTCiudadano;
import datatypes.DTConsultaReservaCiudadano;
import datatypes.DTPlanVacunacion;
import datatypes.DTReserva;
import datatypes.DTReservaVacunatorio;
import datos.AgendaDatoLocal;
import datos.CiudadanoDatoLocal;
import datos.PlanVacunacionDatoLocal;
import datos.ReservaDatoLocal;
import datos.VacunatorioDatoLocal;
import entidades.Agenda;
import entidades.Ciudadano;
import entidades.PlanVacunacion;
import entidades.Reserva;
import entidades.Vacunatorio;
import enumeradores.EstadoReserva;

/**
 * Session Bean implementation class ReservaNegocio
 */
@Stateless
@LocalBean
public class ReservaNegocio implements ReservaNegocioRemote, ReservaNegocioLocal {
	
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
		Agenda agenda = adl.obtenerAgendaPorId(res.getAgenda().getId());
		PlanVacunacion planVacunacion = pvdl.obtenerPlanVacunacion(res.getPlanVacunacion().getNombre());
		reserva.setCiudadano(ciudadano);
		reserva.setAgenda(agenda);		
		reserva.setPlanVacunacion(planVacunacion);	
		reserva.setEstado(EstadoReserva.Pendiente);
		rdl.crearReserva(reserva);		
	}
	@Override
	public List<DTConsultaReservaCiudadano> ciudadanoReservas(int ci){
		ArrayList<Reserva> reservas = (ArrayList<Reserva>) rdl.obtenerReservas();
		List<DTConsultaReservaCiudadano> dtReservas = new ArrayList<DTConsultaReservaCiudadano>();
		for(Reserva r: reservas) {
			if(r.getCiudadano().getCi() == ci) {
				dtReservas.add(new DTConsultaReservaCiudadano (r));
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

}
