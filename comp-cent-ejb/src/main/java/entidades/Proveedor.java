package entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import datatypes.DTProveedor;

@Entity
public class Proveedor {
	@Id 
	@GeneratedValue
	private long id;
	private String nombre;
	private int telefono;
	
	@OneToMany(mappedBy="proveedor",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Vacuna> vacunas = new ArrayList<>();
	
	@ManyToMany(mappedBy="proveedores")
	private List<Autoridad> autoridades = new ArrayList<>();

	public Proveedor() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Proveedor(DTProveedor proveedor) {
		super();
		this.nombre = proveedor.getNombre();
		this.telefono = proveedor.getTelefono();
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

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public List<Vacuna> getVacunas() {
		return vacunas;
	}


	public void setVacunas(List<Vacuna> vacunas) {
		this.vacunas = vacunas;
	}
	
	public List<Autoridad> getAutoridades() {
		return autoridades;
	}

	public void setAutoridades(List<Autoridad> autoridades) {
		this.autoridades = autoridades;
	}

	/* Esto no se si está teóricamente correcto */
	public void agregarVacuna(Vacuna vacuna) {
		vacunas.add(vacuna);
		vacuna.setProveedor(this);
	}
	public void eliminarVacuna(Vacuna vacuna) {
		vacunas.remove(vacuna);
		vacuna.setProveedor(null);
	}
	
	

}
