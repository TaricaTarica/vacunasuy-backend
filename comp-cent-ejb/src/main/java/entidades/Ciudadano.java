package entidades;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ciudadano")
public class Ciudadano extends Usuario {

	public Ciudadano() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ciudadano(int ci, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido,
			int telefono, String email) {
		super(ci, primerNombre, segundoNombre, primerApellido, segundoApellido, telefono, email);
		// TODO Auto-generated constructor stub
	}

	
	
}
