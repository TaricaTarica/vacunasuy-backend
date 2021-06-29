package beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import datatypes.DTVacunatorio;
import negocio.VacunatorioGeomNegocioLocal;
import negocio.VacunatorioNegocioLocal;

@Named("googleMapsBean")
@ViewScoped
public class GoogleMapsBean implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	
	@EJB
	private VacunatorioGeomNegocioLocal geomLocal;
	@EJB
	private VacunatorioNegocioLocal vacunatorioLocal;
	
	private String y;
	private String x;
	private String coordenadas;
	
	private DTVacunatorio vacunatorio;
	private List <DTVacunatorio> vacunatorios;
	private String nombreVacunatorio;
	
	
	


	@PostConstruct
	public void init() {
		this.vacunatorios = vacunatorioLocal.listarVacunatorio();
		
	} 
	
	
	public String getNombreVacunatorio() {
		return nombreVacunatorio;
	}


	public void setNombreVacunatorio(String nombreVacunatorio) {
		this.nombreVacunatorio = nombreVacunatorio;
	}


	public String getCoordenadas() {
		return coordenadas;
	}




	public void setCoordenadas(String coordenadas) {
		this.coordenadas = coordenadas;
	}



	
	public void publicar() {
		for (DTVacunatorio vac : vacunatorios) {
		
		if (vac.getNombre().equals(nombreVacunatorio)) {
			setVacunatorio(vac);
			System.out.println("Estoy probando " + vacunatorio);
		} else {
			System.out.println("Vacunatorio null");
		}
		}
		
	}

	public void insertarCoordenadas() {
		
		for (DTVacunatorio vac : vacunatorios) {
			
			if (vac.getNombre().equals(nombreVacunatorio)) {
				setVacunatorio(vac);
				System.out.println(y);
				System.out.println(x);
				System.out.println(vacunatorio);
				System.out.println(vacunatorio.getId());
				geomLocal.agregarCoordenadas(vacunatorio.getId(), y, x);
			} else {
				System.out.println("Vacunatorio null");
			}
		}
		
	}


	public String getY() {
		return y;
	}




	public String getX() {
		return x;
	}




	public void setY(String y) {
		this.y = y;
	}




	public void setX(String x) {
		this.x = x;
	}




	public DTVacunatorio getVacunatorio() {
		return vacunatorio;
	}




	public void setVacunatorio(DTVacunatorio vacunatorio) {
		this.vacunatorio = vacunatorio;
	}



	public void publicarVacunatorio(DTVacunatorio vac) {
		System.out.println(vac.getId());
		
	}


	public List <DTVacunatorio> getVacunatorios() {
		return vacunatorios;
	}


	public void setVacunatorios(List <DTVacunatorio> vacunatorios) {
		this.vacunatorios = vacunatorios;
	}


	
	
}
