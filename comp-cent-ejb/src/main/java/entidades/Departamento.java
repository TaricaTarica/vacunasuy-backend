package entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Departamento {
	@Id 
	@GeneratedValue
	private long id;
	private String descripcion;
	
	public Departamento() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Departamento(long id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
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
	
	
	
}
