package datatypes;

public class DTStockVacuna {

	private long vacunaId;
	private String codigo;
	private String nombre;
	private String Laboratorio;
	private String Enfermedad;
	private int cant;
	
	public DTStockVacuna() {
		// TODO Auto-generated constructor stub
	}
	
	public DTStockVacuna(long vacunaId, String codigo, String nombre, String laboratorio, String enfermedad, int cant) {
		super();
		this.vacunaId = vacunaId;
		this.codigo = codigo;
		this.nombre = nombre;
		Laboratorio = laboratorio;
		Enfermedad = enfermedad;
		this.cant = cant;
	}
	
	public long getVacunaId() {
		return vacunaId;
	}

	public void setVacunaId(long vacunaId) {
		this.vacunaId = vacunaId;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getLaboratorio() {
		return Laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		Laboratorio = laboratorio;
	}

	public String getEnfermedad() {
		return Enfermedad;
	}

	public void setEnfermedad(String enfermedad) {
		Enfermedad = enfermedad;
	}
	
	public int getCant() {
		return cant;
	}

	public void setCant(int cant) {
		this.cant = cant;
	}
	
}
