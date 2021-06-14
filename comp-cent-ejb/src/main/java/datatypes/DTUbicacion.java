package datatypes;

import java.io.Serializable;

import entidades.Ubicacion;

public class DTUbicacion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String description;
	
	private long id;
	
	private DTVacunatorio vacunatorio;

	public DTUbicacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DTUbicacion(String description, long id) {
		super();
		this.description = description;
		this.id = id;
	}
	
	public DTUbicacion(Ubicacion ubicacion) {
		this.description = ubicacion.getDescripcion();
		this.vacunatorio = new DTVacunatorio(ubicacion.getVacunatorio());
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public DTVacunatorio getVacunatorio() {
		return vacunatorio;
	}

	public void setVacunatorio(DTVacunatorio vacunatorio) {
		this.vacunatorio = vacunatorio;
	}
	



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return description;
	}	

}
