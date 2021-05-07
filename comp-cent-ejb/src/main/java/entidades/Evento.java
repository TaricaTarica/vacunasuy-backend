package entidades;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Evento {
	
	@Id 
	@GeneratedValue
	private long id;
	private String descripcion;
	private LocalDate fechaCreacion;
	
	public Evento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Evento(long id, String descripcion, LocalDate fechaCreacion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.fechaCreacion = fechaCreacion;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	@Override
	public String toString() {
		return "Evento [id=" + id + ", descripcion=" + descripcion + ", fechaCreacion=" + fechaCreacion + "]";
	}
	
	

}
