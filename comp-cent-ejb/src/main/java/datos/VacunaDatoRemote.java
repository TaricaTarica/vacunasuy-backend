package datos;

import java.util.List;

import javax.ejb.Remote;

import entidades.Vacuna;

@Remote
public interface VacunaDatoRemote {

	public void agregarVacuna(Vacuna vac);
	public List<Vacuna> obtenerVacunas();
	public Vacuna obtenerVacuna(long id);
	public Boolean existeVacuna(String nombre);
}
