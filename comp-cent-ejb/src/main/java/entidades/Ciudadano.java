package entidades;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import datatypes.DTCiudadano;

@Entity
@DiscriminatorValue("ciudadano")
public class Ciudadano extends Usuario {
	
	private String tipoCiudadano;
	private LocalDate fnac;

	public Ciudadano() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ciudadano(int ci, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido,
			int telefono, String email, String tipoCiudadano, LocalDate fnac) {
		super(ci, primerNombre, segundoNombre, primerApellido, segundoApellido, telefono, email);
		this.tipoCiudadano = tipoCiudadano;
		this.fnac = fnac;
	}

	public Ciudadano(DTCiudadano dtciudadano) {
		super(dtciudadano.getCi(),dtciudadano.getPrimerNombre(),dtciudadano.getSegundoNombre(),dtciudadano.getPrimerApellido(),dtciudadano.getSegundoApellido(),dtciudadano.getTelefono(), dtciudadano.getEmail());	
		this.tipoCiudadano = dtciudadano.getTipoCiudadano();
		this.fnac = LocalDate.parse(dtciudadano.getFnac());
	}

	public String getTipoCiudadano() {
		return tipoCiudadano;
	}

	public void setTipoCiudadano(String tipoCiudadano) {
		this.tipoCiudadano = tipoCiudadano;
	}

	public LocalDate getFnac() {
		return fnac;
	}

	public void setFnac(LocalDate fnac) {
		this.fnac = fnac;
	}
	
}
