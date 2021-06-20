package negocio;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Local;

import datatypes.DTConsultaReservaCiudadano;
import datatypes.DTReserva;
import datatypes.DTReservaVacunatorio;


@Local
public interface ReservaNegocioLocal {
	
	public List<DTReserva> obtenerReservas();
	
	public void crearReserva(DTReserva res);
	
	public List<DTConsultaReservaCiudadano> ciudadanoReservas(int ci);
	
	public void cancelarReserva(String idReserva);
	
	public Boolean existeReservaPorAgenda (long idAgenda);
	
	public List<DTReservaVacunatorio> obtenerReservasVacunatorio (LocalDate fecha, long idVac);
}
