package negocio;

import java.util.List;

import javax.ejb.Local;

import datatypes.DTReserva;


@Local
public interface ReservaNegocioLocal {
	
	public List<DTReserva> obtenerReservas();
	
	public void crearReserva(DTReserva res);

}
