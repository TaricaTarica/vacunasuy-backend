package beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import datatypes.DTDepartamento;
import datatypes.DTEnfermedad;
import datatypes.DTPlanVacunacion;
import datatypes.DTUbicacion;
import datatypes.DTVacuna;
import datatypes.DTVacunador;
import datatypes.DTVacunatorio;
import entidades.Vacunador;
import negocio.DepartamentoNegocioLocal;
import negocio.UsuarioNegocioLocal;
import negocio.VacunatorioNegocioLocal;
import webservicesoap.DtMsjVacunatorio;
import webservicesoap.VacunatorioServicio;
import webservicesoap.VacunatorioServicioService;

@Named("vacunatorioBean")
@ViewScoped
public class VacunatorioBean implements Serializable {

private static final long serialVersionUID = -9187425136651928924L;
	
	@EJB
	private VacunatorioNegocioLocal vacunatorioLocal;
	@EJB
	private DepartamentoNegocioLocal departamentoLocal;
	
	private List<DTVacunatorio> vacunatorios;
	private List<DTDepartamento> departamentos;
	private List<DTUbicacion> ubicaciones;
	private DTVacunatorio vacunatorioSeleccionado;
	
	private String nombreDepartamento;
	private String nombreUbicacion;
	private String nombreBoton;
	private String estiloBoton;
	private Boolean editar;
	
	
	@PostConstruct
	public void init() {
		vacunatorios = vacunatorioLocal.listarVacunatorio();
		vacunatorioSeleccionado = new DTVacunatorio();
		departamentos = departamentoLocal.obtenerDepartamentos();
		estiloBoton = "pi pi-check";
	}
	
		
	public List<DTVacunatorio> getVacunatorios() {
		return vacunatorios;
	}


	public void setVacunatorios(List<DTVacunatorio> vacunatorios) {
		this.vacunatorios = vacunatorios;
	}
	


	public DTVacunatorio getVacunatorioSeleccionado() {
		return vacunatorioSeleccionado;
	}


	public void setVacunatorioSeleccionado(DTVacunatorio vacunatorioSeleccionado) {
		this.vacunatorioSeleccionado = vacunatorioSeleccionado;
	}


	public String getEstiloBoton() {
		return estiloBoton;
	}


	public void setEstiloBoton(String estiloBoton) {
		this.estiloBoton = estiloBoton;
	}
	

	
	public String getNombreDepartamento() {
		return nombreDepartamento;
	}


	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}


	public String getNombreUbicacion() {
		return nombreUbicacion;
	}


	public void setNombreUbicacion(String nombreUbicacion) {
		this.nombreUbicacion = nombreUbicacion;
	}


	public String getNombreBoton() {
		return nombreBoton;
	}


	public void setNombreBoton(String nombreBoton) {
		this.nombreBoton = nombreBoton;
	}


	public Boolean getEditar() {
		return editar;
	}


	public void setEditar(Boolean editar) {
		this.editar = editar;
	}
	


	public List<DTDepartamento> getDepartamentos() {
		return departamentos;
	}


	public void setDepartamentos(List<DTDepartamento> departamentos) {
		this.departamentos = departamentos;
	}
	


	public List<DTUbicacion> getUbicaciones() {
		return ubicaciones;
	}


	public void setUbicaciones(List<DTUbicacion> ubicaciones) {
		this.ubicaciones = ubicaciones;
	}
	
	public void cargarUbicaciones() throws Exception {
        if (nombreDepartamento != null && !nombreDepartamento.equals("")) {
        	ubicaciones = departamentoLocal.obtenerDepartamentoUbicaciones(nombreDepartamento);
        }else {
        	ubicaciones = new ArrayList<DTUbicacion>();
        }
    }
	
	public void editarVacunatorio () throws Exception  {
		vacunatorioLocal.editarVacunatorio(vacunatorioSeleccionado);
		this.vacunatorioSeleccionado = null;
	    PrimeFaces.current().executeScript("PF('editarVacunatorioDialog').hide()");
	    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Vacunatorio editado correctamente","" ));
	
	}
	
	public void agregarVacunatorio () throws Exception {
		
		DTUbicacion ubicacion = new DTUbicacion();
		
				for (DTUbicacion ubi: ubicaciones) {
					if (ubi.getDescription().equals(nombreUbicacion)) {
						ubicacion = ubi;
					}
				}
				vacunatorioSeleccionado.setUbicacion(ubicacion);
				
				try {
						
								vacunatorioLocal.agregarVacunatorio(vacunatorioSeleccionado);
								vacunatorioSeleccionado.setId(vacunatorioLocal.obtenerVacunatorioPorCodigo(vacunatorioSeleccionado.getCodigo()).getId());
								vacunatorios.add(vacunatorioSeleccionado);
							    this.vacunatorioSeleccionado = null;
							    PrimeFaces.current().executeScript("PF('vacunatorioDialog').hide()");
							    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"vacunatorio agregado correctamente","" ));
									
					} catch (Exception e){
								FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(),"" ));
									
							
				}
		}
	
	public void editarVacunatorio(DTVacunatorio vac) throws Exception {
		this.editar = true;
		this.nombreBoton="Editar Vacunatorio";
		this.estiloBoton="pi pi-pencil";
		setVacunatorioSeleccionado(vac);
		}
	
	public void eliminarVacunatorioSeleccionado(DTVacunatorio vac) {
		try {
			vacunatorioLocal.eliminarVacunatorio(vac);
			this.vacunatorios.remove(vac);
			vacunatorioSeleccionado = null;
			 	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Confirmado", "Vacunatorio eliminado Correctamente");
		        FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
	        FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}

	public void reiniciarVacunatorioSeleccionado () {
		this.vacunatorioSeleccionado = new DTVacunatorio();
		this.nombreBoton="Agregar Vacunatorio";
        this.estiloBoton="pi pi-check";
        this.nombreDepartamento = null;
        this.nombreUbicacion= null;
	}

}

