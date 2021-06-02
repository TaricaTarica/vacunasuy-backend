package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import datatypes.DTEnfermedad;
import datatypes.DTPlanVacunacion;
import datatypes.DTProveedor;
import datatypes.DTVacuna;
import negocio.EnfermedadNegocioLocal;
import negocio.ProveedorNegocioLocal;
import negocio.VacunaNegocioLocal;



@Named("vacunaBean")
@ViewScoped
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
	 
	 //Agrego String para saber el estado del botón
	 
	 private String nombreBoton;
	 private String estiloBoton;
	 private Boolean editar;
		
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


	
	//Me cargo la vacuna seleccionada para modificarla
	
	public void editarVacunaBean(DTVacuna dtVacuna) {

		this.editar = true;
		this.nombreBoton = "Editar Vacuna";
		this.estiloBoton = "pi pi-pencil";
		setVacuna(dtVacuna);
		//nombreEnfermedad = dtVacuna.getEnfermedad().getNombre();
		DTProveedor dtpro = vacunaLocal.obtenerProveedorDeVacuna(dtVacuna.getNombre());
		nombreProveedor = dtpro.getNombre();
		DTEnfermedad dtenf = vacunaLocal.obtenerEnfermedadDeVacuna(dtVacuna.getNombre());
		nombreEnfermedad = dtenf.getNombre();

	}
	
	public void eliminarVacuna(DTVacuna vacuna) throws Exception {
		
		
		System.out.println("Entre en el eliminarVacuna");
		
		try {
			vacunaLocal.eliminarVacuna(vacuna.getNombre());
			this.vacunas.remove(vacuna);
			vacuna = null;
		}catch (Exception e){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
	        FacesContext.getCurrentInstance().addMessage(null, message);
		}
		
	}
	
	public void agregarVacuna() throws Exception {


		DTProveedor proAux = new DTProveedor();
		DTEnfermedad enfAux = new DTEnfermedad();
		for (DTEnfermedad enf: enfermedades) {
			if (enf.getNombre().equals(nombreEnfermedad)) {
				enfAux = enf;
			
			}
		} 
		vacuna.setEnfermedad(enfAux);
		for (DTProveedor pro: proveedores) {
			if (pro.getNombre().equals(nombreProveedor)) {
				proAux = pro;
			
			}
		} 
		vacuna.setProveedor(proAux);
		
		try {
			
				if(editar) {
					System.out.println("Estoy en el if del editar");
					vacunaLocal.editarVacuna(vacuna);
//					this.vacuna=null;
					this.init();
					
					PrimeFaces.current().executeScript("PF('VacunaDialog').hide()");
				    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Vacuna editado correctamente","" ));
				}else {
					
					System.out.println("Estoy en el else agregando vacuna");
					vacunaLocal.agregarVacuna(vacuna);
//					vacunas.add(vacuna);
//					this.vacuna=null;
					this.init();
					
				}
				
			
		} catch (Exception e){
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


	public void reiniciarVacuna(){
		
		
		
		this.vacuna = new DTVacuna();
		this.nombreEnfermedad = null;
		this.nombreProveedor = null;
        this.nombreBoton="Agregar Vacuna";
        this.estiloBoton="pi pi-check";
        this.editar= false;
	}

	
	
}
