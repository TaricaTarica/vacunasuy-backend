package beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;


import datatypes.DTEnvio;
import datatypes.DTLote;
import datatypes.DTSocioLogistico;
import datatypes.DTVacunatorio;
import datatypes.DTVistaEnvio;
import datos.EnvioDatoLocal;
import enumeradores.EstadoEnvio;
import negocio.EnvioNegocioLocal;
import negocio.LoteNegocioLocal;
import negocio.SocioLogisticoNegocioLocal;
import negocio.VacunatorioNegocioLocal;
import negocio.VistaEnvioNegocioLocal;

@Named("envioBean")
@ViewScoped
public class EnvioBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	
	@EJB
	private VistaEnvioNegocioLocal vistaLocal;
	@EJB
	private EnvioNegocioLocal envioLocal;
	@EJB
	private EnvioDatoLocal datoEnvioLocal;
	
	@EJB
	private LoteNegocioLocal loteLocal;

	@EJB
	private SocioLogisticoNegocioLocal socioLocal;

	@EJB
	private VacunatorioNegocioLocal vacunatorioLocal;
	
	private List<String> estados;
	private String nombreVacunatorio;
	private String nombreSocioLogistico;
	private String nombreLote;
	
	private EstadoEnvio estado;
	
	private DTEnvio envio;
	private List<DTEnvio> envios;
	//private List<Envio> enviosEntidad;
	private List<DTVistaEnvio> listaEnvios;
	
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
		 
		 this.setListaEnvios(vistaLocal.listarEnvios());
		// this.enviosEntidad = datoEnvioLocal.listarEnvios();
		 this.lotes = envioLocal.listarLotePendientesDeEnviar();
		 this.socioLogisticos = socioLocal.listarSocioLogistico();
		 this.vacunatorios = vacunatorioLocal.listarVacunatorio();
		 this.setEstados(envioLocal.listarEstado());
		 this.envio = new DTEnvio();
		 this.lote = new DTLote();
		 this.socioLogistico = new DTSocioLogistico();
		 this.vacunatorio = new DTVacunatorio();
		 
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
	


	public List<String> getEstados() {
		return estados;
	}



	public void setEstados(List<String> estados) {
		this.estados = estados;
	}



	public String getNombreVacunatorio() {
		return nombreVacunatorio;
	}



	public void setNombreVacunatorio(String nombreVacunatorio) {
		this.nombreVacunatorio = nombreVacunatorio;
	}



	public String getNombreSocioLogistico() {
		return nombreSocioLogistico;
	}



	public void setNombreSocioLogistico(String nombreSocioLogistico) {
		this.nombreSocioLogistico = nombreSocioLogistico;
	}



	public String getNombreLote() {
		return nombreLote;
	}



	public void setNombreLote(String nombreLote) {
		this.nombreLote = nombreLote;
	}

	


	public EstadoEnvio getEstado() {
		return estado;
	}



	public void setEstado(EstadoEnvio estado) {
		this.estado = estado;
	}

	public List<DTVistaEnvio> getListaEnvios() {
		return listaEnvios;
	}



	public void setListaEnvios(List<DTVistaEnvio> listaEnvios) {
		this.listaEnvios = listaEnvios;
	}



//	public List<Envio> getEnviosEntidad() {
//		return enviosEntidad;
//	}
//
//
//
//	public void setEnviosEntidad(List<Envio> enviosEntidad) {
//		this.enviosEntidad = enviosEntidad;
//	}
	
	public void reiniciarEnvio(){
		editar = false;   
		this.nombreBoton = "Agregar Envio";
		this.estiloBoton = "pi pi-check";
        this.envio = new DTEnvio();
        this.nombreLote = null;
        this.nombreSocioLogistico = null;
        this.nombreVacunatorio = null;
    }
	
	public void agregarEnvio() throws Exception {
		
		
		
		for (DTVacunatorio vac: vacunatorios) {
			if (vac.getNombre().equals(nombreVacunatorio)) {
				vacunatorio = vac;
			
			}
		} 
		lote = loteLocal.obtenerLote(nombreLote);
		
		for (DTSocioLogistico soc: socioLogisticos) {
			if (soc.getNombre().equals(nombreSocioLogistico)) {
				socioLogistico = soc;
			}
		} 
		
		try {
			if(editar) {
				//Funcion para editar el envio.
			}else {
				//Funcion para Agregar Envio
				envio.setEstado(estado.Pendiente);
				envioLocal.AgregarEnvio(envio, lote, vacunatorio, socioLogistico);
				this.init();
			}
		}catch (Exception e) {
				// TODO: handle exception
		}
	}


}
