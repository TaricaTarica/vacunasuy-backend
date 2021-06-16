package datatypes;

import java.io.Serializable;

import enumeradores.EstadoEnvio;

public class DTVistaEnvio implements Serializable {

	private static final long serialVersionUID = 1L;
	private long id;
	private EstadoEnvio estado;
	private DTVacunatorio vacunatorio;
	private DTSocioLogistico socioLogistico;
	private DTLote lote;
	

	public DTVistaEnvio( long id, EstadoEnvio estado) {
		super();
		this.id = id;
		this.estado = estado;
	}


	public DTVistaEnvio() {
		super();
	}

	
	public long getId() {
		return id;
	}



	public EstadoEnvio getEstado() {
		return estado;
	}



	public DTVacunatorio getVacunatorio() {
		return vacunatorio;
	}



	public DTSocioLogistico getSocioLogistico() {
		return socioLogistico;
	}



	public DTLote getLote() {
		return lote;
	}



	public void setId(long id) {
		this.id = id;
	}



	public void setEstado(EstadoEnvio estado) {
		this.estado = estado;
	}



	public void setVacunatorio(DTVacunatorio vacunatorio) {
		this.vacunatorio = vacunatorio;
	}



	public void setSocioLogistico(DTSocioLogistico socioLogistico) {
		this.socioLogistico = socioLogistico;
	}



	public void setLote(DTLote lote) {
		this.lote = lote;
	}



}
