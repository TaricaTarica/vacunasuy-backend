package negocio;

import java.util.List;

import javax.ejb.Local;

import datatypes.DTCertificado;
import datatypes.DTRegistroVacuna;
import datatypes.DTVacuna;
import entidades.RegistroVacuna;


@Local
public interface RegistroVacunaNegocioLocal {
	public List<DTCertificado> obtenerCertificados(String ci);
	
	 public List<RegistroVacuna> listarRegistros();
	 public void altaRegistroVacuna (List<DTRegistroVacuna> regVacuna);
	 
	 public List<Integer> obtenerCantVac(DTVacuna vacuna, int anio);
	 
	 public List<Integer> cantRegistroPorSexo(DTVacuna vacuna, int anio);
	 
	 public List<Integer> cantRegistroPorEdad(DTVacuna vacuna, int anio);
}
