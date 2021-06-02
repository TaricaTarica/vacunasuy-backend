package entidades;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("autoridad")
public class Autoridad extends Usuario{

	
	
	public Autoridad() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Autoridad(int ci, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido,
			int telefono, String email, String usuario, String contrasenia) {
		super(ci, primerNombre, segundoNombre, primerApellido, segundoApellido, telefono, email, contrasenia);
		// TODO Auto-generated constructor stub
		
	}

	
}
