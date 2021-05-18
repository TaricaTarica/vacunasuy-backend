package negocio;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import datatypes.DTReserva;
import datos.AgendaDatoLocal;
import datos.CiudadanoDatoLocal;
import datos.ReservaDatoLocal;
import entidades.Agenda;
import entidades.Ciudadano;
import entidades.PlanVacunacion;
import entidades.Reserva;

/**
 * Session Bean implementation class ReservaNegocio
 */
@Stateless
@LocalBean
public class ReservaNegocio implements ReservaNegocioRemote, ReservaNegocioLocal {
	
	@Inject
	ReservaDatoLocal rdl;	
	
	
	@Inject
	CiudadanoDatoLocal cdl;
	
	@Inject
	AgendaDatoLocal adl;	

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
		PlanVacunacion planVacunacion = null; ///////Me falta buscar plan de vacunacion por nombre o id
		reserva.setCiudadano(ciudadano);
		reserva.setAgenda(agenda);		
		reserva.setPlanVacunacion(planVacunacion);		
		rdl.crearReserva(reserva);		
	}

}
