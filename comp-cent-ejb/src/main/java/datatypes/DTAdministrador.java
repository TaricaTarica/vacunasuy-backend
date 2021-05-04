package datatypes;

import entidades.Administrador;

public class DTAdministrador {
	
	private int ci;
	private String nombre;
	private int telefono;
	private String Email;
	private String Pass;

	public DTAdministrador() {
		// TODO Auto-generated constructor stub
	}
	
	public DTAdministrador(int ci, String nombre, int telefono, String email, String pass) {
		super();
		this.ci = ci;
		this.nombre = nombre;
		this.telefono = telefono;
		Email = email;
		Pass = pass;
	}
	
	public DTAdministrador(Administrador adm) {
		this.ci = adm.getCi();
		this.nombre = adm.getNombre();
		this.telefono = adm.getTelefono();
		Email = adm.getEmail();
		Pass = adm.getPass();
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
