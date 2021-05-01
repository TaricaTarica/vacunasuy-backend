package entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import datatypes.DTVacuna;

@Entity
public class Vacuna {
	@Id 
	@GeneratedValue
	private long id;
	private String nombre;
	private String codigo;
	private String laboratorio;
	
	public Vacuna() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Vacuna(DTVacuna vacuna) {
		super();
		this.nombre = vacuna.getNombre();
		this.codigo = vacuna.getCodigo();
		this.laboratorio = vacuna.getLaboratorio();
	}
	
	public Vacuna(String nombre, String codigo, String laboratorio) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.laboratorio = laboratorio;
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
	public String getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}
	
	
}
