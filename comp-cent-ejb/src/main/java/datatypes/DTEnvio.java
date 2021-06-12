package datatypes;

import java.time.LocalDate;

import entidades.Envio;
import entidades.Lote;
import entidades.SocioLogistico;
import entidades.Vacunatorio;

public class DTEnvio {
	
	private long id;
	private String estado;
	private LocalDate fechaCreacion;
	private Lote lote;
	private Vacunatorio vacunatorio;
	private SocioLogistico socioLogistico;


	public DTEnvio() {
		super();
	}
	
	public DTEnvio( long id, String estado,	 LocalDate fechaCreacion, Lote lote, Vacunatorio vacunatorio, SocioLogistico socioLogistico) {
		super();
		this.id = id;
		this.estado = estado;
		this.fechaCreacion = fechaCreacion;
		this.lote = lote;
		this.vacunatorio = vacunatorio;
		this.socioLogistico = socioLogistico;
		
		
	}
	
	public DTEnvio(Envio env) {
		super();
		this.id = env.getId();
		this.estado = env.getEstado();
		this.fechaCreacion = env.getFechaCreacion();
		this.lote = env.getLote();
		this.vacunatorio = env.getVacunatorio();
		this.socioLogistico = env.getSocioLogistico();
		
		
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
