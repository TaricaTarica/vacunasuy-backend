package negocio;

import java.time.LocalDate;
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
	 
	 public int countVacunadosHoy(long vacunaId);
	 
	 public int[] countVacunadosPorMes(long vacunaId, int ano);
	 
	 public int[] countVacunadosPorDepartamento(long vacunaId, int ano);
	 
	 public DTCertificado obtenerCertificadoReserva(long idReserva);
	 
	 public int cantVacHastaFecha(long vacunaId, LocalDate fecha);
}
