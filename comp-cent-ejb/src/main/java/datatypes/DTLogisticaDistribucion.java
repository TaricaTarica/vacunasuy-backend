package datatypes;

import entidades.LogisticaDistribucion;


public class DTLogisticaDistribucion {
	private long id;
	private String nombre;
	private String codigo;
	
	
	public DTLogisticaDistribucion() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DTLogisticaDistribucion(LogisticaDistribucion logisticaDistribucion) {
		super();
		this.id = logisticaDistribucion.getId();
		this.nombre = logisticaDistribucion.getNombre();
		this.codigo = logisticaDistribucion.getCodigo();
	}
	
	public DTLogisticaDistribucion(String nombre, String codigo) {
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
