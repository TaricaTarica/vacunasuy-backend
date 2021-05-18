package entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import datatypes.DTAdministrador;

@Entity
//@DiscriminatorValue("A")
public class Administrador extends Usuario {

	
	private String usuario;
	private String contraseniaAdmin;
	
	
	
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private List<SocioLogistico> socios = new ArrayList<>();
	
	@ManyToMany(cascade= {CascadeType.PERSIST,CascadeType.MERGE})
	private List<Vacunatorio> vacunatorios = new ArrayList<>();
	
	public Administrador() {
		super();
	}

	public Administrador(int ci, String nombre, int telefono, String email,String user, String pass) {
		super(ci, nombre, telefono, email);
		this.usuario = user;
		this.contraseniaAdmin = pass;
		// TODO Auto-generated constructor stub
	}
	
	public Administrador (DTAdministrador dtAdm) {
		super(dtAdm.getCi(), dtAdm.getNombre(), dtAdm.getTelefono(), dtAdm.getEmail());
		this.contraseniaAdmin =  dtAdm.getPass();
		this.usuario = dtAdm.getUser();
	}

	

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContraseniaAdmin() {
		return contraseniaAdmin;
	}

	public void setContraseniaAdmin(String contraseniaAdmin) {
		this.contraseniaAdmin = contraseniaAdmin;
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
