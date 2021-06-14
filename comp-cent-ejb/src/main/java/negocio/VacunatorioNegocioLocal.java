package negocio;

import java.util.List;

import javax.ejb.Local;

import datatypes.DTAgenda;
import datatypes.DTVacunatorio;

@Local
public interface VacunatorioNegocioLocal {

	public void agregarVacunatorio(DTVacunatorio dtVacunatorio) throws Exception;
	public List<DTVacunatorio> listarVacunatorio();
	public List<String> nombresVacunatorios();
	public DTAgenda obtenerAgendaActiva(long idVacunatorio);
	public DTVacunatorio obtenerVacunatorioPorCodigo(String codigo) throws Exception;
	public void editarVacunatorio(DTVacunatorio vacunatorioSeleccionado) throws Exception;
	public void eliminarVacunatorio(DTVacunatorio vac) throws Exception;
	
}
