package datatypes;

import java.util.List;

import entidades.Vacunatorio;

public class DTVacunatorio {
	private long id;
	private String nombre;
	private String codigo;
	private int cantidadPuestos;
	private List<DTAgenda> agendas;
	private DTUbicacion ubicacion;
	private String dominio;
	
	public DTVacunatorio() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DTVacunatorio(Vacunatorio vacunatorio) {
		super();
		this.id = vacunatorio.getId();
		this.nombre = vacunatorio.getNombre();
		this.codigo = vacunatorio.getCodigo();
		this.cantidadPuestos = vacunatorio.getCantidadPuestos();
		this.ubicacion = new DTUbicacion();
		this.dominio = vacunatorio.getDominio();
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

	public List<DTAgenda> getAgendas() {
		return agendas;
	}

	public void setAgendas(List<DTAgenda> agendas) {
		this.agendas = agendas;
	}

	public int getCantidadPuestos() {
		return cantidadPuestos;
	}

	public void setCantidadPuestos(int cantidadPuestos) {
		this.cantidadPuestos = cantidadPuestos;
	}

	public DTUbicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(DTUbicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}
	


	

	@Override
	public String toString() {
		return getNombre();
	}
	
	
	
	
	
}
