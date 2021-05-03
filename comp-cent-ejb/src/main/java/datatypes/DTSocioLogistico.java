package datatypes;

import entidades.SocioLogistico;

public class DTSocioLogistico {
	private long id;
	private String nombre;
	private String matricula;
	private String transportista;
	


	public DTSocioLogistico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DTSocioLogistico(SocioLogistico socioLogistico) {
		super();
		this.id = socioLogistico.getId();
		this.nombre = socioLogistico.getNombre();
		this.matricula = socioLogistico.getMatricula();
		this.transportista = socioLogistico.getTransportista();
	}
	
	public DTSocioLogistico(String nombre, String matricula, String transportista) {
		super();
		this.nombre = nombre;
		this.matricula = matricula;
		this.transportista = transportista;
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

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getTransportista() {
		return transportista;
	}

	public void setTransportista(String transportista) {
		this.transportista = transportista;
	}

}
