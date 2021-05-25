package datatypes;



import entidades.Enfermedad;

public class DTEnfermedad {
	private long id;
	private String nombre;
	private String fechaCreacion;	
	
	public DTEnfermedad() {
		// TODO Auto-generated constructor stub
	}
	

	public DTEnfermedad(Enfermedad enfermedad) {
		super();
		this.id = enfermedad.getId();
		this.nombre = enfermedad.getNombre();
		this.fechaCreacion = enfermedad.getFechaCreacion().toString();
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(String fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	@Override
	public String toString() {
		return nombre;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}
	
	

}
