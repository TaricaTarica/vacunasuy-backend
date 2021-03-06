package entidades;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import datatypes.DTVacunatorio;

@Entity
public class Vacunatorio {
	@Id 
	@GeneratedValue
	private long id;
	private String nombre;
	private int cantidadPuestos;
	private String codigo;
	private String dominio;
	
	@OneToOne(mappedBy="vacunatorio",
			cascade=CascadeType.ALL,
			orphanRemoval=true,
			fetch=FetchType.LAZY)
	private Ubicacion ubicacion;
	
	@OneToMany(mappedBy="vacunatorio",cascade=CascadeType.ALL,orphanRemoval=true)
	private  List<Agenda> agendas;
	
	public Vacunatorio() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Vacunatorio(DTVacunatorio vacunatorio) {
		super();
		this.nombre = vacunatorio.getNombre();
		this.codigo = vacunatorio.getCodigo();
		this.cantidadPuestos = vacunatorio.getCantidadPuestos();
		this.dominio = vacunatorio.getDominio();
	}
	
	public Vacunatorio(String nombre, String codigo, int cantPuestos, String dominio) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.cantidadPuestos= cantPuestos;
		this.dominio = dominio;
		
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


	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public List<Agenda> getAgendas() {
		return agendas;
	}

	public void setAgendas(List<Agenda> agendas) {
		this.agendas = agendas;
	}
	
	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public int getCantidadPuestos() {
		return cantidadPuestos;
	}

	public void setCantidadPuestos(int cantidadPuestos) {
		this.cantidadPuestos = cantidadPuestos;
	}

	public void agregarUbicacion(Ubicacion ub) {
		ub.setVacunatorio(this);
		this.ubicacion = ub;
	}
	
	public void eliminarUbicacion() {
		if(ubicacion!=null) {
			ubicacion.setVacunatorio(null);
			this.ubicacion=null;
		}
	}
	
	public void agregarAgenda(Agenda agenda) {
		agendas.add(agenda);
		agenda.setVacunatorio(this);
	}
	
	public void eliminarAgenda(Agenda agenda) {
		agendas.remove(agenda);
		agenda.setVacunatorio(null);
	}
	
}
