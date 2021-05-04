package datatypes;

import entidades.Vacunador;

public class DTVacunador {

	private int ci;
	private String nombre;
	private int telefono;
	private String Email;
	private String Pass;

	public DTVacunador() {
		// TODO Auto-generated constructor stub
	}
	
	public DTVacunador(int ci, String nombre, int telefono, String email, String pass) {
		super();
		this.ci = ci;
		this.nombre = nombre;
		this.telefono = telefono;
		Email = email;
		Pass = pass;
	}
	
	public DTVacunador(Vacunador vacunador) {
		this.ci = vacunador.getCi();
		this.nombre = vacunador.getNombre();
		this.telefono = vacunador.getTelefono();
		Email = vacunador.getEmail();
		Pass = vacunador.getPass();
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

	public String getPass() {
		return Pass;
	}

	public void setPass(String pass) {
		Pass = pass;
	}

}
