package datatypes;

import java.time.LocalDate;

import entidades.Lote;

public class DTLote {
	public long id;
	public String nombre;
	public LocalDate fechaCreado;
	//public Vacuna vacuna;
	
	public DTLote() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DTLote(long id, String nombre, LocalDate fechaCreado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaCreado = fechaCreado;
	}
	
	public DTLote(Lote lote) {
		super();
		this.id = lote.getId();
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
