package entidades;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import datatypes.DTLote;

@Entity
public class Lote {
	@Id 
	@GeneratedValue
	private long id;
	
	private String nombre;
	private LocalDate fechaCreado;
	//public Vacuna vacuna;
	
	public Lote() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Lote(String nombre, LocalDate fechaCreado) {
		super();
		this.nombre = nombre;
		this.fechaCreado = fechaCreado;
	}
	
	public Lote(DTLote lote) {
		super();
		this.nombre = lote.getNombre();
		this.fechaCreado = lote.getFechaCreado();
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

	public LocalDate getFechaCreado() {
		return fechaCreado;
	}

	public void setFechaCreado(LocalDate fechaCreado) {
		this.fechaCreado = fechaCreado;
	}
	
}
