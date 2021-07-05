package negocio;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Local;

import datatypes.DTVacunador;
import datatypes.DTVacunatorio;
import datatypes.DTVacunatorioVacunador;
@Local
public interface VacunatorioVacunadorNegocioLocal {

	public void agregarVacunadorVacunatorio(DTVacunatorioVacunador dtVacunatorioVacunador) throws Exception;
	public DTVacunatorio buscarVacunatorio(DTVacunador dtVacunador);
	public List<DTVacunador> buscarVacunadoresAsignados(long id);
	public List<DTVacunador> obtenerVacunadoresLibres();
	public Integer obtenerPuestoVacunador(int ciVacunador,DTVacunatorio dtVacunatorio); 
	
}
