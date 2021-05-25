package datos;

import java.util.List;

import javax.ejb.Local;

import entidades.Enfermedad;
import entidades.Proveedor;
import entidades.Vacuna;

@Local
public interface VacunaDatoLocal {

	public void agregarVacuna(Vacuna vac);
	public List<Vacuna> obtenerVacunas();
	Vacuna obtenerVacuna(String nombre);
	public Boolean existeVacuna(String nombre);
	void editarVacuna(Vacuna vacuna);
	 public void eliminarVacuna(Vacuna vacuna);
	public Proveedor obtenerProveedorDeVacuna(String nomVac);
	public Enfermedad obtenerEnfermedadDeVacuna(String nomVac);
	public Vacuna obtenerVacunaPorId(long id);
	
}
