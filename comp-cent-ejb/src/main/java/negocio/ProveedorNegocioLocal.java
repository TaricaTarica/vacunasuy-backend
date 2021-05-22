package negocio;

import java.util.List;

import javax.ejb.Local;

import datatypes.DTProveedor;
import entidades.Vacuna;

@Local
public interface ProveedorNegocioLocal {
	public List<DTProveedor> obtenerProveedores();
	public void agregarProveedor(String nombre, int tel) throws Exception;
}
