package beans;

import java.util.List;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;


import datatypes.DTVacunador;

import entidades.Vacunador;
import negocio.UsuarioNegocioLocal;

@Named("vacunadorBean")
@ViewScoped
public class VacunadorBean implements Serializable {

private static final long serialVersionUID = -9187425136651928924L;
	
	@EJB
	private UsuarioNegocioLocal usuarioLocal;
	
	private List<DTVacunador> vacunadores;
	private int cedulaUsuario;
	private DTVacunador vacunadorSeleccionado;
	
	
	
	
	
	@PostConstruct
	public void init() {
		vacunadores = usuarioLocal.mostrarVacunadores();
		
		vacunadorSeleccionado = new DTVacunador();
	}
	
	public UsuarioNegocioLocal getUsuarioLocal() {
		return usuarioLocal;
	}

	public void setUsuarioLocal(UsuarioNegocioLocal usuarioLocal) {
		this.usuarioLocal = usuarioLocal;
	}

	public List<DTVacunador> getVacunadores() {
		return vacunadores;
	}

	public void setVacunadores(List<DTVacunador> vacunadores) {
		this.vacunadores = vacunadores;
	}

	public int getCedulaUsuario() {
		return cedulaUsuario;
	}

	public void setCedulaUsuario(int cedulaUsuario) {
		this.cedulaUsuario = cedulaUsuario;
	}

	public DTVacunador getVacunadorSeleccionado() {
		return vacunadorSeleccionado;
	}

	public void setVacunadorSeleccionado(DTVacunador vacunadorSeleccionado) {
		this.vacunadorSeleccionado = vacunadorSeleccionado;
	}
	
	public void eliminarVacunadorSeleccionado (DTVacunador aut) {
		try {
			usuarioLocal.eliminarUsuario(aut.getCi());
			this.vacunadores.remove(aut);
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Confirmado", "Vacunador eliminado Correctamente");
	        FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (Exception e){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(),"" ));
	 	}	
	}
	
	public void editarVacunador () {
		String cedula = Integer.toString(vacunadorSeleccionado.getCi());
		if (cedula.length()!=8) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "la cedula debe ser de 8 digitos (incluyendo digito verificador)", ""));
		}
		else {
			Vacunador vacunadorAux = new Vacunador(vacunadorSeleccionado.getCi(),vacunadorSeleccionado.getPrimerNombre(),vacunadorSeleccionado.getSegundoNombre(),vacunadorSeleccionado.getPrimerApellido(),vacunadorSeleccionado.getSegundoApellido(),
					vacunadorSeleccionado.getTelefono()	,vacunadorSeleccionado.getEmail());						
			
			try {
				
					usuarioLocal.actualizarDatos(vacunadorAux);
					this.vacunadorSeleccionado = null;
					PrimeFaces.current().executeScript("PF('vacunadorDialog').hide()");
				    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Vacunador editado correctamente","" ));	
				
			 } catch (Exception e){
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(),"" ));
			 	}	
		}
	}
	
	public void buscarVacunador() {
		this.vacunadorSeleccionado = null;
		try {
			vacunadorSeleccionado = usuarioLocal.obtenerVacunador(cedulaUsuario);
		}catch (Exception e){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(),"" ));
	 	}
	}
	
	
	
	public void reiniciarVacunadorSeleccionado () {
		this.vacunadorSeleccionado = new DTVacunador();
		this.cedulaUsuario = 0;
	}

}
