package entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import datatypes.DTVacuna;

@Entity
public class Vacuna {
	@Id 
	@GeneratedValue
	private long id;
	private String nombre;
	private String codigo;
	private String laboratorio;
	
	@ManyToOne
	private Enfermedad enfermedad;
	
	@OneToMany(mappedBy="vacuna",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Lote> lotes = new ArrayList<>();
	
	@ManyToOne
	private Proveedor proveedor;
	
	@ManyToMany(mappedBy="vacunas")
	private List<Autoridad> autoridades = new ArrayList<>();
	
	
	@OneToMany(mappedBy="vacuna",cascade=CascadeType.ALL,orphanRemoval=true) 
	private List<RegistroVacuna> registros = new ArrayList<>();
	
	public Vacuna() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Vacuna(DTVacuna vacuna) {
		super();
		this.nombre = vacuna.getNombre();
		this.codigo = vacuna.getCodigo();
		this.laboratorio = vacuna.getLaboratorio();
	}
	
	public Vacuna(String nombre, String codigo, String laboratorio) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.laboratorio = laboratorio;
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
	public String getLaboratorio() {
		return laboratorio;
	}
	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}

	public Enfermedad getEnfermedad() {
		return enfermedad;
	}

	public void setEnfermedad(Enfermedad enfermedad) {
		this.enfermedad = enfermedad;
	}

	public List<Lote> getLotes() {
		return lotes;
	}

	public void setLotes(List<Lote> lotes) {
		this.lotes = lotes;
	}
	
	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public void agregarLote(Lote lote) {
		lotes.add(lote);
		lote.setVacuna(this);
	}
	public void eliminarVacuna(Lote lote) {
		lotes.remove(lote);
		lote.setVacuna(null);
	}

	public List<Autoridad> getAutoridades() {
		return autoridades;
	}

	public void setAutoridades(List<Autoridad> autoridades) {
		this.autoridades = autoridades;
	}



	public List<RegistroVacuna> getRegistros() {
		return registros;
	}

	public void setRegistros(List<RegistroVacuna> registros) {
		this.registros = registros;
	}
	
	
	
	
}
