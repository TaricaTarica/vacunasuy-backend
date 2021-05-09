package entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import datatypes.DTAdministrador;

@Entity
@DiscriminatorValue("A")
public class Administrador extends Usuario {

	private static final long serialVersionUID = 1L;
	
	private String user;
	private String pass;
	
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private List<SocioLogistico> socios = new ArrayList<>();
	
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Vacunatorio> vacunatorios = new ArrayList<>();
	
	public Administrador() {
		// TODO Auto-generated constructor stub
	}

	public Administrador(int ci, String nombre, int telefono, String email, String pass) {
		super(ci, nombre, telefono, email);
		// TODO Auto-generated constructor stub
	}
	
	public Administrador (DTAdministrador dtAdm) {
		super(dtAdm.getCi(), dtAdm.getNombre(), dtAdm.getTelefono(), dtAdm.getEmail());
		this.pass =  dtAdm.getPass();
		this.user = dtAdm.getUser();
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public List<SocioLogistico> getSocios() {
		return socios;
	}

	public void setSocios(List<SocioLogistico> socios) {
		this.socios = socios;
	}
	public void agregarSocio(SocioLogistico socio) {
		socios.add(socio);
		socio.getAdministradores().add(this);
	}
	public void eliminarSocio(SocioLogistico socio) {
		socios.remove(socio);
		socio.getAdministradores().remove(this);
	}
	
	public void agregarVacunatorio(Vacunatorio vacunatorio) {
		vacunatorios.add(vacunatorio);
		vacunatorio.getAdministradores().add(this);
	}
	public void eliminarVacunatorio(Vacunatorio vacunatorio) {
		vacunatorios.remove(vacunatorio);
		vacunatorio.getAdministradores().remove(this);
	}
}
