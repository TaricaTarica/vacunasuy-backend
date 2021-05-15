package entidades;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Usuario {

	@Id
	private int ci;
	
	private String nombre;
	private int telefono;
	private String email;
	

	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	

	public Usuario(int ci, String nombre, int telefono, String email) {
		super();
		this.ci = ci;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;

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
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
