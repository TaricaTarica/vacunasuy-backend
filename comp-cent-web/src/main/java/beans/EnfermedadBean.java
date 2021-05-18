package beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import datatypes.DTEnfermedad;
import entidades.Enfermedad;
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
//	private String fechaCreacion;
	
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

//	public String getFechaCreacion() {
//		return fechaCreacion;
//	}

//	public void setFechaCreacion(String fechaCreacion) {
//		this.fechaCreacion = fechaCreacion;
//	}

	public void agregarEnfermedad() throws Exception {
		
		//SimpleDateFormat conver = new SimpleDateFormat("dd-MM-yyyy");
//		LocalDate fecAux=LocalDate.parse(fechaCreacion);
//		Enfermedad enf = new Enfermedad(nombre,fecAux);
		enfermedadLocal.agregarEnfermedad(nombre);
	}
}
