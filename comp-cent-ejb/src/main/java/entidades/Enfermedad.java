package entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import datatypes.DTEnfermedad;

@Entity
public class Enfermedad {
	@Id 
	@GeneratedValue
	private long id;
	private String nombre;
	private LocalDate fechaCreacion;
	
	@OneToMany(mappedBy="enfermedad",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Vacuna> vacunas = new ArrayList<>();
	
	@OneToMany(mappedBy="enfermedad",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<PlanVacunacion> planes = new ArrayList<>();

	public Enfermedad() {
		// TODO Auto-generated constructor stub
	}


	public Enfermedad(DTEnfermedad enfermedad) {
		super();
		this.nombre = enfermedad.getNombre();
		this.fechaCreacion = LocalDate.parse(enfermedad.getFechaCreacion());
	}
	
	public Enfermedad(String nombre, LocalDate fecha) {
		super();
		this.nombre = nombre;
		this.fechaCreacion = fecha;
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


	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	public List<Vacuna> getVacunas() {
		return vacunas;
	}


	public void setVacunas(List<Vacuna> vacunas) {
		this.vacunas = vacunas;
	}

	public void agregarVacuna(Vacuna vacuna) {
		vacunas.add(vacuna);
		vacuna.setEnfermedad(this);
	}
	public void eliminarVacuna(Vacuna vacuna) {
		vacunas.remove(vacuna);
		vacuna.setEnfermedad(null);
	}

	public List<PlanVacunacion> getPlanes() {
		return planes;
	}

	public void setPlanes(List<PlanVacunacion> planes) {
		this.planes = planes;
	}
	
	public void agregarPlan(PlanVacunacion plan) {
		planes.add(plan);
		plan.setEnfermedad(this);
	}
	public void eliminarPlan(PlanVacunacion plan) {
		planes.remove(plan);
		plan.setEnfermedad(null);
	}
	
	
}
