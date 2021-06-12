package entidades;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import datatypes.DTEnvio;

public class Envio {
	@Id 
	@GeneratedValue
	private long id;
	private String estado;
	private LocalDate fechaCreacion;
	private Lote lote;
	private Vacunatorio vacunatorio;
	private SocioLogistico socioLogistico;
	
	
	
	
	public Envio(long id, String estado, LocalDate fechaCreacion, Lote lote, Vacunatorio vacunatorio, SocioLogistico socioLogistico){
		super();
		this.estado = estado;
		this.fechaCreacion = fechaCreacion;
		this.id = id;
		this.socioLogistico = socioLogistico;
		this.vacunatorio = vacunatorio;
		this.lote = lote;
		
	}
	
	public Envio(DTEnvio envio) {
		super();
		this.estado = envio.getEstado();
		this.fechaCreacion = envio.getFechaCreacion();
		this.id = envio.getId();
		this.socioLogistico = envio.getSocioLogistico();
		this.vacunatorio = envio.getVacunatorio();
		this.lote = envio.getLote();
	}
	
	public long getId() {
		return id;
	}
	public String getEstado() {
		return estado;
	}
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}
	public Lote getLote() {
		return lote;
	}
	public Vacunatorio getVacunatorio() {
		return vacunatorio;
	}
	public SocioLogistico getSocioLogistico() {
		return socioLogistico;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	public void setLote(Lote lote) {
		this.lote = lote;
	}
	public void setVacunatorio(Vacunatorio vacunatorio) {
		this.vacunatorio = vacunatorio;
	}
	public void setSocioLogistico(SocioLogistico socioLogistico) {
		this.socioLogistico = socioLogistico;
	}
	

}
