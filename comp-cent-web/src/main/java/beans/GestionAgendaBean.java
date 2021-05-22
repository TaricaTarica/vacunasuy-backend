package beans;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import datatypes.DTAgenda;
import datatypes.DTPlanVacunacion;
import datatypes.DTVacunatorio;
import negocio.AgendaNegocioLocal;
import negocio.PlanVacunacionNegocioLocal;
import negocio.VacunatorioNegocioLocal;

@Named("gestionAgendaBean")
@RequestScoped
public class GestionAgendaBean {

	@EJB
	private AgendaNegocioLocal agendaLocal;
	@EJB
	private PlanVacunacionNegocioLocal planVacunacionLocal;
	@EJB
	private VacunatorioNegocioLocal vacunatorioLocal;
	
	private DTAgenda agendaSeleccionada;
	private String msjError;
	private List<DTAgenda> listAgendas;
	private List<DTPlanVacunacion> listPlanVacunacion;
	private List<DTVacunatorio> listVacunatorio;
	private List<String> nombresVacunatorios;
	private List<String> nombresPlanes;
	private List<DTPlanVacunacion> planesAgenda;
	private String vacunatorio;
	private String[] nombrePlan;
	private LocalTime HoraIni;
	private LocalTime HoraFin;
	private LocalDate fechaIni;
	private LocalDate fechaFin;
	
	@PostConstruct
	public void inicializar() {
		this.listAgendas = agendaLocal.listarAgenda();
		this.listPlanVacunacion = planVacunacionLocal.listarPlanesDeVacunacion();
		this.listVacunatorio = vacunatorioLocal.listarVacunatorio();
		this.nombresVacunatorios = vacunatorioLocal.nombresVacunatorios();
		this.nombresPlanes = planVacunacionLocal.nombresPlanes();
		this.agendaSeleccionada = new DTAgenda();
		this.msjError = "";
		this.planesAgenda= new ArrayList<DTPlanVacunacion>();
	}
	
	public String[] getNombreplan() {
		return nombrePlan;
	}

	public void setNombreplan(String[] nombreplan) {
		this.nombrePlan = nombreplan;
	}

	public LocalTime getHoraIni() {
		return HoraIni;
	}

	public void setHoraIni(LocalTime horaIni) {
		HoraIni = horaIni;
	}

	public LocalTime getHoraFin() {
		return HoraFin;
	}

	public void setHoraFin(LocalTime horaFin) {
		HoraFin = horaFin;
	}

	public DTAgenda getAgendaSeleccionada() {
		return agendaSeleccionada;
	}

	public List<String> getNombresPlanes() {
		return nombresPlanes;
	}

	public void setNombresPlanes(List<String> nombresPlanes) {
		this.nombresPlanes = nombresPlanes;
	}

	public String[] getNombrePlan() {
		return nombrePlan;
	}

	public void setNombrePlan(String[] nombrePlan) {
		this.nombrePlan = nombrePlan;
	}

	public void setAgendaSeleccionada(DTAgenda agendaSeleccionada) {
		this.agendaSeleccionada = agendaSeleccionada;
	}

	public List<DTAgenda> getDtAgendas() {
		return listAgendas;
	}

	public void setDtAgendas(List<DTAgenda> listAgendas) {
		this.listAgendas = listAgendas;
	}
	
	
	public List<DTPlanVacunacion> getListPlanVacunacion() {
		return listPlanVacunacion;
	}

	public void setListPlanVacunacion(List<DTPlanVacunacion> listPlanVacunacion) {
		this.listPlanVacunacion = listPlanVacunacion;
	}

	public List<DTVacunatorio> getListVacunatorio() {
		return listVacunatorio;
	}

	public void setListVacunatorio(List<DTVacunatorio> listVacunatorio) {
		this.listVacunatorio = listVacunatorio;
	}

	public List<DTAgenda> getListAgendas() {
		return listAgendas;
	}

	public void setListAgendas(List<DTAgenda> listAgendas) {
		this.listAgendas = listAgendas;
	}

	public List<String> getNombresVacunatorios() {
		return nombresVacunatorios;
	}

	public void setNombresVacunatorios(List<String> nombresVacunatorios) {
		this.nombresVacunatorios = nombresVacunatorios;
	}

	public String getMsjError() {
		return msjError;
	}

	public void setMsjError(String msjError) {
		this.msjError = msjError;
	}

	public List<DTPlanVacunacion> getPlanesAgencia() {
		return planesAgenda;
	}

	public void setPlanesAgencia(List<DTPlanVacunacion> planesAgencia) {
		this.planesAgenda = planesAgencia;
	}
	
	public void agregarAgenda() {
		try {
			this.msjError ="";
			List<DTPlanVacunacion> planesAux = new ArrayList<DTPlanVacunacion>();
			for (DTPlanVacunacion planes : listPlanVacunacion ) {
				for (String nombre : nombrePlan) {
					if (planes.getNombre().equals(nombre)) {
						planesAux.add(planes);
					}
				}
			}
			for (DTVacunatorio vac: listVacunatorio) {
				if (vac.getNombre().equals(vacunatorio)) {
					this.agendaSeleccionada.setDtVacunatorio(vac);
				}
			}
			this.agendaSeleccionada.setInicio(fechaIni.toString());
			this.agendaSeleccionada.setFin(fechaFin.toString());
			this.agendaSeleccionada.setListDtPlanVacunacion(planesAux);
			this.agendaSeleccionada.setHoraIncio(HoraIni.getHour() * 100 + HoraIni.getMinute());
			this.agendaSeleccionada.setHoraFin(HoraFin.getHour() * 100 + HoraFin.getMinute());
			this.agendaLocal.agregarAgenda(agendaSeleccionada);
			this.listAgendas.add(agendaSeleccionada);
			this.agendaSeleccionada = null;
			
		} catch (Exception e) {
			setMsjError(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	
    public LocalDate getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(LocalDate fechaIni) {
		this.fechaIni = fechaIni;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public void reiniciarAgendaSeleccionada(){
        this.agendaSeleccionada = new DTAgenda();
    }
    
    public void planesPorAgenda(DTAgenda dtAgenda){
    	this.planesAgenda= dtAgenda.getListDtPlanVacunacion();

    }

	public AgendaNegocioLocal getAgendaLocal() {
		return agendaLocal;
	}

	public void setAgendaLocal(AgendaNegocioLocal agendaLocal) {
		this.agendaLocal = agendaLocal;
	}

	public PlanVacunacionNegocioLocal getPlanVacunacionLocal() {
		return planVacunacionLocal;
	}

	public void setPlanVacunacionLocal(PlanVacunacionNegocioLocal planVacunacionLocal) {
		this.planVacunacionLocal = planVacunacionLocal;
	}

	public VacunatorioNegocioLocal getVacunatorioLocal() {
		return vacunatorioLocal;
	}

	public void setVacunatorioLocal(VacunatorioNegocioLocal vacunatorioLocal) {
		this.vacunatorioLocal = vacunatorioLocal;
	}

	public List<DTPlanVacunacion> getPlanesAgenda() {
		return planesAgenda;
	}

	public void setPlanesAgenda(List<DTPlanVacunacion> planesAgenda) {
		this.planesAgenda = planesAgenda;
	}

	public String getVacunatorio() {
		return vacunatorio;
	}

	public void setVacunatorio(String vacunatorio) {
		this.vacunatorio = vacunatorio;
	}

}
