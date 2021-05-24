package datos;

import java.util.List;

import javax.ejb.Local;

import entidades.Proveedor;

@Local
public interface ProveedorDatoLocal {
	public List<Proveedor> obtenerProveedores();
	public Proveedor obtenerProveedorPorNombre(String nombre);
	public Boolean existeProveedor(String nombre);
	 public void agregarProveedor(Proveedor proveedor);
	 public Proveedor obtenerProveedorPorId(long id);
	 public void editarProveedor(Proveedor pro);
	 public void eliminarProveedor(Proveedor pro);
}
