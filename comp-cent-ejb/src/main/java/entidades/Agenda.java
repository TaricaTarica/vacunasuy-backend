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
	
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Departamento> departamentos = new ArrayList<>();
	
	@OneToMany(mappedBy="agenda",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Evento> eventos = new ArrayList<>();
	
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Vacunatorio> vacunatorios = new ArrayList<>();
	
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private List<PlanVacunacion> planes = new ArrayList<>();
	
	@ManyToMany(mappedBy="agendas")
	private List<Autoridad> autoridades = new ArrayList<>();
	
	@ManyToMany(mappedBy="agendas")
	private List<Vacunador> vacunadores = new ArrayList<>();
	
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

	public List<Departamento> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(List<Departamento> departamentos) {
		this.departamentos = departamentos;
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

	public void agregarDepartamento(Departamento departamento) {
		departamentos.add(departamento);
		departamento.getAgendas().add(this);
	}
	public void eliminarDepartamento(Departamento departamento) {
		departamentos.remove(departamento);
		departamento.getAgendas().remove(this);
	}
	
	public void agregarEvento(Evento evento) {
		eventos.add(evento);
		evento.setAgenda(this);
	}
	public void eliminarEvento(Evento evento) {
		eventos.remove(evento);
		evento.setAgenda(null);
	}

	public List<Vacunatorio> getVacunatorios() {
		return vacunatorios;
	}

	public void setVacunatorios(List<Vacunatorio> vacunatorios) {
		this.vacunatorios = vacunatorios;
	}
	
	public void agregarVacunatorio(Vacunatorio vacunatorio) {
		vacunatorios.add(vacunatorio);
		vacunatorio.getAgendas().add(this);
	}
	public void eliminarVacunatorio(Vacunatorio vacunatorio) {
		vacunatorios.remove(vacunatorio);
		vacunatorio.getAgendas().remove(this);
	}
	
	public void agregarPlan(PlanVacunacion plan) {
		planes.add(plan);
		plan.getAgendas().add(this);
	}
	public void eliminarPlan(PlanVacunacion plan) {
		planes.remove(plan);
		plan.getAgendas().remove(this);
	}

	public List<Autoridad> getAutoridades() {
		return autoridades;
	}

	public void setAutoridades(List<Autoridad> autoridades) {
		this.autoridades = autoridades;
	}

	public List<Vacunador> getVacunadores() {
		return vacunadores;
	}

	public void setVacunadores(List<Vacunador> vacunadores) {
		this.vacunadores = vacunadores;
	}
	
}
