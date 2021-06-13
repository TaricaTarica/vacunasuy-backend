package beans;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import datatypes.DTAgenda;
import datatypes.DTPlanVacunacion;
import datatypes.DTVacunatorio;
import negocio.AgendaNegocioLocal;
import negocio.PlanVacunacionNegocioLocal;
import negocio.VacunatorioNegocioLocal;

@Named("gestionAgendaBean")
@ViewScoped
public class GestionAgendaBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
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
	private List<DTPlanVacunacion> listPlanAux;
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
	private Boolean editar;
	private DTVacunatorio dtVacunatorio;
	
	
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
	
	public Boolean getEditar() {
		return editar;
	}

	public void setEditar(Boolean editar) {
		this.editar = editar;
	}


	public List<DTPlanVacunacion> getListPlanAux() {
		return listPlanAux;
	}

	public void setListPlanAux(List<DTPlanVacunacion> listPlanAux) {
		this.listPlanAux = listPlanAux;
	}

	public DTVacunatorio getDtVacunatorio() {
		return dtVacunatorio;
	}

	public void setDtVacunatorio(DTVacunatorio dtVacunatorio) {
		this.dtVacunatorio = dtVacunatorio;
	}

	public void reiniciarAgenda() {
		setFechaIni(null);
		setFechaFin(null);
		setHoraIni(null);
		setHoraFin(null);
		setVacunatorio("");
		setNombrePlan(null);
		setEditar(false);
		this.agendaSeleccionada = new DTAgenda();
		this.planesAgenda= new ArrayList<DTPlanVacunacion>();
	}
	
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
		this.editar = false;
	}
	
	public void agregarAgenda() {
		try {
			if (fechaIni.isBefore(fechaFin) || fechaIni.isEqual(fechaFin)){
				if (!(HoraIni.isAfter(HoraFin) || (HoraFin.isBefore(HoraIni)))) {
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
					this.agendaSeleccionada.setHoraInicio(HoraIni.getHour() * 100 + HoraIni.getMinute());
					this.agendaSeleccionada.setHoraFin(HoraFin.getHour() * 100 + HoraFin.getMinute());
					if (editar) {
						this.agendaLocal.editarAgenda(getAgendaSeleccionada());
						this.inicializar();
					} else {
						this.agendaLocal.agregarAgenda(agendaSeleccionada);
						this.inicializar();
					}
				} else {
					setMsjError("La hora de inicio debe ser anterior a la hora de fin");
				}
			} else {
				setMsjError("La fecha de inicio debe ser anterior o igual a la fecha de fin");
			}
		} catch (Exception e) {
			setMsjError(e.getMessage());
		}
	}
	
	public void editarAgenda (DTAgenda dtAgenda) {
		this.agendaSeleccionada.setId(dtAgenda.getId());
		setFechaIni(LocalDate.parse(dtAgenda.getInicio()));
		setFechaFin(LocalDate.parse(dtAgenda.getFin()));
		setHoraIni(LocalTime.of(dtAgenda.getHoraInicio() / 100, dtAgenda.getHoraInicio() % 100));
		setHoraFin(LocalTime.of(dtAgenda.getHoraFin() / 100, dtAgenda.getHoraFin() % 100));
		setVacunatorio(dtAgenda.getDtVacunatorio().getNombre());
		setDtVacunatorio(dtAgenda.getDtVacunatorio());
		setListPlanAux(dtAgenda.getListDtPlanVacunacion());
		String[] aux = new String[dtAgenda.getListDtPlanVacunacion().size()];
		int i = 0;
		for (DTPlanVacunacion planes : dtAgenda.getListDtPlanVacunacion() ) {
			aux[i]= planes.getNombre();
			i++;
		}
		setNombrePlan(aux);
		setEditar(true);
	}
	
	public void eliminarAgenda (DTAgenda dtAgenda) {
		try {
			agendaLocal.eliminarAgenda(dtAgenda);
			this.inicializar();
		} catch (Exception e) {
			setMsjError(e.getMessage());
		}
	}
	
}
