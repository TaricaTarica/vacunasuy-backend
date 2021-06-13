package negocio;

import java.util.List;

import javax.ejb.Local;

import datatypes.DTEnvio;

@Local
public interface EnvioNegocioLocal {
	public List<DTEnvio> listarEnvios();
}
