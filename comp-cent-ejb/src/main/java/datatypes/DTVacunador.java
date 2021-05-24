package datatypes;

import entidades.Vacunador;

public class DTVacunador {
	
	private int ci;	
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;	
	private int telefono;
	private String email;
	
	public DTVacunador() {
		super();
	}

	public DTVacunador(int ci, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido,
			int telefono, String email) {
		super();
		this.ci = ci;
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.telefono = telefono;
		this.email = email;
	}
	
	public DTVacunador(Vacunador vacunador) {
		super();
		this.ci = vacunador.getCi();
		this.primerNombre = vacunador.getPrimerNombre();
		this.segundoNombre = vacunador.getSegundoNombre();
		this.primerApellido = vacunador.getPrimerApellido();
		this.segundoApellido = vacunador.getSegundoApellido();
		this.telefono = vacunador.getTelefono();
		this.email = vacunador.getEmail();	
	}

	public int getCi() {
		return ci;
	}

	public void setCi(int ci) {
		this.ci = ci;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String primerNombre) {
		this.primerNombre = primerNombre;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String segundoNombre) {
		this.segundoNombre = segundoNombre;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
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

	@Override
	public String toString() {
		return "DTVacunador [ci=" + ci + ", primerNombre=" + primerNombre + ", segundoNombre=" + segundoNombre
				+ ", primerApellido=" + primerApellido + ", segundoApellido=" + segundoApellido + ", telefono="
				+ telefono + ", email=" + email + "]";
	}	
	
}
