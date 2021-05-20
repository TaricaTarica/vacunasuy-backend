package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import datatypes.DTEnfermedad;
import datatypes.DTPlanVacunacion;
import datatypes.DTVacuna;
import negocio.EnfermedadNegocioLocal;
import negocio.PlanVacunacionNegocioLocal;
import negocio.VacunaNegocioLocal;

@Named("planVacunacionBean")
@ViewScoped
public class PlanVacunacionBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private EnfermedadNegocioLocal enfermedadLocal;
	@EJB
	private VacunaNegocioLocal vacunaLocal;
	@EJB
	private PlanVacunacionNegocioLocal planLocal;
	
	
	
	
	private DTEnfermedad enfermedad;
	private List<DTEnfermedad> enfermedades;
	private List<DTPlanVacunacion> planesVacunaciones;
	private DTVacuna vacuna;
	private DTPlanVacunacion planVacunacion;
	private List<DTVacuna> vacunas;
	private List<DTVacuna> vacunasEnPlan;
	
	private String nombreEnfermedad;
	private String nombrePlan;
	private String[] nombreVacuna;
	private String poblacion;
	private List<String> poblaciones;
	
	@PostConstruct
	public void init() {
		enfermedades = enfermedadLocal.listarEnfermedades();
		planesVacunaciones = planLocal.listarPlanesDeVacunacion();
		enfermedad = new DTEnfermedad();
		vacuna = new DTVacuna();
		planVacunacion = new DTPlanVacunacion();
		poblaciones = enfermedadLocal.listarPoblacionObjetivo();
		
	}
	

	public String getNombreEnfermedad() {
		return nombreEnfermedad;
	}

	public void setNombreEnfermedad(String nombreEnfermedad) {
		this.nombreEnfermedad = nombreEnfermedad;
	}
	
	

	


	public String[] getNombreVacuna() {
		return nombreVacuna;
	}


	public void setNombreVacuna(String[] nombreVacuna) {
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


	





	public DTPlanVacunacion getPlanVacunacion() {
		return planVacunacion;
	}


	public void setPlanVacunacion(DTPlanVacunacion planVacunacion) {
		this.planVacunacion = planVacunacion;
	}
	
	


	public List<DTPlanVacunacion> getPlanesVacunaciones() {
		return planesVacunaciones;
	}


	public void setPlanesVacunaciones(List<DTPlanVacunacion> planesVacunaciones) {
		this.planesVacunaciones = planesVacunaciones;
	}
	
	
	public List<DTVacuna> getVacunasEnPlan() {
		return vacunasEnPlan;
	}


	public void setVacunasEnPlan(List<DTVacuna> vacunasEnPlan) {
		this.vacunasEnPlan = vacunasEnPlan;
	}
	


	public String getNombrePlan() {
		return nombrePlan;
	}


	public void setNombrePlan(String nombrePlan) {
		this.nombrePlan = nombrePlan;
	}


	public void cargarVacunasPlan(DTPlanVacunacion planVac) {
		vacunasEnPlan =  planVac.getVacunas();
	}


	public void cargarVacunas() throws Exception {
        if (nombreEnfermedad != null && !nombreEnfermedad.equals("")) {
        	vacunas = enfermedadLocal.listarVacunasPorEnfermedad(nombreEnfermedad);
        }else {
        	vacunas = new ArrayList<DTVacuna>();
        }
    }
	
	public void addMessage(FacesMessage.Severity severity, String summary, String detail) {
        FacesContext.getCurrentInstance().
                addMessage(null, new FacesMessage(severity, summary, detail));
    }
	
	public void buscarPlan () throws Exception {
		try {
		planVacunacion = planLocal.obtenerPlanVacunacion(nombrePlan);
		} catch (Exception e) {
    		this.planVacunacion = null;
    	}
	}
		
	
	public void agregarPlanVacunacion () throws Exception {
		
		DTEnfermedad enfAux = new DTEnfermedad();
		List<DTVacuna> vacAux = new ArrayList<DTVacuna>();
		
		if (planVacunacion.getEdadMinima() > planVacunacion.getEdadMaxima()) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Edad Minima no puede ser mayor a Edad Maxima", ""));
		}
		else {
		
				for (DTEnfermedad enf: enfermedades) {
					if (enf.getNombre().equals(nombreEnfermedad))
						enfAux = enf;
				}
				planVacunacion.setEnfermedad(enfAux);
				
				for (DTVacuna vac: vacunas) {
					for (String nombreV: nombreVacuna) {
						if (vac.getNombre().equals(nombreV)) {
							vacAux.add(vac);
						}
					}
					
				}
				planVacunacion.setVacunas(vacAux);
				try {
				planLocal.agregarPlanVacunacion(planVacunacion);
				planesVacunaciones.add(planVacunacion);
			    this.planVacunacion = null;
			    PrimeFaces.current().executeScript("PF('planDialog').hide()");
			    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Plan agregado correctamente","" ));
				} catch (Exception e){
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(),"" ));
						
				}
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
	
	public void reiniciarPlan(){
        this.planVacunacion = new DTPlanVacunacion();
    }

}
