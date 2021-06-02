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


import datatypes.DTAutoridad;
import datatypes.DTContrasenia;
import entidades.Autoridad;
import negocio.UsuarioNegocioLocal;

@Named("autoridadBean")
@ViewScoped
public class AutoridadBean implements Serializable {
	
	private static final long serialVersionUID = -9187425136651928924L;
	
	@EJB
	private UsuarioNegocioLocal usuarioLocal;
	
	private List<DTAutoridad> autoridades;
	private int cedulaUsuario;
	private DTAutoridad autoridadSeleccionado;
	
	private String contrasenia;
	private String nombreBoton;
	private String estiloBoton;
	private Boolean editar;
	private Boolean enabled;
	@PostConstruct
	public void init() {
		autoridades = usuarioLocal.mostrarAutoridades();
		
		autoridadSeleccionado = new DTAutoridad();
	}
	public List<DTAutoridad> getAutoridades() {
		return autoridades;
	}
	public void setAutoridades(List<DTAutoridad> autoridades) {
		this.autoridades = autoridades;
	}
	public int getCedulaUsuario() {
		return cedulaUsuario;
	}
	public void setCedulaUsuario(int cedulaUsuario) {
		this.cedulaUsuario = cedulaUsuario;
	}
	
	public DTAutoridad getAutoridadSeleccionado() {
		return autoridadSeleccionado;
	}
	public void setAutoridadSeleccionado(DTAutoridad autoridadSeleccionado) {
		this.autoridadSeleccionado = autoridadSeleccionado;
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
	
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public void editarAutoridad(DTAutoridad aut) {
		this.editar= true;
		this.enabled= true;
		this.nombreBoton="Editar Autoridad";
		this.estiloBoton="pi pi-pencil";
		setAutoridadSeleccionado(aut);
		
		
	}
	
	public void eliminarAutoridadSeleccionado (DTAutoridad aut) {
		try {
			usuarioLocal.eliminarUsuario(aut.getCi());
			this.autoridades.remove(aut);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Confirmado", "Autoridad eliminado Correctamente");
	        FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (Exception e){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(),"" ));
	 	}	
	}
	
	public void agregarEditarAutoridad () {
		String cedula = Integer.toString(autoridadSeleccionado.getCi());
		if (cedula.length()!=8) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "la cedula debe ser de 8 digitos (incluyendo digito verificador)", ""));
		}
		else {
			Autoridad autoridadAux = new Autoridad(autoridadSeleccionado.getCi(),autoridadSeleccionado.getPrimerNombre(),autoridadSeleccionado.getSegundoNombre(),autoridadSeleccionado.getPrimerApellido(),autoridadSeleccionado.getSegundoApellido(),
					autoridadSeleccionado.getTelefono()	,autoridadSeleccionado.getEmail(),autoridadSeleccionado.getUsuario(),autoridadSeleccionado.getContrasenia());						
			
			try {
				if (editar) {
					usuarioLocal.actualizarDatos(autoridadAux);
					this.autoridadSeleccionado = null;
					PrimeFaces.current().executeScript("PF('autoridadDialog').hide()");
				    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Autoridad editado correctamente","" ));	
				}else {
						autoridadAux.setContrasenia(contrasenia);
						this.contrasenia = null;
						usuarioLocal.registrarUsuario(autoridadAux);
						autoridades.add(autoridadSeleccionado);
						this.autoridadSeleccionado = null;
						PrimeFaces.current().executeScript("PF('autoridadDialog').hide()");
					    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Autoridad agregado correctamente","" ));
				  	  }
			 } catch (Exception e){
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(),"" ));
			 	}	
		}
	}
	
	public void buscarAutoridad() {
		this.autoridadSeleccionado = null;
		try {
			autoridadSeleccionado = usuarioLocal.obtenerAutoridad(cedulaUsuario);
		}catch (Exception e){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(),"" ));
	 	}
	}
	
	public void cambiarContraseniaAutoridad(){
		DTContrasenia nuevacontrasenia = new DTContrasenia(autoridadSeleccionado.getCi(),getContrasenia());
		setContrasenia(null);
		try {
			usuarioLocal.editarContraseniaUsuario(nuevacontrasenia);
			PrimeFaces.current().executeScript("PF('autoridadContraseñaDialog').hide()");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Contraseña Actualizada","" ));
		}catch (Exception e){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(),"" ));
	 	}	
		
	}
	
	public void reiniciarAutoridadSeleccionado () {
		this.autoridadSeleccionado = new DTAutoridad();
		this.cedulaUsuario = 0;
		this.nombreBoton="Agregar Administrador";
        this.estiloBoton="pi pi-check";
		this.editar= false;
		this.enabled= false;
		this.contrasenia= null;
	}

}




