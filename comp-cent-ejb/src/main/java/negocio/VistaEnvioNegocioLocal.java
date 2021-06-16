package negocio;

import java.util.List;

import javax.ejb.Local;

import datatypes.DTVistaEnvio;

@Local
public interface VistaEnvioNegocioLocal {
	public List<DTVistaEnvio> listarEnvios();
}
