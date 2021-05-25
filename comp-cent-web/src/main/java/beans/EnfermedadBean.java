package beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import datatypes.DTEnfermedad;
import negocio.EnfermedadNegocioLocal;

@Named("enfermedadBean")
@ViewScoped
public class EnfermedadBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private EnfermedadNegocioLocal enfermedadLocal;
	
	
	private DTEnfermedad enfermedad;
	private List<DTEnfermedad> enfermedades;
	private String nombre;
	
	
	 //Agrego String para saber el estado del botón
	 
	 private String nombreBoton;
	 private String estiloBoton;
	 private Boolean editar;
	
	 
	 
	@PostConstruct
	public void init() {
		this.enfermedades = enfermedadLocal.listarEnfermedades();

	}

	public DTEnfermedad getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(DTEnfermedad enfermedad) {
		this.enfermedad = enfermedad;
		
	}

	public List<DTEnfermedad> getEnfermedades() {
		return enfermedades;
	}

	public void setEnfermedades(List<DTEnfermedad> enfermedades) {
		this.enfermedades = enfermedades;
	}
	
	

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void eliminarEnfermedad(DTEnfermedad dtEnfermedad) throws Exception{
		
		try {
			enfermedadLocal.eliminarEnfermedad(dtEnfermedad.getNombre());
			this.enfermedades.remove(dtEnfermedad);
			dtEnfermedad = null;
		}catch (Exception e){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
	        FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public void agregarEnfermedad() throws Exception {
		
		//SimpleDateFormat conver = new SimpleDateFormat("dd-MM-yyyy");
//		LocalDate fecAux=LocalDate.parse(fechaCreacion);
//		Enfermedad enf = new Enfermedad(nombre,fecAux);
		try {
			if(editar) {
				enfermedadLocal.editarEnfermedad(enfermedad);
				this.enfermedad = null;
				PrimeFaces.current().executeScript("PF('EnfermedadDialog').hide()");
			    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Proveedor editado correctamente","" ));
				
			}else{
				enfermedadLocal.agregarEnfermedad(enfermedad.getNombre());
				enfermedades.add(enfermedad);
				this.enfermedad = null;
			}
		}catch (Exception e){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(),"" ));
			
		}
	}
	

	public String getNombreBoton() {
		return nombreBoton;
	}

	public void setNombreBoton(String nombreBoton) {
		this.nombreBoton = nombreBoton;
	}

	public String getEstiloBoton() {
		return estiloBoton;
	}

	public void setEstiloBoton(String estiloBoton) {
		this.estiloBoton = estiloBoton;
	}

	public Boolean getEditar() {
		return editar;
	}

	public void setEditar(Boolean editar) {
		this.editar = editar;
	}
	
	public void editarEnfermedadBean(DTEnfermedad dtenf) {
		editar = true;
		this.nombreBoton = "Editar Enfermedad";
		this.estiloBoton = "pi pi-pencil";
		setEnfermedad(dtenf);
	}
	
	public void reiniciarEnfermedad(){
		editar = false;   
		this.nombreBoton = "Agregar Enfermedad";
		this.estiloBoton = "pi pi-check";
        this.enfermedad = new DTEnfermedad();
    }
	
}
