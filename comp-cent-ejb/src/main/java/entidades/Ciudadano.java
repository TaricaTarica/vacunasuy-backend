package entidades;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import datatypes.DTCiudadano;

@Entity
@DiscriminatorValue("C")
public class Ciudadano extends Usuario {

	private static final long serialVersionUID = 1L;

	public Ciudadano() {
		// TODO Auto-generated constructor stub
	}

	public Ciudadano(int ci, String nombre, int telefono, String email, String pass) {
		super(ci, nombre, telefono, email, pass);
		// TODO Auto-generated constructor stub
	}

	public Ciudadano (DTCiudadano dtCiudadano) {
		super(dtCiudadano.getCi(), dtCiudadano.getNombre(), dtCiudadano.getTelefono(), 
				dtCiudadano.getEmail(), dtCiudadano.getPass());
	}
	
}
