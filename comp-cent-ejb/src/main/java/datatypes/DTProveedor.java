package datatypes;

import entidades.Proveedor;

public class DTProveedor {
	private String nombre;
	private int telefono;


	public DTProveedor() {
		// TODO Auto-generated constructor stub
	}
	


	public DTProveedor(Proveedor proveedor) {
		super();
		this.nombre = proveedor.getNombre();
		this.telefono = proveedor.getTelefono();
	}



	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getTelefono() {
		return telefono;
	}


	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

}
