package beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import entidades.Lote;
import entidades.SocioLogistico;
import entidades.Vacunatorio;
import negocio.LoteNegocioLocal;
import negocio.VacunatorioNegocioLocal;

@Named("envioBean")
@ViewScoped
public class EnvioBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EJB
	private LoteNegocioLocal loteLocal;

//	@EJB
//	private socio;

	@EJB
	private VacunatorioNegocioLocal vacunatorioLocal;
	
	private Lote lote;
	private List<Lote> lotes;
	
	private SocioLogistico socioLogistico;
	private List<SocioLogistico> socioLogisticos;
	
	private Vacunatorio vacunatorio;
	private List<Vacunatorio> vacunatorios;
	
	 //Agrego String para saber el estado del botón
	 
	 private String nombreBoton;
	 private String estiloBoton;
	 private Boolean editar;
	 
	 
	 
	 @PostConstruct
	public void init() {
		 
		 
	 }
	public Lote getLote() {
		return lote;
	}
	public List<Lote> getLotes() {
		return lotes;
	}
	public SocioLogistico getSocioLogistico() {
		return socioLogistico;
	}
	public List<SocioLogistico> getSocioLogisticos() {
		return socioLogisticos;
	}
	public Vacunatorio getVacunatorio() {
		return vacunatorio;
	}
	public List<Vacunatorio> getVacunatorios() {
		return vacunatorios;
	}
	public String getNombreBoton() {
		return nombreBoton;
	}
	public String getEstiloBoton() {
		return estiloBoton;
	}
	public Boolean getEditar() {
		return editar;
	}
	public void setLote(Lote lote) {
		this.lote = lote;
	}
	public void setLotes(List<Lote> lotes) {
		this.lotes = lotes;
	}
	public void setSocioLogistico(SocioLogistico socioLogistico) {
		this.socioLogistico = socioLogistico;
	}
	public void setSocioLogisticos(List<SocioLogistico> socioLogisticos) {
		this.socioLogisticos = socioLogisticos;
	}
	public void setVacunatorio(Vacunatorio vacunatorio) {
		this.vacunatorio = vacunatorio;
	}
	public void setVacunatorios(List<Vacunatorio> vacunatorios) {
		this.vacunatorios = vacunatorios;
	}
	public void setNombreBoton(String nombreBoton) {
		this.nombreBoton = nombreBoton;
	}
	public void setEstiloBoton(String estiloBoton) {
		this.estiloBoton = estiloBoton;
	}
	public void setEditar(Boolean editar) {
		this.editar = editar;
	}
	 
	 
	 

}
