package beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import datatypes.DTProveedor;
import negocio.ProveedorNegocioLocal;

@Named("proveedorBean")
@ViewScoped
public class ProveedorBean implements  Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ProveedorNegocioLocal proveedorLocal;
	
	DTProveedor proveedor;
	List<DTProveedor> proveedores;
	long idProveedor;
	String nombreProveedor;
	int telProveedor;
	
	 //Agrego String para saber el estado del botón
	 
	 private String nombreBoton;
	 private String estiloBoton;
	 private Boolean editar;
	


	@PostConstruct
	public void init() {
			 
		 this.proveedores = proveedorLocal.obtenerProveedores();			 
		 proveedor = new DTProveedor();
			 
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
	public long getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(long idProveedor) {
		this.idProveedor = idProveedor;
	}
	public String getNombreProveedor() {
		return nombreProveedor;
	}
	public void setNombreProveedor(String nombreProveedor) {
		this.nombreProveedor = nombreProveedor;
	}
	public int getTelProveedor() {
		return telProveedor;
	}
	public void setTelProveedor(int telProveedor) {
		this.telProveedor = telProveedor;
	}
	
	public void agregarProveedor() throws Exception {
		try {
			if(editar) {
				proveedorLocal.editarProveedor(proveedor);
				this.proveedor = null;
				PrimeFaces.current().executeScript("PF('VacunaDialog').hide()");
			    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Proveedor editado correctamente","" ));
			}else {
				proveedorLocal.agregarProveedor(proveedor.getNombre(),proveedor.getTelefono());
				proveedores.add(proveedor);
				this.proveedor = null;
			}
		}catch (Exception e){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(),"" ));
			
		}
		
	}
	
	public void eliminarProveedor(DTProveedor dtProveedor) throws Exception {
		try {
			proveedorLocal.eliminarProveedor(dtProveedor);
			this.proveedores.remove(telProveedor);
		}catch (Exception e){
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
	        FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	
	public void editarProveedorBean(DTProveedor dtpro) {
		editar = true;
		this.nombreBoton = "Editar Proveedor";
		this.estiloBoton = "pi pi-pencil";
		setProveedor(dtpro);
	}
	
	public void reiniciarProveedor(){
		editar = false;
		this.proveedor = new DTProveedor();
		this.nombreBoton="Agregar Proveedor";
        this.estiloBoton="pi pi-check";
	}
	
}
