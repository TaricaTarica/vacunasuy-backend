package entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import datatypes.DTPlanVacunacion;
import enumeradores.PoblacionObjetivo;



@Entity
public class PlanVacunacion {
	@Id 
	@GeneratedValue
	private long id;
	private String nombre;
	private PoblacionObjetivo poblacionObjetivo; 
	private List<Integer> rangoEdad;
	
	public PlanVacunacion() {
		// TODO Auto-generated constructor stub
	}
	
	
	public PlanVacunacion(DTPlanVacunacion plan) {
		super();
		this.nombre = plan.getNombre();
		this.poblacionObjetivo = plan.getPoblacionObjetivo();
		this.rangoEdad = plan.getRangoEdad();
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
	public List<Integer> getRangoEdad() {
		return rangoEdad;
	}
	public void setRangoEdad(List<Integer> rangoEdad) {
		this.rangoEdad = rangoEdad;
	}
	
	
}
