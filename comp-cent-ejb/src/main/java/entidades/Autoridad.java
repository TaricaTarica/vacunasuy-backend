package entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@DiscriminatorValue("Aut")
public class Autoridad extends Usuario{

	
	private String contraseniaAutoridad;
	
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Proveedor> proveedores = new ArrayList<>();
	
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Agenda> agendas = new ArrayList<>();
	
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Vacuna> vacunas = new ArrayList<>();
	
	public Autoridad() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Proveedor> getProveedores() {
		return proveedores;
	}

	public void setProveedores(List<Proveedor> proveedores) {
		this.proveedores = proveedores;
	}
	


	public String getContraseniaAutoridad() {
		return contraseniaAutoridad;
	}

	public void setContraseniaAutoridad(String contraseniaAutoridad) {
		this.contraseniaAutoridad = contraseniaAutoridad;
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


	public List<Vacuna> getVacunas() {
		return vacunas;
	}

	public void setVacunas(List<Vacuna> vacunas) {
		this.vacunas = vacunas;
	}
	
	public void agregarVacuna(Vacuna vacuna) {
		vacunas.add(vacuna);
		vacuna.getAutoridades().add(this);
	}
	public void eliminarVacuna(Vacuna vacuna) {
		vacunas.remove(vacuna);
		vacuna.getAutoridades().remove(this);
	}
	
	
	

}
