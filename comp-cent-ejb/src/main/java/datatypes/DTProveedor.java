package datatypes;

import entidades.Proveedor;

public class DTProveedor {
	private long id;
	private String nombre;
	private int telefono;


	public DTProveedor() {
		// TODO Auto-generated constructor stub
	}
	


	public DTProveedor(Proveedor proveedor) {
		super();
		this.nombre = proveedor.getNombre();
		this.telefono = proveedor.getTelefono();
		this.id = proveedor.getId();
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



	@Override
	public String toString() {
		return nombre;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}

	
}
