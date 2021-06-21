package beans;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named("googleMapsBean")
@ViewScoped
public class GoogleMapsBean implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private String y;
	private String x;
	private String coordenadas;
	
	
	public String getCoordenadas() {
		return coordenadas;
	}




	public void setCoordenadas(String coordenadas) {
		this.coordenadas = coordenadas;
	}




	@PostConstruct
	public void init() {
		

	}



	
	public void publicar() {
		System.out.println("longitud: " + x);
		System.out.println("Latitud: " + y);
		System.out.println("coordenadas: " + coordenadas);
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





	
}
