package datos;

import java.util.List;

import javax.ejb.Local;

import entidades.Vacunador;
import entidades.Vacunatorio;
import entidades.VacunatorioVacunador;

@Local
public interface VacunatorioVacunadorDatoLocal {
	
	public void agregarVacunadorVacunatorio(VacunatorioVacunador vacunatorioVacunador);
	public Vacunatorio buscarVacunatorio(Vacunador vacunador);
	public List<Integer> buscarVacunadoresAsignados(Vacunatorio vacunatorio);
	public Boolean existeVacunatorio(long id);
	//public void EliminarVacunatorioAsignaciones(long id);
	public List<VacunatorioVacunador> obtenerVacunatoriosVacunadores(long id);
	public void quitarVacunadorVacunatorio(VacunatorioVacunador vacunatorioVacunador);
	
}
