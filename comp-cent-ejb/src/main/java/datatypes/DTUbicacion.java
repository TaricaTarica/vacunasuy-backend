package datatypes;

import java.io.Serializable;

public class DTUbicacion implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String description;

	public DTUbicacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DTUbicacion(String description) {
		super();
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "DTUbicacion [description=" + description + "]";
	}	

}
