package datatypes;

public class DTRegistroVacuna {
	private int cedula;
	private long idVacuna;
	private long idVacunatorio;
	private String fecha;
	public DTRegistroVacuna() {
		// TODO Auto-generated constructor stub
	}
	
	public DTRegistroVacuna(int cedula, long idVacuna, long idVacunatorio, String fecha) {
		super();
		this.cedula = cedula;
		this.idVacuna = idVacuna;
		this.idVacunatorio = idVacunatorio;
		this.fecha = fecha;
	}

	public int getCedula() {
		return cedula;
	}
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
	public long getIdVacuna() {
		return idVacuna;
	}
	public void setIdVacuna(long idVacuna) {
		this.idVacuna = idVacuna;
	}
	public long getIdVacunatorio() {
		return idVacunatorio;
	}
	public void setIdVacunatorio(long idVacunatorio) {
		this.idVacunatorio = idVacunatorio;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

}
