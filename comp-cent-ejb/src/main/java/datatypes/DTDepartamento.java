package datatypes;

public class DTDepartamento {
	
	String descripcion;

	public DTDepartamento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DTDepartamento(String descripcion) {
		super();
		this.descripcion = descripcion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return descripcion;
	}	

}
