package datatypes;

import entidades.Vacuna;

public class DTVacuna {
	private long id;
	private String nombre;
	private String codigo;
	private String laboratorio;
	private int dosis;
	private int periodoInmune;
	
	
	private DTEnfermedad enfermedad;
	private DTProveedor proveedor;
	
	public DTVacuna() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DTVacuna(Vacuna vacuna) {
		super();
		this.id = vacuna.getId();
		this.nombre = vacuna.getNombre();
		this.codigo = vacuna.getCodigo();
		this.laboratorio = vacuna.getLaboratorio();
		this.dosis = vacuna.getDosis();
		this.periodoInmune = vacuna.getPeriodoInmune();
	}
	
	public DTVacuna(String nombre, String codigo, String laboratorio) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.laboratorio = laboratorio;
	}


	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}

	@Override
	public String toString() {
		return nombre;
	}

	public DTEnfermedad getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(DTEnfermedad enfermedad) {
		this.enfermedad = enfermedad;
	}

	public DTProveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(DTProveedor proveedor) {
		this.proveedor = proveedor;
	}

	public int getDosis() {
		return dosis;
	}

	public void setDosis(int dosis) {
		this.dosis = dosis;
	}

	public int getPeriodoInmune() {
		return periodoInmune;
	}

	public void setPeriodoInmune(int periodoInmune) {
		this.periodoInmune = periodoInmune;
	}
	
	
}
