package entidades;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import datatypes.DTEnfermedad;

@Entity
public class Enfermedad {
	@Id 
	@GeneratedValue
	private long id;
	private String nombre;
	private LocalDate fechaCreacion;	

	public Enfermedad() {
		// TODO Auto-generated constructor stub
	}


	public Enfermedad(DTEnfermedad enfermedad) {
		super();
		this.nombre = enfermedad.getNombre();
		this.fechaCreacion = LocalDate.parse(enfermedad.getFechaCreacion());
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
	

}
