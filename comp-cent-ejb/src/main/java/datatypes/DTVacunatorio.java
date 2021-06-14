package datatypes;

import java.util.List;

import entidades.Vacunatorio;

public class DTVacunatorio {
	private long id;
	private String nombre;
	private String codigo;
	private int cantidadVacunadores;
	private List<DTAgenda> agendas;
	
	public DTVacunatorio() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public DTVacunatorio(Vacunatorio vacunatorio) {
		super();
		this.id = vacunatorio.getId();
		this.nombre = vacunatorio.getNombre();
		this.codigo = vacunatorio.getCodigo();
		this.cantidadVacunadores = vacunatorio.getCantidadVacunadores();
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

	public int getCantidadVacunadores() {
		return cantidadVacunadores;
	}

	public void setCantidadVacunadores(int cantidadVacunadores) {
		this.cantidadVacunadores = cantidadVacunadores;
	}

	@Override
	public String toString() {
		return getNombre();
	}
	
	
	
	
	
}
