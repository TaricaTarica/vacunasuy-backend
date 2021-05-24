package entidades;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import datatypes.DTLote;

@Entity
public class Lote {
	@Id 
	@GeneratedValue
	private long id;
	
	private String nombre;
	private int cantVacunas;
	private LocalDate fechaCreado;
	
	@ManyToOne
	private Vacuna vacuna;
	
	
	@ManyToOne
	private LogisticaDistribucion logistica;
	
	public Lote() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Lote(DTLote lote) {
		super();
		this.nombre = lote.getNombre();
		this.cantVacunas = lote.getCantVacunas();
		this.fechaCreado = LocalDate.parse(lote.getFechaCreado());
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

	public LocalDate getFechaCreado() {
		return fechaCreado;
	}

	public void setFechaCreado(LocalDate fechaCreado) {
		this.fechaCreado = fechaCreado;
	}

	public Vacuna getVacuna() {
		return vacuna;
	}

	public void setVacuna(Vacuna vacuna) {
		this.vacuna = vacuna;
	}

	public LogisticaDistribucion getLogistica() {
		return logistica;
	}

	public void setLogistica(LogisticaDistribucion logistica) {
		this.logistica = logistica;
	}

	public int getCantVacunas() {
		return cantVacunas;
	}

	public void setCantVacunas(int cantVacunas) {
		this.cantVacunas = cantVacunas;
	}
	
	
}
