package datatypes;

import java.io.Serializable;

public class DTVacunatorioGeom  implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private long id;
	private String nombre;
	private String coordenadas;
	
	public DTVacunatorioGeom() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DTVacunatorioGeom(long id, String nombre, String coordenadas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.coordenadas = coordenadas;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(String coordenadas) {
		this.coordenadas = coordenadas;
	}
	
}
