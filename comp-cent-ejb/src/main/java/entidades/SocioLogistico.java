package entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import datatypes.DTSocioLogistico;

@Entity
public class SocioLogistico {
	
	@Id 
	@GeneratedValue
	private long id;
	private String nombre;
	private String matricula;
	private String transportista;
	
	@OneToMany(mappedBy="socio",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<LogisticaDistribucion> logisticas = new ArrayList<>();
	
	@ManyToMany(mappedBy="socios")
	private List<Administrador> administradores = new ArrayList<>();
	
	public SocioLogistico() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public SocioLogistico(DTSocioLogistico socioLogistico) {
		super();
		this.nombre = socioLogistico.getNombre();
		this.matricula = socioLogistico.getMatricula();
		this.transportista = socioLogistico.getTransportista();
	}
	
	public SocioLogistico(String nombre, String matricula, String transportista) {
		super();
		this.nombre = nombre;
		this.matricula = matricula;
		this.transportista = transportista;
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

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getTransportista() {
		return transportista;
	}

	public void setTransportista(String transportista) {
		this.transportista = transportista;
	}
	
	public List<LogisticaDistribucion> getLogisticas() {
		return logisticas;
	}

	public void setLogisticas(List<LogisticaDistribucion> logisticas) {
		this.logisticas = logisticas;
	}

	public List<Administrador> getAdministradores() {
		return administradores;
	}

	public void setAdministradores(List<Administrador> administradores) {
		this.administradores = administradores;
	}

	public void agregarLogistica(LogisticaDistribucion logistica) {
		logisticas.add(logistica);
		logistica.setSocio(this);
	}
	public void eliminarLogistica(LogisticaDistribucion logistica) {
		logisticas.remove(logistica);
		logistica.setSocio(null);
	}
	
}
