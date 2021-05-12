package entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import datatypes.DTPuesto;

@Entity
public class Puesto {
	@Id 
	@GeneratedValue
	private long id;
	private String codigo;
	
	@ManyToMany(mappedBy="puestos")
	private List<Vacunador> vacunadores = new ArrayList<>();

	public Puesto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Puesto(DTPuesto puesto) {
		super();
		this.codigo = puesto.getCodigo();
	}
	
	public Puesto(String codigo) {
		super();
		this.codigo = codigo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public List<Vacunador> getVacunadores() {
		return vacunadores;
	}

	public void setVacunadores(List<Vacunador> vacunadores) {
		this.vacunadores = vacunadores;
	}
	
	
}
