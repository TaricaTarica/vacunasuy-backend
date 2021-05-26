package datatypes;

import java.util.List;

import entidades.PlanVacunacion;
import enumeradores.PoblacionObjetivo;

public class DTPlanVacunacion {
	private long id;
	private String nombre;
	private PoblacionObjetivo poblacionObjetivo; 
	int edadMinima;
	int edadMaxima;
	private DTEnfermedad enfermedad;
	private List<DTVacuna> vacunas;
	
	public DTPlanVacunacion() {
		// TODO Auto-generated constructor stub
	}
	
	public DTPlanVacunacion(PlanVacunacion plan) {
		super();
		this.id = plan.getId();
		this.nombre = plan.getNombre();
		this.poblacionObjetivo = plan.getPoblacionObjetivo();
		this.edadMinima = plan.getEdadMinima();
		this.edadMaxima = plan.getEdadMaxima();
		
		//this.enfermedad = plan.getDTEnfermedad; // para despues
		//this.vacuna = plan.getDTVacuna; // para despues
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

	public PoblacionObjetivo getPoblacionObjetivo() {
		return poblacionObjetivo;
	}

	public void setPoblacionObjetivo(PoblacionObjetivo poblacionObjetivo) {
		this.poblacionObjetivo = poblacionObjetivo;
	}

	

	public int getEdadMinima() {
		return edadMinima;
	}

	public void setEdadMinima(int edadMinima) {
		this.edadMinima = edadMinima;
	}

	public int getEdadMaxima() {
		return edadMaxima;
	}

	public void setEdadMaxima(int edadMaxima) {
		this.edadMaxima = edadMaxima;
	}

	public DTEnfermedad getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(DTEnfermedad enfermedad) {
		this.enfermedad = enfermedad;
	}

	public List<DTVacuna> getVacunas() {
		return vacunas;
	}

	
	
	public void setVacunas(List<DTVacuna> vacunas) {
		this.vacunas = vacunas;
	}

}
