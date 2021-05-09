package entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import datatypes.DTPlanVacunacion;
import enumeradores.PoblacionObjetivo;



@Entity
public class PlanVacunacion {
	@Id 
	@GeneratedValue
	private long id;
	private String nombre;
	int edadMinima;
	int edadMaxima;
	@Enumerated(value = EnumType.STRING)
	private PoblacionObjetivo poblacionObjetivo; 
	
	@ManyToMany(mappedBy="planes")
	private List<Agenda> agendas = new ArrayList<>();
	
	@ManyToOne
	private Enfermedad enfermedad;
	
	@ManyToMany(mappedBy="planes")
	private List<Ciudadano> ciudadanos = new ArrayList<>();
	
	@ManyToMany(mappedBy="planes")
	private List<Autoridad> autoridades = new ArrayList<>();
	
	public PlanVacunacion() {
		// TODO Auto-generated constructor stub
	}
	
	
	public PlanVacunacion(DTPlanVacunacion plan) {
		super();
		this.nombre = plan.getNombre();
		this.poblacionObjetivo = plan.getPoblacionObjetivo();
		this.edadMinima = plan.getEdadMinima();
		this.edadMaxima = plan.getEdadMaxima();
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public PoblacionObjetivo getPoblacionObjetivo() {
		return poblacionObjetivo;
	}
	public void setPoblacionObjetivo(PoblacionObjetivo poblacionObjetivo) {
		this.poblacionObjetivo = poblacionObjetivo;
	}


	public int getEdadMinima() {
		return edadMinima;
	}


	public void setEdadMinima(int edadMinima) {
		this.edadMinima = edadMinima;
	}


	public int getEdadMaxima() {
		return edadMaxima;
	}

	public void setEdadMaxima(int edadMaxima) {
		this.edadMaxima = edadMaxima;
	}

	public List<Agenda> getAgendas() {
		return agendas;
	}

	public void setAgendas(List<Agenda> agendas) {
		this.agendas = agendas;
	}


	public Enfermedad getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(Enfermedad enfermedad) {
		this.enfermedad = enfermedad;
	}

	public List<Ciudadano> getCiudadanos() {
		return ciudadanos;
	}

	public void setCiudadanos(List<Ciudadano> ciudadanos) {
		this.ciudadanos = ciudadanos;
	}

	public List<Autoridad> getAutoridades() {
		return autoridades;
	}

	public void setAutoridades(List<Autoridad> autoridades) {
		this.autoridades = autoridades;
	}
	
		
}
