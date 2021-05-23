package negocio;

import java.util.List;

import javax.ejb.Local;

import datatypes.DTProveedor;
import entidades.Vacuna;

@Local
public interface ProveedorNegocioLocal {
	public List<DTProveedor> obtenerProveedores();
	public void agregarProveedor(String nombre, int tel) throws Exception;
	 public DTProveedor obtenerProveedorPorId(long id);
	 public void editarProveedor(DTProveedor dtPro) throws Exception;
	 public void eliminarProveedor(DTProveedor dtPro) throws Exception;
}
