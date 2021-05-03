package entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import datatypes.DTLogisticaDistribucion;

@Entity
public class LogisticaDistribucion {
	@Id 
	@GeneratedValue
	private long id;
	private String nombre;
	private String codigo;
	
	public LogisticaDistribucion() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LogisticaDistribucion(DTLogisticaDistribucion logisticaDistribucion) {
		super();
		this.nombre = logisticaDistribucion.getNombre();
		this.codigo = logisticaDistribucion.getCodigo();
	}

	public LogisticaDistribucion(String nombre, String codigo) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
}
