package entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries ({
	@NamedQuery(name="Departamento.obtenerDepartamentos", query="Select d from Departamento d ORDER BY d.descripcion")
})
public class Departamento {
	@Id 
	@GeneratedValue
	private long id;
	private String descripcion;
	
	@OneToMany(cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Ubicacion> ubicaciones = new ArrayList<>();
	
	public Departamento() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Departamento(long id, String descripcion) {
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
	
	public List<Ubicacion> getUbicaciones() {
		return ubicaciones;
	}
	
	public void setUbicaciones(List<Ubicacion> ubicaciones) {
		this.ubicaciones = ubicaciones;
	}
	
	
}
