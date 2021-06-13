package datatypes;

import entidades.Ciudadano;

public class DTCiudadano {

	private int ci;	
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;	
	private int telefono;
	private String email;
	private String tipo;
	
	public DTCiudadano() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DTCiudadano(int ci, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido,
			int telefono, String email, String tipo) {
		super();
		this.ci = ci;
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.telefono = telefono;
		this.email = email;
		this.tipo = tipo;
	}
	
	public DTCiudadano(Ciudadano ciudadano) {
		super();
		this.ci = ciudadano.getCi();
		this.primerNombre = ciudadano.getPrimerNombre();
		this.segundoNombre = ciudadano.getSegundoNombre();
		this.primerApellido = ciudadano.getPrimerApellido();
		this.segundoApellido = ciudadano.getSegundoApellido();
		this.telefono = ciudadano.getTelefono();
		this.email = ciudadano.getEmail();
		this.tipo = ciudadano.getTipo();
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "DTCiudadano [ci=" + ci + ", primerNombre=" + primerNombre + ", segundoNombre=" + segundoNombre
				+ ", primerApellido=" + primerApellido + ", segundoApellido=" + segundoApellido + ", telefono="
				+ telefono + ", email=" + email + "]";
	}
	
}
