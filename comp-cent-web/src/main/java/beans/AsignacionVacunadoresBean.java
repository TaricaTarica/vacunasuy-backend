package beans;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;


import negocio.VacunatorioVacunadorNegocioLocal;

import datatypes.DTVacunador;
import datatypes.DTVacunatorio;
import datatypes.DTVacunatorioVacunador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("asignacionVacunadoresBean")
@ViewScoped
public class AsignacionVacunadoresBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	
	@EJB
	VacunatorioVacunadorNegocioLocal vacVacunador;
	
	List<DTVacunador> vacunadores;
	DTVacunatorio vacunatorio;
	String[] cedula;
	List<DTVacunador> vacunadoresEnVacunatorio;
	

	
	@PostConstruct
	public void init() {
	vacunadores = vacVacunador.obtenerVacunadoresLibres();
	}
	

	public String[] getCedula() {
		return cedula;
	}


	public void setCedula(String[] cedula) {
		this.cedula = cedula;
	}
	


	public DTVacunatorio getVacunatorio() {
		return vacunatorio;
	}


	public void setVacunatorio(DTVacunatorio vacunatorio) {
		this.vacunatorio = vacunatorio;
	}


	public List<DTVacunador> getVacunadores() {
		return vacunadores;
	}

	public void setVacunadores(List<DTVacunador> vacunadores) {
		this.vacunadores = vacunadores;
	}
	
	
	public List<DTVacunador> getVacunadoresEnVacunatorio() {
		return vacunadoresEnVacunatorio;
	}


	public void setVacunadoresEnVacunatorio(List<DTVacunador> vacunadoresEnVacunatorio) {
		this.vacunadoresEnVacunatorio = vacunadoresEnVacunatorio;
	}


	public void cargarVacunadoresVacunatorio(long id) {
		vacunadoresEnVacunatorio = vacVacunador.buscarVacunadoresAsignados(id);
	}
	
	
	public void cargarVacunadoresVacunatorio(DTVacunatorio vac) {
		vacunadores = vacVacunador.obtenerVacunadoresLibres();
		cedula = null;
		setVacunatorio(vac);
		List<DTVacunador> vacun = vacVacunador.buscarVacunadoresAsignados(vac.getId());
		
		String[] arr = new String[vacun.size()];
		int i = 0;
		for (DTVacunador v : vacun) {
			vacunadores.add(v);
			arr[i] = Integer.toString(v.getCi());
			i++;
		}
		cedula = arr;
		
		
	}
	
	public void asignarVacunadoresVacunatorio() {
		
	if (cedula.length > vacunatorio.getCantidadPuestos()) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Se superó la cantidad de vacunadores permitidos: "+ vacunatorio.getCantidadPuestos() );
        FacesContext.getCurrentInstance().addMessage(null, message);
	}else {
		
		List<DTVacunador> vacAsignados = new ArrayList<DTVacunador>();
			for (String c: cedula) {
				for (DTVacunador vac: vacunadores) {
					if (vac.getCi() == Integer.parseInt(c)) {
						vacAsignados.add(vac);
					}
				}	
			}
		DTVacunatorioVacunador dtVacVacunador = new DTVacunatorioVacunador(vacunatorio,vacAsignados);
		
	
			try {
			vacVacunador.agregarVacunadorVacunatorio(dtVacVacunador);
			PrimeFaces.current().executeScript("PF('vacunadoresDialog2').hide()");
		    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Vacunadores asignados correctamente","" ));
			}catch( Exception e) {
				FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error con Vacunatorio", e.getMessage());
		        FacesContext.getCurrentInstance().addMessage(null, message);
			}
	}
	}
	
	

}
