package entidades;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import datatypes.DTAdministrador;

@Entity
@DiscriminatorValue("A")
public class Administrador extends Usuario {

	private static final long serialVersionUID = 1L;

	public Administrador() {
		// TODO Auto-generated constructor stub
	}

	public Administrador(int ci, String nombre, int telefono, String email, String pass) {
		super(ci, nombre, telefono, email, pass);
		// TODO Auto-generated constructor stub
	}
	
	public Administrador (DTAdministrador dtAdm) {
		super(dtAdm.getCi(), dtAdm.getNombre(), dtAdm.getTelefono(), dtAdm.getEmail(), dtAdm.getPass());
	}

}
