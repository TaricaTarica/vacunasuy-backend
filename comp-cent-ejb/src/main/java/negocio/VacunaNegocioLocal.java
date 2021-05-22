package negocio;

import java.util.List;

import javax.ejb.Local;

import datatypes.DTVacuna;
import entidades.Enfermedad;
import entidades.Proveedor;

@Local
public interface VacunaNegocioLocal {
	public void agregarVacuna(String nombre, String codigo, String laboratorio, Enfermedad enf, Proveedor pro);
	public DTVacuna obtenerVacuna(long id);
	public List<DTVacuna> obtenerVacunas();
	public void agregarVacunas();
	public void agregarVacuna(DTVacuna dtvacuna);
}
