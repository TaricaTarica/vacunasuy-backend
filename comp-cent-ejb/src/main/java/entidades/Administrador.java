package entidades;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("administrador")
public class Administrador extends Usuario {

	
	
		
	public Administrador() {
		super();
	}

	public Administrador(int ci, String primerNombre, String segundoNombre, String primerApellido,
			String segundoApellido, int telefono, String email, String usuario, String contrasenia) {
		super(ci, primerNombre, segundoNombre, primerApellido, segundoApellido, telefono, email,contrasenia);
		
	}	

}
