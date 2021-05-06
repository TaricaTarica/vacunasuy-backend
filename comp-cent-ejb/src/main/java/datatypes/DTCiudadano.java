package datatypes;

import entidades.Ciudadano;

public class DTCiudadano {

	private int ci;
	private String nombre;
	private int telefono;
	private String Email;
	private String Pass;

	public DTCiudadano() {
		// TODO Auto-generated constructor stub
	}
	
	public DTCiudadano(int ci, String nombre, int telefono, String email, String pass) {
		super();
		this.ci = ci;
		this.nombre = nombre;
		this.telefono = telefono;
		Email = email;
		Pass = pass;
	}
	
	public DTCiudadano(Ciudadano cuidadano) {
		this.ci = cuidadano.getCi();
		this.nombre = cuidadano.getNombre();
		this.telefono = cuidadano.getTelefono();
		Email = cuidadano.getEmail();
	}

	public int getCi() {
		return ci;
	}

	public void setCi(int ci) {
		this.ci = ci;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}


}
