package negocio;

import java.util.List;

import javax.ejb.Local;

import datatypes.DTEnfermedad;
import datatypes.DTProveedor;
import datatypes.DTVacuna;
import entidades.Enfermedad;
import entidades.Proveedor;

@Local
public interface VacunaNegocioLocal {
	public void agregarVacuna(String nombre, String codigo, String laboratorio, Enfermedad enf, Proveedor pro, int dosis, int periodoInmune);
	public DTVacuna obtenerVacuna(long id);
	public List<DTVacuna> obtenerVacunas();
	public void agregarVacunas();
	public void agregarVacuna(DTVacuna dtvacuna)throws Exception;
	public void editarVacuna(DTVacuna dtvacuna) throws Exception;
	public void eliminarVacuna(String nombre) throws Exception;
	public DTProveedor obtenerProveedorDeVacuna(String nombre);
	public DTEnfermedad obtenerEnfermedadDeVacuna(String nombre);
	public List<String> nombresVacunas();
}
