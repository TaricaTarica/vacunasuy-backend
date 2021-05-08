package entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Transportista {

	@Id 
	@GeneratedValue
	private long id;
	private String descripcion;
	
	@OneToOne(mappedBy="transportista",
			cascade=CascadeType.ALL,
			orphanRemoval=true,
			fetch=FetchType.LAZY)
	private LogisticaDistribucion logistica;
	
	@OneToMany(mappedBy="transportista",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Evento> eventos = new ArrayList<>();
	
	public Transportista() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transportista(long id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public LogisticaDistribucion getLogistica() {
		return logistica;
	}

	public void setLogistica(LogisticaDistribucion logistica) {
		this.logistica = logistica;
	}
	
	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
	
	public void agregarEvento(Evento evento) {
		eventos.add(evento);
		evento.setTransportista(this);
	}
	public void eliminarEvento(Evento evento) {
		eventos.remove(evento);
		evento.setTransportista(null);
	}
	
	public void agregarLogistica(LogisticaDistribucion ld) {
		ld.setTransportista(this);
		this.logistica = ld;
	}
	public void eliminarLogistica() {
		if(logistica!=null) {
			logistica.setTransportista(null);
			this.logistica=null;
		}
	}
		
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transportista other = (Transportista) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	
}
