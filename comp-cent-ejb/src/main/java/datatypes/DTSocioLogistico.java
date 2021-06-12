package datatypes;

import entidades.SocioLogistico;

public class DTSocioLogistico {
	private long id;
	private String nombre;
	private String codigo;


	public DTSocioLogistico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DTSocioLogistico(SocioLogistico socioLogistico) {
		super();
		this.id = socioLogistico.getId();
		this.nombre = socioLogistico.getNombre();
		this.codigo = socioLogistico.getCodigo();
	}
	
	public DTSocioLogistico(String nombre, String codigo) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
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

}
