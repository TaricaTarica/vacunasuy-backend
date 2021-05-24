package entidades;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("autoridad")
public class Autoridad extends Usuario{

	private String usuario;
	private String contrasenia;
	
	public Autoridad() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Autoridad(int ci, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido,
			int telefono, String email, String usuario, String contrasenia) {
		super(ci, primerNombre, segundoNombre, primerApellido, segundoApellido, telefono, email);
		// TODO Auto-generated constructor stub
		this.usuario = usuario;
		this.contrasenia = contrasenia;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}	
	
}
