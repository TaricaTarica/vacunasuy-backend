package entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import datatypes.DTAgenda;
import enumeradores.Horario;

@Entity
public class Agenda {
	@Id 
	@GeneratedValue
	private long id;
	
	//private Vacunatorio vacunatorio;
	//private Plan plan;
	private LocalDate inicio;
	private LocalDate fin;
	@Enumerated(value = EnumType.STRING)
	private Horario horario;
	
	@OneToMany(mappedBy="agenda",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Evento> eventos = new ArrayList<>();
	
	@OneToOne
	private Vacunatorio vacunatorio;
	
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private List<PlanVacunacion> planes = new ArrayList<>();
	
	public Agenda() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Agenda(LocalDate inicio, LocalDate fin, Horario horario) {
		super();
		this.inicio = inicio;
		this.fin = fin;
		this.horario = horario;
	}

	public Agenda(DTAgenda agenda) {
		super();
		this.inicio = agenda.getInicio();
		this.fin = agenda.getFin();
		this.horario = agenda.getHorario();
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
	
	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public List<PlanVacunacion> getPlanes() {
		return planes;
	}

	public void setPlanes(List<PlanVacunacion> planes) {
		this.planes = planes;
	}

	public void agregarEvento(Evento evento) {
		eventos.add(evento);
		evento.setAgenda(this);
	}
	public void eliminarEvento(Evento evento) {
		eventos.remove(evento);
		evento.setAgenda(null);
	}

	public Vacunatorio getVacunatorio() {
		return vacunatorio;
	}

	public void setVacunatorio(Vacunatorio vacunatorio) {
		this.vacunatorio = vacunatorio;
	}
	
	public void agregarPlan(PlanVacunacion plan) {
		planes.add(plan);
		plan.getAgendas().add(this);
	}
	public void eliminarPlan(PlanVacunacion plan) {
		planes.remove(plan);
		plan.getAgendas().remove(this);
	}
	
}
