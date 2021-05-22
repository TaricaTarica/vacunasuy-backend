package datos;

import java.util.List;

import javax.ejb.Remote;

import entidades.Proveedor;

@Remote
public interface ProveedorDatoRemote {
	public List<Proveedor> obtenerProveedores();
	public Proveedor obtenerProveedorPorNombre(String nombre);
	public Boolean existeProveedor(String nombre);
	 public void agregarProveedor(Proveedor proveedor);
}
