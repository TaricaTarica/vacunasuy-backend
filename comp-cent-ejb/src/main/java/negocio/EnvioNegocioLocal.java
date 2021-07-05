package negocio;

import java.util.List;

import javax.ejb.Local;

import datatypes.DTEnvio;
import datatypes.DTLote;
import datatypes.DTSocioLogistico;
import datatypes.DTStockVacuna;
import datatypes.DTVacunatorio;
import enumeradores.EstadoEnvio;

@Local
public interface EnvioNegocioLocal {
	public List<DTEnvio> listarEnvios();
	public List<DTEnvio> listarEnviosPorSocioLogistico(String cod);
	public void cambiarEstadoEnvio(EstadoEnvio estado, long idEnvio);
	public void AgregarEnvio(DTEnvio envio, DTLote lote,  DTVacunatorio vacunatorio, DTSocioLogistico dtSocio ) throws Exception;
	public List<String> listarEstado ();
	public List<DTLote> listarLotePendientesDeEnviar ();
	public List<DTStockVacuna> stockEnviado(long idVacunatorio, int anio);
}
