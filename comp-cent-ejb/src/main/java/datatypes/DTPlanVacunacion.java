package datatypes;

import java.util.List;

import entidades.PlanVacunacion;
import enumeradores.PoblacionObjetivo;

public class DTPlanVacunacion {
	private String nombre;
	private PoblacionObjetivo poblacionObjetivo; 
	private List<Integer> rangoEdad;
	private DTEnfermedad enfermedad;
	private DTVacuna vacuna;
	
	public DTPlanVacunacion() {
		// TODO Auto-generated constructor stub
	}
	
	public DTPlanVacunacion(PlanVacunacion plan) {
		super();
		this.nombre = plan.getNombre();
		this.poblacionObjetivo = plan.getPoblacionObjetivo();
		this.rangoEdad = plan.getRangoEdad();
		//this.enfermedad = plan.getDTEnfermedad; // para despues
		//this.vacuna = plan.getDTVacuna; // para despues
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

	public List<Integer> getRangoEdad() {
		return rangoEdad;
	}

	public void setRangoEdad(List<Integer> rangoEdad) {
		this.rangoEdad = rangoEdad;
	}

	public DTEnfermedad getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(DTEnfermedad enfermedad) {
		this.enfermedad = enfermedad;
	}

	public DTVacuna getVacuna() {
		return vacuna;
	}

	public void setVacuna(DTVacuna vacuna) {
		this.vacuna = vacuna;
	}

	

}
