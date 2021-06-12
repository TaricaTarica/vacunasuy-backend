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

import datatypes.DTVacuna;
import datatypes.DTVacunador;
import datatypes.DTVacunatorio;
import entidades.Vacunador;
import negocio.UsuarioNegocioLocal;
import negocio.VacunatorioNegocioLocal;

@Named("vacunatorioBean")
@ViewScoped
public class VacunatorioBean implements Serializable {

private static final long serialVersionUID = -9187425136651928924L;
	
	@EJB
	private VacunatorioNegocioLocal vacunatorioLocal;
	@EJB
	private UsuarioNegocioLocal vacunadorLocal;
	
	private List<DTVacunatorio> vacunatorios;
	private List<DTVacunador> vacunadores;
	private String[] cedulaVacunadores;
	private DTVacunatorio vacunatorioSeleccionado;
	private LocalDate fecha;
	
	
	
	
	
	@PostConstruct
	public void init() {
		vacunatorios = vacunatorioLocal.listarVacunatorio();
		vacunadores = vacunadorLocal.mostrarVacunadores();
		vacunatorioSeleccionado = new DTVacunatorio();
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
	


	

	public String[] getCedulaVacunadores() {
		return cedulaVacunadores;
	}


	public void setCedulaVacunadores(String[] cedulaVacunadores) {
		this.cedulaVacunadores = cedulaVacunadores;
	}


	public List<DTVacunador> getVacunadores() {
		return vacunadores;
	}


	public void setVacunadores(List<DTVacunador> vacunadores) {
		this.vacunadores = vacunadores;
	}
	


	public LocalDate getFecha() {
		return fecha;
	}


	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}


	public void asignarVacunadores () {
		List<Integer> vacunadoresSeleccionados = new ArrayList<Integer>();
		for (DTVacunador vac: vacunadores) {
			for (String cedula: cedulaVacunadores) {
				if (Integer.toString(vac.getCi()).equals(cedula)) {
					vacunadoresSeleccionados.add(Integer.parseInt(cedula));
				}
			}	
		}
		for (int i: vacunadoresSeleccionados) {
			System.out.println("cedula vacunador:"+ Integer.toString(i));
		}
		System.out.println ("fecha seleccionada: " + fecha.toString());
	}
	
	
	
	public void reiniciarVacunatorioSeleccionado () {
		this.vacunatorioSeleccionado = new DTVacunatorio();
		this.cedulaVacunadores = null;
	}

}

