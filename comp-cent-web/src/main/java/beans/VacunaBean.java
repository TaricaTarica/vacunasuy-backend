package beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import datatypes.DTEnfermedad;
import datatypes.DTProveedor;
import datatypes.DTVacuna;
import negocio.EnfermedadNegocioLocal;
import negocio.ProveedorNegocioLocal;
import negocio.VacunaNegocioLocal;



@Named("vacunaBean")
@RequestScoped
public class VacunaBean implements  Serializable{
	
	private static final long serialVersionUID = 1L;

	 @Inject
	 private VacunaNegocioLocal vacunaLocal;
	 
	 @Inject
	 private EnfermedadNegocioLocal enfermedadLocal;
	 
	 @Inject
	 private ProveedorNegocioLocal proveedorLocal;
	 
	 private DTVacuna vacuna;
	 private List<DTVacuna> vacunas;
	 private DTProveedor proveedor;
	 private List<DTProveedor> proveedores;
	 
	 private DTEnfermedad enfermedad;
	 private List<DTEnfermedad> enfermedades;
	
	 private String nombreEnfermedad;
	 private String nombreProveedor;
		
	 @PostConstruct
	 public void init() {
		 
		 this.setEnfermedades(enfermedadLocal.listarEnfermedades());
		 this.setVacunas(vacunaLocal.obtenerVacunas());
		 this.vacunas = vacunaLocal.obtenerVacunas();
		 this.proveedores = proveedorLocal.obtenerProveedores();
		 
		 proveedor = new DTProveedor();
		 setEnfermedad(new DTEnfermedad());
		 vacuna = new DTVacuna();
	 }


	public DTVacuna getVacuna() {
		return vacuna;
	}


	public void setVacuna(DTVacuna vacuna) {
		this.vacuna = vacuna;
	}


	public List<DTVacuna> getVacunas() {
		return vacunas;
	}


	public void setVacunas(List<DTVacuna> vacunas) {
		this.vacunas = vacunas;
	}


	public DTProveedor getProveedor() {
		return proveedor;
	}


	public void setProveedor(DTProveedor proveedor) {
		this.proveedor = proveedor;
	}


	public List<DTProveedor> getProveedores() {
		return proveedores;
	}


	public void setProveedores(List<DTProveedor> proveedores) {
		this.proveedores = proveedores;
	}
	 

	public void reiniciarVacuna(){
		this.vacuna = new DTVacuna();
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

	public String getNombreEnfermedad() {
		return nombreEnfermedad;
	}


	public void setNombreEnfermedad(String nombreEnfermedad) {
		this.nombreEnfermedad = nombreEnfermedad;
	}


	public String getNombreProveedor() {
		return nombreProveedor;
	}


	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}
	
	
	public void agregarVacuna() throws Exception {
		DTProveedor proAux = new DTProveedor();
		DTEnfermedad enfAux = new DTEnfermedad();
		for (DTEnfermedad enf: enfermedades) {
			if (enf.getNombre().equals(nombreEnfermedad)) {
				enfAux = enf;
			System.out.println(enfAux.getNombre());
			}
		} 
		vacuna.setEnfermedad(enfAux);
		for (DTProveedor pro: proveedores) {
			if (pro.getNombre().equals(nombreProveedor)) {
				proAux = pro;
			System.out.println(proAux.getNombre());
			}
		} 
		vacuna.setProveedor(proAux);
		try {
			vacunaLocal.agregarVacuna(vacuna);
			vacunas.add(vacuna);
			
		} catch (Exception e){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(),"" ));
			
		}
		System.out.println(vacuna.getEnfermedad().getNombre());
		System.out.println(vacuna.getProveedor().getNombre());
		System.out.println(vacuna.getProveedor().getId());
		this.vacuna=null;
		
	}


}
