package datos;

import java.util.List;

import javax.ejb.Local;

import entidades.Reserva;

@Local
public interface ReservaDatoLocal {
	
	public List<Reserva> obtenerReservas();
	
	public void crearReserva(Reserva res);
	
	public Reserva obtenerReserva(long id);
	
	public void editarReserva(Reserva res);

}
