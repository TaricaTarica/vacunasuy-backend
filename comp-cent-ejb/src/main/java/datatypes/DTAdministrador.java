package datatypes;

import entidades.Administrador;

public class DTAdministrador {
	
	private int ci;
	private String nombre;
	private int telefono;
	private String email;
	private String user;
	private String pass;

	public DTAdministrador() {
		// TODO Auto-generated constructor stub
	}
	
	public DTAdministrador(int ci, String nombre, int telefono, String email, String usr, String pass) {
		super();
		this.ci = ci;
		this.nombre = nombre;
		this.telefono = telefono;
		this.email = email;
		this.user = usr;
		this.pass = pass;
		
	}
	
	public DTAdministrador(Administrador adm) {
		this.ci = adm.getCi();
		this.nombre = adm.getNombre();
		this.telefono = adm.getTelefono();
		email = adm.getEmail();
		pass = adm.getContraseniaAdmin();
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
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
