package datatypes;

public class DTReservaWS {
	private String ci;
	private String planVacunacion;
	private String Departamento;
	private String Ubicacion;
	
	public DTReservaWS(String ci, String planVacunacion, String departamento, String ubicacion) {
		super();
		this.ci = ci;
		this.planVacunacion = planVacunacion;
		Departamento = departamento;
		Ubicacion = ubicacion;
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
		return Departamento;
	}

	public void setDepartamento(String departamento) {
		Departamento = departamento;
	}

	public String getUbicacion() {
		return Ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		Ubicacion = ubicacion;
	}
	
}
