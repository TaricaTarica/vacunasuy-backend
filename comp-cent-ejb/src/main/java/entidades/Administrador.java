package entidades;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("administrador")
public class Administrador extends Usuario {

	
	private String usuario;
	private String contrasenia;
		
	public Administrador() {
		super();
	}

	public Administrador(int ci, String primerNombre, String segundoNombre, String primerApellido,
			String segundoApellido, int telefono, String email, String usuario, String contrasenia) {
		super(ci, primerNombre, segundoNombre, primerApellido, segundoApellido, telefono, email);
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
