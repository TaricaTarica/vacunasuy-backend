package datatypes;

import java.io.Serializable;

import entidades.Envio;
import enumeradores.EstadoEnvio;

public class DTEnvio implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private EstadoEnvio estado;

	public DTEnvio() {
		super();
	}
	
	public DTEnvio( long id, EstadoEnvio estado) {
		super();
		this.id = id;
		this.estado = estado;
	}
	
	public DTEnvio(Envio env) {
		super();
		this.id = env.getId();
		this.estado = env.getEstado();
	}

	public long getId() {
		return id;
	}
	public EstadoEnvio getEstado() {
		return estado;
	}

	public void setId(long id) {
		this.id = id;
	}
	public void setEstado(EstadoEnvio estado) {
		this.estado = estado;
	}
	
}
