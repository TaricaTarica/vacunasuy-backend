package datos;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Local;

import entidades.Reserva;

@Local
public interface ReservaDatoLocal {
	
	public List<Reserva> obtenerReservas();
	
	public void crearReserva(Reserva res);
	
	public Reserva obtenerReserva(long id);
	
	public void editarReserva(Reserva res);
	
	public Boolean existeReserva(long idAgenda);

	public List<Reserva> obtenerReservasAgenda(LocalDate fecha, long id);

	public List<Reserva> obtenerReservasPorUbicacion(long id);

	public Reserva obtenerUltimaReserva(long id, LocalDate fecha);

	public int obtenerCantidadUltimaHora(long id, LocalDate fecha, int hora);

	public int obtenerCantidadReservasDia(long id, LocalDate fecha);

}
