package negocio;

import java.util.List;

import javax.ejb.Local;

import datatypes.DTAgenda;
import datatypes.DTVacunatorio;

@Local
public interface VacunatorioNegocioLocal {

	public void agregarVacunatorio(DTVacunatorio dtVacunatorio);
	public List<DTVacunatorio> listarVacunatorio();
	public List<String> nombresVacunatorios();
	public DTAgenda obtenerAgendaActiva(long idVacunatorio);
	
}
