package negocio;

import java.util.List;

import javax.ejb.Local;

import datatypes.DTEnvio;
import enumeradores.EstadoEnvio;

@Local
public interface EnvioNegocioLocal {
	public List<DTEnvio> listarEnvios();
	public List<DTEnvio> listarEnviosPorSocioLogistico(String cod);
	public void cambiarEstadoEnvio(EstadoEnvio estado, long idEnvio);
}
