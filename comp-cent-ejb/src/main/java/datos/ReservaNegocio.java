package negocio;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;

import datatypes.DTDepartamento;
import datatypes.DTReserva;
import datos.DepartamentoDatoLocal;
import datos.ReservaDatoLocal;
import entidades.Departamento;
import entidades.Reserva;

/**
 * Session Bean implementation class ReservaNegocio
 */
@Stateless
@LocalBean
public class ReservaNegocio implements ReservaNegocioRemote, ReservaNegocioLocal {
	
	@Inject
	ReservaDatoLocal rdl;	

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
		///buscar ciudadano
		
		//rdl.crearReserva();
		
	}


}
