package datatypes;

import java.time.LocalDate;
import java.util.List;

import entidades.Agenda;
import enumeradores.Horario;

public class DTAgenda {
	private long id;
	
	//private Vacunatorio vacunatorio;
	//private Plan plan;
	private LocalDate inicio;
	private LocalDate fin;
	private Horario horario;
	private DTVacunatorio dtVacunatorio;
	private List<DTPlanVacunacion> listDtPlanVacunacion;
	
	public DTAgenda() {
		super();
	}
	
	public DTVacunatorio getDtVacunatorio() {
		return dtVacunatorio;
	}

	public void setDtVacunatorio(DTVacunatorio dtVacunatorio) {
		this.dtVacunatorio = dtVacunatorio;
	}

	public List<DTPlanVacunacion> getListDtPlanVacunacion() {
		return listDtPlanVacunacion;
	}

	public void setListDtPlanVacunacion(List<DTPlanVacunacion> listDtPlanVacunacion) {
		this.listDtPlanVacunacion = listDtPlanVacunacion;
	}

	public DTAgenda(long id, LocalDate inicio, LocalDate fin, Horario horario) {
		super();
		this.id = id;
		this.inicio = inicio;
		this.fin = fin;
		this.horario = horario;
	}

	public DTAgenda(Agenda agenda) {
		super();
		this.id = agenda.getId();
		this.inicio = agenda.getInicio();
		this.fin = agenda.getFin();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDate getInicio() {
		return inicio;
	}

	public void setInicio(LocalDate inicio) {
		this.inicio = inicio;
	}

	public LocalDate getFin() {
		return fin;
	}

	public void setFin(LocalDate fin) {
		this.fin = fin;
	}

	public Horario getHorario() {
		return horario;
	}

	public void setHorario(Horario horario) {
		this.horario = horario;
	}
}
