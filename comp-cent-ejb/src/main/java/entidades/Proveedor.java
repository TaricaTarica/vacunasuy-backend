package entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import datatypes.DTProveedor;

@Entity
public class Proveedor {
	@Id 
	@GeneratedValue
	private long id;
	private String nombre;
	private int telefono;

	public Proveedor() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Proveedor(DTProveedor proveedor) {
		super();
		this.nombre = proveedor.getNombre();
		this.telefono = proveedor.getTelefono();
	}

	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
