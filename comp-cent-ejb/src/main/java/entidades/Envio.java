package entidades;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import datatypes.DTEnvio;
import enumeradores.EstadoEnvio;

@Entity
public class Envio {
	@Id 
	@GeneratedValue
	private long id;
	@Enumerated(value = EnumType.STRING)
	private EstadoEnvio estado; 
	private LocalDate fechaCreacion = LocalDate.now();;
	
	@OneToOne
	private Lote lote;
	@ManyToOne
	private Vacunatorio vacunatorio;
	@ManyToOne
	private SocioLogistico socioLogistico;
	
	
	public Envio(){
		super();
	}
	
	public Envio(EstadoEnvio estado, Lote lote, Vacunatorio vacunatorio, SocioLogistico socioLogistico){
		super();
		this.estado = estado;
		this.socioLogistico = socioLogistico;
		this.vacunatorio = vacunatorio;
		this.lote = lote;		
	}
	
	public Envio(DTEnvio dtEnvio) {
		this.estado = dtEnvio.getEstado();
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
