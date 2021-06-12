package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import datatypes.DTSocioLogistico;

@Entity
public class SocioLogistico {
	
	@Id 
	@GeneratedValue
	private long id;
	@Column(unique = true)
	private String codigo;
	private String nombre;
	
	public SocioLogistico() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SocioLogistico(DTSocioLogistico socioLogistico) {
		super();
		this.nombre = socioLogistico.getNombre();
		this.codigo = socioLogistico.getCodigo();
	}
	
	public SocioLogistico(String nombre, String codigo) {
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
