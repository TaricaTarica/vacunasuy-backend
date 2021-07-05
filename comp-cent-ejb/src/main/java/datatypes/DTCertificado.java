package datatypes;



public class DTCertificado {
	private String cedula;
	private String nombreCompleto;
	private String fechaNacimiento;
	private String fechaVacuna;
	private String idVacuna;
	private String nombreVacuna;
	private String laboratorioVacuna;
	private String codigoVacuna;
	private String cantDosis;
	private String periodoInmunidad;
	private String idEnfermedad;
	private String nombreEnfermedad;
	private String idReserva;
	
	
	
	public DTCertificado() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DTCertificado(String cedula, String nombreCompleto, String fechaNacimiento, String fechaVacuna,
			String idVacuna, String nombreVacuna, String laboratorioVacuna, String codigoVacuna, String cantDosis,
			String periodoInmunidad, String idEnfermedad, String nombreEnfermedad, String idReserva) {
		super();
		this.cedula = cedula;
		this.nombreCompleto = nombreCompleto;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaVacuna = fechaVacuna;
		this.idVacuna = idVacuna;
		this.nombreVacuna = nombreVacuna;
		this.laboratorioVacuna = laboratorioVacuna;
		this.codigoVacuna = codigoVacuna;
		this.cantDosis = cantDosis;
		this.periodoInmunidad = periodoInmunidad;
		this.idEnfermedad = idEnfermedad;
		this.nombreEnfermedad = nombreEnfermedad;
		this.idReserva = idReserva;
	}

	public String getFechaVacuna() {
		return fechaVacuna;
	}
	public void setFechaVacuna(String fechaVacuna) {
		this.fechaVacuna = fechaVacuna;
	}
	public String getIdVacuna() {
		return idVacuna;
	}
	public void setIdVacuna(String idVacuna) {
		this.idVacuna = idVacuna;
	}
	public String getNombreVacuna() {
		return nombreVacuna;
	}
	public void setNombreVacuna(String nombreVacuna) {
		this.nombreVacuna = nombreVacuna;
	}
	public String getLaboratorioVacuna() {
		return laboratorioVacuna;
	}
	public void setLaboratorioVacuna(String laboratorioVacuna) {
		this.laboratorioVacuna = laboratorioVacuna;
	}
	public String getCodigoVacuna() {
		return codigoVacuna;
	}
	public void setCodigoVacuna(String codigoVacuna) {
		this.codigoVacuna = codigoVacuna;
	}
	public String getCantDosis() {
		return cantDosis;
	}
	public void setCantDosis(String cantDosis) {
		this.cantDosis = cantDosis;
	}
	public String getPeriodoInmunidad() {
		return periodoInmunidad;
	}
	public void setPeriodoInmunidad(String periodoInmunidad) {
		this.periodoInmunidad = periodoInmunidad;
	}
	public String getIdEnfermedad() {
		return idEnfermedad;
	}
	public void setIdEnfermedad(String idEnfermedad) {
		this.idEnfermedad = idEnfermedad;
	}
	public String getNombreEnfermedad() {
		return nombreEnfermedad;
	}
	public void setNombreEnfermedad(String nombreEnfermedad) {
		this.nombreEnfermedad = nombreEnfermedad;
	}

	public String getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(String idReserva) {
		this.idReserva = idReserva;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
}
