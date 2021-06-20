package datos;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Local;

import entidades.Vacunador;
import entidades.Vacunatorio;
import entidades.VacunatorioVacunador;

@Local
public interface VacunatorioVacunadorDatoLocal {
	
	public void agregarVacunadorVacunatorio(VacunatorioVacunador vacunatorioVacunador);
	public Vacunatorio buscarVacunatorio(Vacunador vacunador, LocalDate fecha);
	public List<Vacunador> buscarVacunadoresAsignados(Vacunatorio vacunatorio, LocalDate fecha);
	
}
