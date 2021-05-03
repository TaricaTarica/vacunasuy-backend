package entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import datatypes.DTVacunatorio;

@Entity
public class Vacunatorio {
	@Id 
	@GeneratedValue
	private long id;
	private String nombre;
	private String codigo;
	
	public Vacunatorio() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Vacunatorio(DTVacunatorio vacunatorio) {
		super();
		this.nombre = vacunatorio.getNombre();
		this.codigo = vacunatorio.getCodigo();
	}
	
	public Vacunatorio(String nombre, String codigo, String laboratorio) {
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
