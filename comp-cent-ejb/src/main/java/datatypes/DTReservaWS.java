package datatypes;

public class DTReservaWS {
	private String ci;
	private String planVacunacion;
	private String departamento;
	private String ubicacion;
	
	public DTReservaWS(String ci, String planVacunacion, String departamento, String ubicacion) {
		super();
		this.ci = ci;
		this.planVacunacion = planVacunacion;
		this.departamento = departamento;
		this.ubicacion = ubicacion;
	}

	public DTReservaWS() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCi() {
		return ci;
	}

	public void setCi(String ci) {
		this.ci = ci;
	}

	public String getPlanVacunacion() {
		return planVacunacion;
	}

	public void setPlanVacunacion(String planVacunacion) {
		this.planVacunacion = planVacunacion;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
	
}
