package entidades;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import datatypes.DTVacunador;

@Entity
@DiscriminatorValue("vacunador")
public class Vacunador extends Usuario {

	public Vacunador() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Vacunador(int ci, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido,
			int telefono, String email) {
		super(ci, primerNombre, segundoNombre, primerApellido, segundoApellido, telefono, email);
		// TODO Auto-generated constructor stub
	}

}
