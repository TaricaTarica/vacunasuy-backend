package datatypes;

import java.io.Serializable;

import entidades.Ubicacion;

public class DTUbicacion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String description;
	
	private DTVacunatorio vacunatorio;

	public DTUbicacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DTUbicacion(String description) {
		super();
		this.description = description;
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

	@Override
	public String toString() {
		return description;
	}	

}
