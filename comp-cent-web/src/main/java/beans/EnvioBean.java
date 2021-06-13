package beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import datatypes.DTEnfermedad;
import datatypes.DTEnvio;
import datatypes.DTLote;
import datatypes.DTSocioLogistico;
import datatypes.DTVacunatorio;
import negocio.EnvioNegocioLocal;
import negocio.LoteNegocioLocal;
import negocio.SocioLogisticoNegocioLocal;
import negocio.VacunatorioNegocioLocal;

@Named("envioBean")
@ViewScoped
public class EnvioBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@EJB
	private EnvioNegocioLocal envioLocal;
	
	@EJB
	private LoteNegocioLocal loteLocal;

	@EJB
	private SocioLogisticoNegocioLocal socioLocal;

	@EJB
	private VacunatorioNegocioLocal vacunatorioLocal;
	
	private DTEnvio envio;
	private List<DTEnvio> envios;
	
	private DTLote lote;
	private List<DTLote> lotes;
	
	private DTSocioLogistico socioLogistico;
	private List<DTSocioLogistico> socioLogisticos;
	
	private DTVacunatorio vacunatorio;
	private List<DTVacunatorio> vacunatorios;
	
	 //Agrego String para saber el estado del botón
	 
	 private String nombreBoton;
	 private String estiloBoton;
	 private Boolean editar;
	 
	 
	 
	 @PostConstruct
	public void init() {
		 
		 this.envios = envioLocal.listarEnvios();
		 this.lotes = loteLocal.listarLotes();
//		 this.socioLogistico = socioLocal.
		 this.vacunatorios = vacunatorioLocal.listarVacunatorio();
		 
		 
	 }



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public LoteNegocioLocal getLoteLocal() {
		return loteLocal;
	}



	public SocioLogisticoNegocioLocal getSocioLocal() {
		return socioLocal;
	}



	public VacunatorioNegocioLocal getVacunatorioLocal() {
		return vacunatorioLocal;
	}



	public DTLote getLote() {
		return lote;
	}



	public List<DTLote> getLotes() {
		return lotes;
	}



	public DTSocioLogistico getSocioLogistico() {
		return socioLogistico;
	}



	public List<DTSocioLogistico> getSocioLogisticos() {
		return socioLogisticos;
	}



	public DTVacunatorio getVacunatorio() {
		return vacunatorio;
	}



	public List<DTVacunatorio> getVacunatorios() {
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



	public void setLoteLocal(LoteNegocioLocal loteLocal) {
		this.loteLocal = loteLocal;
	}



	public void setSocioLocal(SocioLogisticoNegocioLocal socioLocal) {
		this.socioLocal = socioLocal;
	}



	public void setVacunatorioLocal(VacunatorioNegocioLocal vacunatorioLocal) {
		this.vacunatorioLocal = vacunatorioLocal;
	}



	public void setLote(DTLote lote) {
		this.lote = lote;
	}



	public void setLotes(List<DTLote> lotes) {
		this.lotes = lotes;
	}



	public void setSocioLogistico(DTSocioLogistico socioLogistico) {
		this.socioLogistico = socioLogistico;
	}



	public void setSocioLogisticos(List<DTSocioLogistico> socioLogisticos) {
		this.socioLogisticos = socioLogisticos;
	}



	public void setVacunatorio(DTVacunatorio vacunatorio) {
		this.vacunatorio = vacunatorio;
	}



	public void setVacunatorios(List<DTVacunatorio> vacunatorios) {
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



	public DTEnvio getEnvio() {
		return envio;
	}



	public List<DTEnvio> getEnvios() {
		return envios;
	}



	public void setEnvio(DTEnvio envio) {
		this.envio = envio;
	}



	public void setEnvios(List<DTEnvio> envios) {
		this.envios = envios;
	}
	
	 
	public void reiniciarEnfermedad(){
		editar = false;   
		this.nombreBoton = "Agregar Enfermedad";
		this.estiloBoton = "pi pi-check";
        this.envio = new DTEnvio();
    }
	
//	public void agregarEnvio() throws Exception {
//		
//		try {
//			if(editar) {
//				//Funcion para editar el envio.
//			}else {
//				envioLocal
//			}
//	}

}
