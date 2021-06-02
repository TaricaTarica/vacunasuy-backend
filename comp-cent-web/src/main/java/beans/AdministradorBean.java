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

import datatypes.DTAdministrador;
import datatypes.DTContrasenia;
import entidades.Administrador;
import negocio.UsuarioNegocioLocal;

@Named("administradorBean")
@ViewScoped
public class AdministradorBean implements Serializable {
	
	private static final long serialVersionUID = -9187425136651928924L;
	
	@EJB
	private UsuarioNegocioLocal usuarioLocal;
	
	private List<DTAdministrador> administradores;
	private int cedulaUsuario;
	private DTAdministrador adminSeleccionado;
	
	private String contrasenia;
	private String nombreBoton;
	private String estiloBoton;
	private Boolean editar;
	private Boolean enabled;
	@PostConstruct
	public void init() {
		administradores = usuarioLocal.mostrarAdministradores();
		
		adminSeleccionado = new DTAdministrador();
	}
	public List<DTAdministrador> getAdministradores() {
		return administradores;
	}
	public void setAdministradores(List<DTAdministrador> administradores) {
		this.administradores = administradores;
	}
	public int getCedulaUsuario() {
		return cedulaUsuario;
	}
	public void setCedulaUsuario(int cedulaUsuario) {
		this.cedulaUsuario = cedulaUsuario;
	}
	public DTAdministrador getAdminSeleccionado() {
		return adminSeleccionado;
	}
	public void setAdminSeleccionado(DTAdministrador adminSeleccionado) {
		this.adminSeleccionado = adminSeleccionado;
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
	public void editarAdministrador(DTAdministrador admin) {
		this.editar= true;
		this.enabled= true;
		this.nombreBoton="Editar Administrador";
		this.estiloBoton="pi pi-pencil";
		setAdminSeleccionado(admin);
		
		
	}
	
	public void eliminarAdminSeleccionado (DTAdministrador admin) {
		try {
			usuarioLocal.eliminarUsuario(admin.getCi());
			this.administradores.remove(admin);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Confirmado", "Administrador eliminado Correctamente");
	        FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (Exception e){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(),"" ));
	 	}	
	}
	
	public void agregarEditarAdministrador () {
		String cedula = Integer.toString(adminSeleccionado.getCi());
		if (cedula.length()!=8) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "la cedula debe ser de 8 digitos (incluyendo digito verificador)", ""));
		}
		else {
			Administrador adminAux = new Administrador(adminSeleccionado.getCi(),adminSeleccionado.getPrimerNombre(),adminSeleccionado.getSegundoNombre(),adminSeleccionado.getPrimerApellido(),adminSeleccionado.getSegundoApellido(),
														adminSeleccionado.getTelefono()	,adminSeleccionado.getEmail(),adminSeleccionado.getUsuario(),adminSeleccionado.getContrasenia());						
			
			try {
				if (editar) {
					usuarioLocal.actualizarDatos(adminAux);
					this.adminSeleccionado = null;
					PrimeFaces.current().executeScript("PF('adminDialog').hide()");
				    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Administrador editado correctamente","" ));	
				}else {
						adminAux.setContrasenia(contrasenia);
						this.contrasenia = null;
						usuarioLocal.registrarUsuario(adminAux);
						administradores.add(adminSeleccionado);
						this.adminSeleccionado = null;
						PrimeFaces.current().executeScript("PF('adminDialog').hide()");
					    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Administrador agregado correctamente","" ));
				  	  }
			 } catch (Exception e){
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(),"" ));
			 	}	
		}
	}
	
	public void buscarAdministrador() {
		this.adminSeleccionado = null;
		try {
		adminSeleccionado = usuarioLocal.obtenerAdministrador(cedulaUsuario);
		}catch (Exception e){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(),"" ));
	 	}
	}
	
	public void cambiarContraseniaAdministrador(){
		DTContrasenia nuevacontrasenia = new DTContrasenia(adminSeleccionado.getCi(),getContrasenia());
		setContrasenia(null);
		try {
			usuarioLocal.editarContraseniaUsuario(nuevacontrasenia);
			PrimeFaces.current().executeScript("PF('adminContraseñaDialog').hide()");
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Contraseña Actualizada","" ));
		}catch (Exception e){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(),"" ));
	 	}	
		
	}
	
	public void reiniciarAdminSeleccionado () {
		this.adminSeleccionado = new DTAdministrador();
		this.cedulaUsuario = 0;
		this.nombreBoton="Agregar Administrador";
        this.estiloBoton="pi pi-check";
		this.editar= false;
		this.enabled= false;
		this.contrasenia= null;
	}

}

