package entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import datatypes.DTLogisticaDistribucion;

@Entity
public class LogisticaDistribucion {
	@Id 
	@GeneratedValue
	private long id;
	private String nombre;
	private String codigo;
	
	@OneToMany(mappedBy="logistica",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Lote> lotes = new ArrayList<>();
	
	@ManyToOne
	private SocioLogistico socio;
	
	public LogisticaDistribucion() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LogisticaDistribucion(DTLogisticaDistribucion logisticaDistribucion) {
		super();
		this.nombre = logisticaDistribucion.getNombre();
		this.codigo = logisticaDistribucion.getCodigo();
	}

	public LogisticaDistribucion(String nombre, String codigo) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public List<Lote> getLotes() {
		return lotes;
	}

	public void setLotes(List<Lote> lotes) {
		this.lotes = lotes;
	}
	
	public SocioLogistico getSocio() {
		return socio;
	}

	public void setSocio(SocioLogistico socio) {
		this.socio = socio;
	}

	public void agregarLote(Lote lote) {
		lotes.add(lote);
		lote.setLogistica(this);
	}
	public void eliminarLote(Lote lote) {
		lotes.remove(lote);
		lote.setLogistica(null);
	}
	
	
}
