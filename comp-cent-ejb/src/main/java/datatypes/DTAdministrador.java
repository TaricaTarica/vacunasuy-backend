package datatypes;

import entidades.Administrador;

public class DTAdministrador {
	
	private int ci;	
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;	
	private int telefono;
	private String email;
	private String usuario;
	private String contrasenia;	

	public DTAdministrador() {
		// TODO Auto-generated constructor stub
	}

	public DTAdministrador(int ci, String primerNombre, String segundoNombre, String primerApellido,
			String segundoApellido, int telefono, String email, String usuario, String contrasenia) {
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
	
	public DTAdministrador(Administrador administrador) {
		this.ci = administrador.getCi();
		this.primerNombre = administrador.getPrimerNombre();
		this.segundoNombre = administrador.getSegundoNombre();
		this.primerApellido = administrador.getPrimerApellido();
		this.segundoApellido = administrador.getSegundoApellido();
		this.telefono = administrador.getTelefono();
		this.email = administrador.getEmail();
		this.contrasenia = administrador.getContrasenia();		
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
		return "DTAdministrador [ci=" + ci + ", primerNombre=" + primerNombre + ", segundoNombre=" + segundoNombre
				+ ", primerApellido=" + primerApellido + ", segundoApellido=" + segundoApellido + ", telefono="
				+ telefono + ", email=" + email + ", usuario=" + usuario + "]";
	}	

}
