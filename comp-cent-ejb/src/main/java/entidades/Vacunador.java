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

	private static final long serialVersionUID = 1L;
	
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Agenda> agendas = new ArrayList<>();

	public Vacunador() {
		// TODO Auto-generated constructor stub
	}

	public Vacunador(int ci, String nombre, int telefono, String email) {
		super(ci, nombre, telefono, email);
		// TODO Auto-generated constructor stub
	}

	public Vacunador (DTVacunador dtVacunador) {
		super(dtVacunador.getCi(), dtVacunador.getNombre(), dtVacunador.getTelefono(), 
				dtVacunador.getEmail());
	}

	public List<Agenda> getAgendas() {
		return agendas;
	}

	public void setAgendas(List<Agenda> agendas) {
		this.agendas = agendas;
	}
	
	public void agregarAgenda(Agenda agenda) {
		agendas.add(agenda);
		agenda.getVacunadores().add(this);
	}
	public void eliminarAgenda(Agenda agenda) {
		agendas.remove(agenda);
		agenda.getVacunadores().remove(this);
	}
	
}
