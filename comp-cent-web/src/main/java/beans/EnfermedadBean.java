package beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

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
	
	public void reiniciarEnfermedad(){
        this.enfermedad = new DTEnfermedad();
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
		enfermedadLocal.agregarEnfermedad(enfermedad.getNombre());
		enfermedades.add(enfermedad);
	}
	
}
