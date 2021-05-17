package entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import datatypes.DTVacunador;


@Entity
@DiscriminatorValue("V")
public class Vacunador extends Usuario {



	public Vacunador() {
		super();
	}

	public Vacunador(int ci, String nombre, int telefono, String email) {
		super(ci, nombre, telefono, email);
		// TODO Auto-generated constructor stub
	}

	public Vacunador (DTVacunador dtVacunador) {
		super(dtVacunador.getCi(), dtVacunador.getNombre(), dtVacunador.getTelefono(), 
				dtVacunador.getEmail());
	}
	
}
