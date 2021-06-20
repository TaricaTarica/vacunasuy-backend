package negocio;

import java.util.List;

import javax.ejb.Local;

import datatypes.DTCertificado;
import datatypes.DTRegistroVacuna;
import entidades.RegistroVacuna;

@Local
public interface RegistroVacunaNegocioLocal {
	public List<DTCertificado> obtenerCertificados(String ci);
	
	 public List<RegistroVacuna> listarRegistros();
	 public void altaRegistroVacuna (DTRegistroVacuna regVacuna);
}
