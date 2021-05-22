package negocio;

import java.util.List;

import javax.ejb.Remote;

import datatypes.DTVacuna;
import entidades.Enfermedad;
import entidades.Proveedor;

@Remote
public interface VacunaNegocioRemote {
	public void agregarVacuna(String nombre, String codigo, String laboratorio, Enfermedad enf, Proveedor pro);
	public DTVacuna obtenerVacuna(long id);
	public List<DTVacuna> obtenerVacunas();
	public void agregarVacuna(DTVacuna dtvacuna)throws Exception;
}
