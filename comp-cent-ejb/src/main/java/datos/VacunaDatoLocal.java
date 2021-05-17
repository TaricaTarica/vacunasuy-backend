package datos;

import java.util.List;

import javax.ejb.Local;

import entidades.Vacuna;

@Local
public interface VacunaDatoLocal {

	public void agregarVacuna(Vacuna vac);
	public List<Vacuna> obtenerVacunas();
	Vacuna obtenerVacuna(String nombre);
}
