package beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import datatypes.DTSocioLogistico;
import negocio.SocioLogisticoNegocioLocal;

@Named("socioLogisticoBean")
@ViewScoped
public class SocioLogisticoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private SocioLogisticoNegocioLocal socioNegocio;
	
	private List<DTSocioLogistico> listSocio;
	private DTSocioLogistico socioSeleccionado;
	private String nombre;
	private String codigo;
	private String msjError;
	private Boolean editar;
	
	public SocioLogisticoBean() {
		// TODO Auto-generated constructor stub
	}

	public List<DTSocioLogistico> getListSocio() {
		return listSocio;
	}

	public void setListSocio(List<DTSocioLogistico> listSocio) {
		this.listSocio = listSocio;
	}

	public DTSocioLogistico getSocioSeleccionado() {
		return socioSeleccionado;
	}

	public void setSocioSeleccionado(DTSocioLogistico socioSeleccionado) {
		this.socioSeleccionado = socioSeleccionado;
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

	public String getMsjError() {
		return msjError;
	}

	public void setMsjError(String msjError) {
		this.msjError = msjError;
	}

	public Boolean getEditar() {
		return editar;
	}

	public void setEditar(Boolean editar) {
		this.editar = editar;
	}
	

	@PostConstruct
	public void inicializar() {
		this.listSocio = socioNegocio.listarSocioLogistico();
		this.msjError = "";
		this.editar = false;
		this.socioSeleccionado = new DTSocioLogistico();

	}
	
	public void reinciarSocioSeleccionado() {
		this.socioSeleccionado = new DTSocioLogistico();
	}
	
	public void agregarSocio() {
		try {
			this.socioSeleccionado.setCodigo(codigo);
			this.socioSeleccionado.setNombre(nombre);
			if (editar) {
				this.socioNegocio.editarSocioLogistico(socioSeleccionado);
				this.inicializar();
			} else {
				this.socioNegocio.agregarSocioLogistico(socioSeleccionado);
				this.inicializar();
			}
		} catch (Exception e) {
			setMsjError(e.getMessage());
		}
	}
	
	public void editarSocio(DTSocioLogistico dtSocio) {
		this.socioSeleccionado.setId(dtSocio.getId());
		this.setCodigo(dtSocio.getCodigo());
		this.setNombre(dtSocio.getNombre());
		setEditar(true);
	}
	
	public void eliminarSocio(DTSocioLogistico dtSocio) {
		try {
			this.socioNegocio.eliminarSocioLosgistico(dtSocio);
			this.inicializar();
		} catch (Exception e) {
			setMsjError(e.getMessage());
		}
	}
	
}
