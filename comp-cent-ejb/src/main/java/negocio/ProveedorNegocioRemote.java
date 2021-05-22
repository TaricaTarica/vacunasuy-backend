package negocio;

import java.util.List;

import javax.ejb.Remote;

import datatypes.DTProveedor;
import entidades.Vacuna;

@Remote
public interface ProveedorNegocioRemote {
	public List<DTProveedor> obtenerProveedores();
	public void agregarProveedor(String nombre, int tel) throws Exception;
}
