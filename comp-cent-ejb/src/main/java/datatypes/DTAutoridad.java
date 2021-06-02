package datatypes;

import entidades.Autoridad;

public class DTAutoridad {
	
	private int ci;	
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;	
	private int telefono;
	private String email;
	private String usuario;
	private String contrasenia;
	
	public DTAutoridad() {
		super();
	}

	public DTAutoridad(int ci, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido,
			int telefono, String email, String usuario, String contrasenia) {
		super();
		this.ci = ci;
		this.primerNombre = primerNombre;
		this.segundoNombre = segundoNombre;
		this.primerApellido = primerApellido;
		this.segundoApellido = segundoApellido;
		this.telefono = telefono;
		this.email = email;
		this.usuario = usuario;
		this.contrasenia = contrasenia;
	}	

	public DTAutoridad(Autoridad autoridad) {
		super();
		this.ci = autoridad.getCi();
		this.primerNombre = autoridad.getPrimerNombre();
		this.segundoNombre = autoridad.getSegundoNombre();
		this.primerApellido = autoridad.getPrimerApellido();
		this.segundoApellido = autoridad.getSegundoApellido();
		this.telefono = autoridad.getTelefono();
		this.email = autoridad.getEmail();
		this.contrasenia = autoridad.getContrasenia();		
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

	@Override
	public String toString() {
		return "DTAutoridad [ci=" + ci + ", primerNombre=" + primerNombre + ", segundoNombre=" + segundoNombre
				+ ", primerApellido=" + primerApellido + ", segundoApellido=" + segundoApellido + ", telefono="
				+ telefono + ", email=" + email + ", usuario=" + usuario + "]";
	}	

}
