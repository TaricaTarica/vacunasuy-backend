package entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import datatypes.DTCiudadano;

@Entity
@DiscriminatorValue("C")
public class Ciudadano extends Usuario {


	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Vacunatorio> vacunatorios = new ArrayList<>();
	
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private List<PlanVacunacion> planes = new ArrayList<>();
	/*
	@OneToMany(mappedBy="ciudadano",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<RegistroVacuna> registros = new ArrayList<>();
	*/
	public Ciudadano() {
		super();
	}

	public Ciudadano(int ci, String nombre, int telefono, String email) {
		super(ci, nombre, telefono, email);
		// TODO Auto-generated constructor stub
	}

	public Ciudadano (DTCiudadano dtCiudadano) {
		super(dtCiudadano.getCi(), dtCiudadano.getNombre(), dtCiudadano.getTelefono(), 
				dtCiudadano.getEmail());
	}

	public List<Vacunatorio> getVacunatorios() {
		return vacunatorios;
	}

	public void setVacunatorios(List<Vacunatorio> vacunatorios) {
		this.vacunatorios = vacunatorios;
	}
	
	public void agregarVacunatorio(Vacunatorio vacunatorio) {
		vacunatorios.add(vacunatorio);
		vacunatorio.getCiudadanos().add(this);
	}
	public void eliminarVacunatorio(Vacunatorio vacunatorio) {
		vacunatorios.remove(vacunatorio);
		vacunatorio.getCiudadanos().remove(this);
	}

	public List<PlanVacunacion> getPlanes() {
		return planes;
	}

	public void setPlanes(List<PlanVacunacion> planes) {
		this.planes = planes;
	}
	
	public void agregarPlan(PlanVacunacion plan) {
		planes.add(plan);
		plan.getCiudadanos().add(this);
	}
	public void eliminarPlan(PlanVacunacion plan) {
		planes.remove(plan);
		plan.getCiudadanos().remove(this);
	}
/*
	public List<RegistroVacuna> getRegistros() {
		return registros;
	}

	public void setRegistros(List<RegistroVacuna> registros) {
		this.registros = registros;
	}
	
	*/
}
