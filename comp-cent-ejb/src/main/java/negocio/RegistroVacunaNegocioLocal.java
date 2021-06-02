package negocio;

import java.util.List;

import javax.ejb.Local;

import datatypes.DTCertificado;

@Local
public interface RegistroVacunaNegocioLocal {
	public List<DTCertificado> obtenerCertificados(String ci);
}
