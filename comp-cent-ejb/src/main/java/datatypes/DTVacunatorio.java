package datatypes;

import java.util.List;

import entidades.Vacunatorio;

public class DTVacunatorio {
	private long id;
	private String nombre;
	private String codigo;
	
	public DTVacunatorio() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DTVacunatorio(Vacunatorio vacunatorio) {
		super();
		this.id = vacunatorio.getId();
		this.nombre = vacunatorio.getNombre();
		this.codigo = vacunatorio.getCodigo();
	}
	
	public DTVacunatorio(String nombre, String codigo) {
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
