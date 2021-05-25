package beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.primefaces.PrimeFaces;


import datatypes.DTLote;

import datatypes.DTVacuna;
import negocio.LoteNegocioLocal;
import negocio.VacunaNegocioLocal;

@Named("loteBean")
@ViewScoped
public class LoteBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private VacunaNegocioLocal vacunaLocal;
	@EJB
	private LoteNegocioLocal loteLocal;

	private DTVacuna vacuna;
	private List<DTLote> lotes;
	private DTLote lote;
	private List<DTVacuna> vacunas;
	
	private String nombreLote;
	private int cantVacunas;
	private String nombreVacuna;
	
	
	private String nombreBoton;
	private String estiloBoton;
	private Boolean editar;
	
	@PostConstruct
	public void init() {
		lotes = loteLocal.listarLotes();
		vacunas = vacunaLocal.obtenerVacunas();
		lote = new DTLote();
		vacuna = new DTVacuna();
		
	}
	

	public DTVacuna getVacuna() {
		return vacuna;
	}



	public void setVacuna(DTVacuna vacuna) {
		this.vacuna = vacuna;
	}


	public List<DTLote> getLotes() {
		return lotes;
	}


	public void setLotes(List<DTLote> lotes) {
		this.lotes = lotes;
	}


	public DTLote getLote() {
		return lote;
	}


	public void setLote(DTLote lote) {
		this.lote = lote;
	}

	
	public List<DTVacuna> getVacunas() {
		return vacunas;
	}

	
	public void setVacunas(List<DTVacuna> vacunas) {
		this.vacunas = vacunas;
	}


	public String getNombreLote() {
		return nombreLote;
	}


	public void setNombreLote(String nombreLote) {
		this.nombreLote = nombreLote;
	}


	public int getCantVacunas() {
		return cantVacunas;
	}

	
	public void setCantVacunas(int cantVacunas) {
		this.cantVacunas = cantVacunas;
	}
	

	
	public String getNombreVacuna() {
		return nombreVacuna;
	}


	public void setNombreVacuna(String nombreVacuna) {
		this.nombreVacuna = nombreVacuna;
	}


	public String getnombreBoton() {
		return nombreBoton;
	}


	public void setnombreBoton(String nombreBoton) {
		this.nombreBoton = nombreBoton;
	}
	
	
	public String getEstiloBoton() {
		return estiloBoton;
	}


	public void setEstiloBoton(String estiloBoton) {
		this.estiloBoton = estiloBoton;
	}


	public void editarLote(DTLote lote) throws Exception {
		this.editar = true;
		this.nombreBoton="Editar Lote";
		this.estiloBoton="pi pi-pencil";
		setLote(lote);
		nombreVacuna = lote.getVacuna().getNombre();
			
	}
	
	public void eliminarLoteSeleccionado(DTLote dtLote) throws Exception {
		
		
		try {
			loteLocal.eliminarLote(dtLote);
			this.lotes.remove(dtLote);
			lote = null;
			 	FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Confirmado", "Lote eliminado Correctamente");
		        FacesContext.getCurrentInstance().addMessage(null, message);
		} catch (Exception e) {
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", e.getMessage());
	        FacesContext.getCurrentInstance().addMessage(null, message);
		}
	}
	
	
	
	
	public void buscarLote () {
		this.lote = null;
		for (DTLote dtLote:lotes) {
			if (dtLote.getNombre().equals(nombreLote)) {
				lote = dtLote;
				break;
			}
		}
	
	}
		
	
	public void agregarEditarLote () throws Exception {
		DTVacuna vacAux = new DTVacuna();
			
		if (lote.getCantVacunas()<=0) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Cantidad de vacunas debe ser mayor a 0", ""));
		}
		else {
				for (DTVacuna vac: vacunas) {
					if (vac.getNombre().equals(nombreVacuna))
						vacAux = vac;
				}
				lote.setVacuna(vacAux);
				lote.setFechaCreado(LocalDate.now());
				try {
						if (editar) {
							loteLocal.editarLote(lote);
							this.lote = null;
						    PrimeFaces.current().executeScript("PF('loteDialog').hide()");
						    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Lote editado correctamente","" ));
						}
						else {
								loteLocal.agregarLote(lote);
								lote.setId(loteLocal.obtenerLote(lote.getNombre()).getId());
								lotes.add(lote);
							    this.lote = null;
							    PrimeFaces.current().executeScript("PF('loteDialog').hide()");
							    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Lote agregado correctamente","" ));
							}		
					} catch (Exception e){
								FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(),"" ));
									
							
				}
			}
		}
	
	
	
	public void reiniciarLote(){
        this.lote = new DTLote();
        this.nombreVacuna = null;
        this.nombreLote = null;
        this.nombreBoton="Agregar Lote";
        this.estiloBoton="pi pi-check";
        this.editar= false;
    }

}
