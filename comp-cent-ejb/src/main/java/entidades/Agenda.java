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
	
	public void agregarDepartamento(Departamento departamento) {
		departamentos.add(departamento);
		departamento.getAgendas().add(this);
	}
	public void eliminarDepartamento(Departamento departamento) {
		departamentos.remove(departamento);
		departamento.getAgendas().remove(this);
	}
	
}
