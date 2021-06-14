package negocio;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Local;

import datatypes.DTVacunador;
import datatypes.DTVacunatorio;

@Local
public interface VacunatorioVacunadorNegocioLocal {

	public void agregarVacunadorVacunatorio(DTVacunatorioVacunador dtVacunatorioVacunador);
	public DTVacunatorio buscarVacunatorio(DTVacunador dtVacunador, LocalDate fecha);
	public List<DTVacunador> buscarVacunadoresAsignados(DTVacunatorio dtVacunatorio, LocalDate fecha);
	
}
