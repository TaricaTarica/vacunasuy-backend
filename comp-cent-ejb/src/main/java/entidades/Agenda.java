package entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import datatypes.DTAgenda;

@Entity
public class Agenda {
	@Id 
	@GeneratedValue
	private long id;
	
	//private Vacunatorio vacunatorio;
	//private Plan plan;
	private LocalDate inicio;
	private LocalDate fin;
	private int horaInicio;
	private int horaFin;
	
	@OneToMany(mappedBy="agenda",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Evento> eventos = new ArrayList<>();
	
	@ManyToOne
	private Vacunatorio vacunatorio;
	
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private List<PlanVacunacion> planes = new ArrayList<>();
	
	public Agenda() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Agenda(LocalDate inicio, LocalDate fin, int horaInicio, int horaFin) {
		super();
		this.inicio = inicio;
		this.fin = fin;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}

	public Agenda(DTAgenda agenda) {
		super();
		this.inicio = LocalDate.parse(agenda.getInicio());
		this.fin = LocalDate.parse(agenda.getFin());
		this.horaInicio = agenda.getHoraInicio();
		this.horaFin = agenda.getHoraFin();
		/*
		 * this.planes = new ArrayList<PlanVacunacion>(); this.vacunatorio = new
		 * Vacunatorio(agenda.getDtVacunatorio()); for (DTPlanVacunacion planes :
		 * agenda.getListDtPlanVacunacion()) { PlanVacunacion plan = new
		 * PlanVacunacion(planes); this.agregarPlan(plan);
		 *
		}*/
	}

	public int getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio;
	}

	public int getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(int horaFin) {
		this.horaFin = horaFin;
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
