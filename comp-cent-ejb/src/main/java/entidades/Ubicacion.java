package entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Ubicacion {
	
	@Id 
	@GeneratedValue
	private long id;
	private String descripcion;
	
	@OneToOne
	private Vacunatorio vacunatorio;
	
	public Ubicacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ubicacion(long id, String descripcion) {
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

	public Vacunatorio getVacunatorio() {
		return vacunatorio;
	}

	public void setVacunatorio(Vacunatorio vacunatorio) {
		this.vacunatorio = vacunatorio;
	}
	
	

}
