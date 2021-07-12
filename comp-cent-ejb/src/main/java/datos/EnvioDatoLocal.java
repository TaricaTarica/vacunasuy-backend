package datos;

import java.time.LocalDate;
import java.util.List;
import javax.ejb.Local;

import datatypes.DTVistaEnvio;
import entidades.Envio;
import entidades.Lote;

@Local
public interface EnvioDatoLocal {
	
	public void guardarEnvio(Envio envio);
	public void editarEnvio(Envio envio);
	public Envio obtenerEnvio(long id);
	public List<Envio> listarEnvios();
	public List<Envio> listarEnviosPorSocioLogistico(String cod);
	public List<Lote> listarLotesPendientesDeEnviar();
	public List<DTVistaEnvio> ListarEnviosVista();
	public boolean ExisteLote(Lote lote);
	public List<Envio> cantVacEnviado(long idVacunatorio, LocalDate fecha);
	
}
