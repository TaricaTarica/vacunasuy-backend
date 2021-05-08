package entidades;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
	int edadMinima;
	int edadMaxima;
	@Enumerated(value = EnumType.STRING)
	private PoblacionObjetivo poblacionObjetivo; 
	
	
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
	
	
	
}
