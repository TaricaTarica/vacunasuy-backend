package entidades;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import datatypes.DTVacunador;


@Entity
@DiscriminatorValue("V")
public class Vacunador extends Usuario {

	private static final long serialVersionUID = 1L;

	public Vacunador() {
		// TODO Auto-generated constructor stub
	}

	public Vacunador(int ci, String nombre, int telefono, String email, String pass) {
		super(ci, nombre, telefono, email, pass);
		// TODO Auto-generated constructor stub
	}

	public Vacunador (DTVacunador dtVacunador) {
		super(dtVacunador.getCi(), dtVacunador.getNombre(), dtVacunador.getTelefono(), 
				dtVacunador.getEmail(), dtVacunador.getPass());
	}
	
}
