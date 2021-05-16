package beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import datatypes.DTEnfermedad;
import datatypes.DTVacuna;
import negocio.EnfermedadNegocioLocal;
import negocio.VacunaNegocioLocal;




@Named("planVacunacionBean")
@ViewScoped
public class PlanVacunacionBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private EnfermedadNegocioLocal enfermedadLocal;
	@EJB
	private VacunaNegocioLocal vacunaLocal;
	
	
	
	
	private DTEnfermedad enfermedad;
	private List<DTEnfermedad> enfermedades;
	private DTVacuna vacuna;
	private List<DTVacuna> vacunas;
	private String nombreEnfermedad;
	private String nombreVacuna;
	private String poblacion;
	private List<String> poblaciones;
	@PostConstruct
	public void init() {
		enfermedades = enfermedadLocal.listarEnfermedades();
		enfermedad = new DTEnfermedad();
		vacuna = new DTVacuna();
		poblaciones = enfermedadLocal.listarPoblacionObjetivo();
		
	}
	

	public String getNombreEnfermedad() {
		return nombreEnfermedad;
	}

	public void setNombreEnfermedad(String nombreEnfermedad) {
		this.nombreEnfermedad = nombreEnfermedad;
	}
	
	

	public String getNombreVacuna() {
		return nombreVacuna;
	}


	public void setNombreVacuna(String nombreVacuna) {
		this.nombreVacuna = nombreVacuna;
	}


	public List<DTEnfermedad> getEnfermedades(){
		return enfermedades;
	}
	
	public List<DTVacuna> getVacunas() {
		return vacunas;
	}

	public DTEnfermedad getEnfermedad() {
        return this.enfermedad;
    }
	
	public DTVacuna getVacuna() {
		return vacuna;
	}
	
	



	public String getPoblacion() {
		return poblacion;
	}


	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}


	public List<String> getPoblaciones() {
		return poblaciones;
	}


	public void setPoblaciones(List<String> poblaciones) {
		this.poblaciones = poblaciones;
	}


	public void cargarVacunas() throws Exception {
        if (nombreEnfermedad != null && !nombreEnfermedad.equals("")) {
        	vacunas = enfermedadLocal.listarVacunasPorEnfermedad(nombreEnfermedad);
        }else {
        	vacunas = new ArrayList<DTVacuna>();
        }
    }
	
	
	/*
	public void agregarEnfermedad(){
		enfermedad.setFecha(LocalDate.now());
		final Destination destination = queue;
		String nombre= enfermedad.getNombre();
		int codigo= enfermedad.getCodigoEnfermedad();
		String text = codigo+"|"+nombre;
		 this.enfermedades.add(enfermedad);
	     this.enfermedad = null;
		try {
			this.servicioLocal.agregarEnfermedad(enfermedad.getCodigoEnfermedad(),enfermedad.getNombre());
	        this.enfermedades.add(enfermedad);
	        this.enfermedad = null;
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage()));
			this.enfermedad = null;
    	}
		
    }*/
	/*
	public void buscarEnfermedad(){
		try {
		enfermedad = this.servicioLocal.buscarEnfermedad(nombreEnfermedad);
		} catch (Exception e) {
    		this.enfermedad = null;
    	}
    }*/
	
	public void reiniciarEnfermedad(){
        this.enfermedad = new DTEnfermedad();
    }

}
