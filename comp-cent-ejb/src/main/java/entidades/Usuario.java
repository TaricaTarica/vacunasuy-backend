package entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private int ci;
	
	private String nombre;
	private int telefono;
	private String Email;

	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	

	public Usuario(int ci, String nombre, int telefono, String email) {
		super();
		this.ci = ci;
		this.nombre = nombre;
		this.telefono = telefono;
		Email = email;

	}

	public int getCi() {
		return ci;
	}

	public void setCi(int ci) {
		this.ci = ci;
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

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

}
