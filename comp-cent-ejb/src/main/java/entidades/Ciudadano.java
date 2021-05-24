package entidades;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import datatypes.DTCiudadano;

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

	public Ciudadano(DTCiudadano dtciudadano) {
		super(dtciudadano.getCi(),dtciudadano.getPrimerNombre(),dtciudadano.getSegundoNombre(),dtciudadano.getPrimerApellido(),dtciudadano.getSegundoApellido(),dtciudadano.getTelefono(), dtciudadano.getEmail());	
	}	
	
}
