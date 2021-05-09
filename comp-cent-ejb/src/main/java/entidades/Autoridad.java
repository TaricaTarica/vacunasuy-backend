package entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="usuarioCi")
public class Autoridad extends Usuario{

	private static final long serialVersionUID = 1L;
	
	private String Pass;
	
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Proveedor> proveedores = new ArrayList<>();
	
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Agenda> agendas = new ArrayList<>();
	
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private List<PlanVacunacion> planes = new ArrayList<>();

	public Autoridad() {
		// TODO Auto-generated constructor stub
	}

	public List<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}
	
	public String getPass() {
		return Pass;
	}

	public void setPass(String pass) {
		Pass = pass;
	}

	public void agregarProveedor(Proveedor proveedor) {
		proveedores.add(proveedor);
		proveedor.getAutoridades().add(this);
	}
	public void eliminarProveedor(Proveedor proveedor) {
		proveedores.remove(proveedor);
		proveedor.getAutoridades().remove(this);
	}

	public List<Agenda> getAgendas() {
		return agendas;
	}

	public void setAgendas(List<Agenda> agendas) {
		this.agendas = agendas;
	}
	public void agregarAgenda(Agenda agenda) {
		agendas.add(agenda);
		agenda.getAutoridades().add(this);
	}
	public void eliminarAgenda(Agenda agenda) {
		agendas.remove(agenda);
		agenda.getAutoridades().remove(this);
	}

	public List<PlanVacunacion> getPlanes() {
		return planes;
	}

	public void setPlanes(List<PlanVacunacion> planes) {
		this.planes = planes;
	}
	
	public void agregarPlan(PlanVacunacion plan) {
		planes.add(plan);
		plan.getAutoridades().add(this);
	}
	public void eliminarPlan(PlanVacunacion plan) {
		planes.remove(plan);
		plan.getAutoridades().remove(this);
	}
	

}
