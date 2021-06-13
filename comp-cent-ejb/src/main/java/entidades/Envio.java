package entidades;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import datatypes.DTEnvio;
import enumeradores.EstadoEnvio;

@Entity
public class Envio {
	@Id 
	@GeneratedValue
	private long id;
	private EstadoEnvio estado; 
	private LocalDate fechaCreacion;
	
	@OneToOne
	private Lote lote;
	@OneToOne
	private Vacunatorio vacunatorio;
	@OneToOne
	private SocioLogistico socioLogistico;
	
	
	public Envio(){
		super();
	}
	
	public Envio(long id, EstadoEnvio estado, LocalDate fechaCreacion, Lote lote, Vacunatorio vacunatorio, SocioLogistico socioLogistico){
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
	public EstadoEnvio getEstado() {
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
	public void setEstado(EstadoEnvio estado) {
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
