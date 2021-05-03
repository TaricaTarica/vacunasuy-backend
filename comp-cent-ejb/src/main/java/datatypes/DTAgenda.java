package datatypes;

import entidades.Agenda;

public class DTAgenda {
	private long id;
	
	//private Vacunatorio vacunatorio;
	//private Plan plan;
	private DTVigencia diaAtencion;
	private Horario horario;
	
	public DTAgenda() {
		super();
	}
	
	public DTAgenda(long id, DTVigencia diaAtencion, Horario horario) {
		super();
		this.id = id;
		this.diaAtencion = diaAtencion;
		this.horario = horario;
	}
	
	public DTAgenda(Agenda agenda) {
		super();
		this.id = agenda.getId();
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
