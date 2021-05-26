package datos;

import java.util.List;

import javax.ejb.Local;

import entidades.Vacunador;

@Local
public interface VacunadorDatoLocal {

	public void guardarVacunador(Vacunador vacunador);
	
	public void editarVacunador(Vacunador vacunador);
	
	public List<Vacunador> obtenerVacunadores();
	
	public Vacunador obteneVacunadorPorCI(int ci);
	
}
