package entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import datatypes.DTVacunatorio;

@Entity
public class Vacunatorio {
	@Id 
	@GeneratedValue
	private long id;
	private String nombre;
	private String codigo;
	
	@OneToMany(mappedBy="vacunatorio",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<LogisticaDistribucion> logisticas = new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Puesto> puestos = new ArrayList<>();
	
	@OneToOne(mappedBy="vacunatorio",
			cascade=CascadeType.ALL,
			orphanRemoval=true,
			fetch=FetchType.LAZY)
	private Ubicacion ubicacion;
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true)
	private  List<Agenda> agendas;
	
	@ManyToMany(mappedBy="vacunatorios")
	private List<Ciudadano> ciudadanos = new ArrayList<>();
	
	@ManyToMany(mappedBy="vacunatorios")
	private List<Administrador> administradores = new ArrayList<>();
	
	public Vacunatorio() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Vacunatorio(DTVacunatorio vacunatorio) {
		super();
		this.nombre = vacunatorio.getNombre();
		this.codigo = vacunatorio.getCodigo();
	}
	
	public Vacunatorio(String nombre, String codigo, String laboratorio) {
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
	
	public List<LogisticaDistribucion> getLogisticas() {
		return logisticas;
	}

	public void setLogisticas(List<LogisticaDistribucion> logisticas) {
		this.logisticas = logisticas;
	}

	public List<Puesto> getPuestos() {
		return puestos;
	}

	public void setPuestos(List<Puesto> puestos) {
		this.puestos = puestos;
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

	public void agregarLogistica(LogisticaDistribucion logistica) {
		logisticas.add(logistica);
		logistica.setVacunatorio(this);
	}
	
	public void eliminarLogistica(LogisticaDistribucion logistica) {
		logisticas.remove(logistica);
		logistica.setVacunatorio(null);
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

	public List<Ciudadano> getCiudadanos() {
		return ciudadanos;
	}

	public void setCiudadanos(List<Ciudadano> ciudadanos) {
		this.ciudadanos = ciudadanos;
	}

	public List<Administrador> getAdministradores() {
		return administradores;
	}

	public void setAdministradores(List<Administrador> administradores) {
		this.administradores = administradores;
	}
	
}
