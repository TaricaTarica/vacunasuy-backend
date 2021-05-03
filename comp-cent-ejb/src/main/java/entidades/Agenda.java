package entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import datatypes.DTAgenda;
import datatypes.DTVigencia;
import datatypes.Horario;

@Entity
public class Agenda {
	@Id 
	@GeneratedValue
	private long id;
	
	//private Vacunatorio vacunatorio;
	//private Plan plan;
	private DTVigencia diaAtencion;
	private Horario horario;
	
	public Agenda() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Agenda(DTVigencia diaAtencion, Horario horario) {
		super();
		this.diaAtencion = diaAtencion;
		this.horario = horario;
	}
	
	public Agenda(DTAgenda agenda) {
		super();
		this.diaAtencion = agenda.getDiaAtencion();
		this.horario = agenda.getHorario();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public DTVigencia getDiaAtencion() {
		return diaAtencion;
	}

	public void setDiaAtencion(DTVigencia diaAtencion) {
		this.diaAtencion = diaAtencion;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}
	
}
