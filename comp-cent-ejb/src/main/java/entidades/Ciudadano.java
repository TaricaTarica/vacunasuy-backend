package entidades;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import datatypes.DTCiudadano;

@Entity
@DiscriminatorValue("ciudadano")
public class Ciudadano extends Usuario {
	
	String tipo;

	public Ciudadano() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ciudadano(int ci, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido,
			int telefono, String email, String tipo) {
		super(ci, primerNombre, segundoNombre, primerApellido, segundoApellido, telefono, email);
		this.tipo = tipo;
	}

	public Ciudadano(DTCiudadano dtciudadano) {
		super(dtciudadano.getCi(),dtciudadano.getPrimerNombre(),dtciudadano.getSegundoNombre(),dtciudadano.getPrimerApellido(),dtciudadano.getSegundoApellido(),dtciudadano.getTelefono(), dtciudadano.getEmail());	
		this.tipo = dtciudadano.getTipo();
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
