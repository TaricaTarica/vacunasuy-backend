package datatypes;

import java.time.LocalDate;

import entidades.Lote;

public class DTLote {
	private long id;
	private String nombre;
	private int cantVacunas;
	private String fechaCreado;
	private DTVacuna vacuna;
	//public Vacuna vacuna;
	
	public DTLote() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public DTLote(Lote lote) {
		super();
		this.id = lote.getId();
		this.nombre = lote.getNombre();
		this.cantVacunas = lote.getCantVacunas();
		this.fechaCreado = lote.getFechaCreado().toString();
		
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

	public String getFechaCreado() {
		return fechaCreado;
	}

	public void setFechaCreado(LocalDate fechaCreado) {
		this.fechaCreado = fechaCreado.toString();
	}



	public int getCantVacunas() {
		return cantVacunas;
	}



	public void setCantVacunas(int cantVacunas) {
		this.cantVacunas = cantVacunas;
	}



	public DTVacuna getVacuna() {
		return vacuna;
	}



	public void setVacuna(DTVacuna vacuna) {
		this.vacuna = vacuna;
	}



	@Override
	public String toString() {
		return getNombre();
	}
	
	


}
