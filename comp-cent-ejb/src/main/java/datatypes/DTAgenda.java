package datatypes;

import java.util.ArrayList;
import java.util.List;

import entidades.Agenda;
import entidades.PlanVacunacion;

public class DTAgenda {
	private long id;
	
	//private Vacunatorio vacunatorio;
	//private Plan plan;
	private String inicio;
	private String fin;
	private int horaInicio;
	private int horaFin;
	private DTVacunatorio dtVacunatorio;
	private List<DTPlanVacunacion> listDtPlanVacunacion;
	
	private String fechaAsignado;
	
	public DTAgenda() {
		super();
	}
	
	public DTVacunatorio getDtVacunatorio() {
		return dtVacunatorio;
	}

	public void setDtVacunatorio(DTVacunatorio dtVacunatorio) {
		this.dtVacunatorio = dtVacunatorio;
	}

	public List<DTPlanVacunacion> getListDtPlanVacunacion() {
		return listDtPlanVacunacion;
	}

	public void setListDtPlanVacunacion(List<DTPlanVacunacion> listDtPlanVacunacion) {
		this.listDtPlanVacunacion = listDtPlanVacunacion;
	}

	public DTAgenda(long id, String inicio, String fin, int horaInicio, int horaFin) {
		super();
		this.id = id;
		this.inicio = inicio;
		this.fin = fin;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
	}

	public DTAgenda(Agenda agenda) {
		super();
		this.id = agenda.getId();
		this.inicio = agenda.getInicio().toString();
		this.fin = agenda.getFin().toString();
		this.dtVacunatorio = new DTVacunatorio(agenda.getVacunatorio().getNombre(),agenda.getVacunatorio().getCodigo());
		this.horaInicio = agenda.getHoraInicio();
		this.horaFin = agenda.getHoraFin();
		this.listDtPlanVacunacion = new ArrayList<DTPlanVacunacion>();
		for (PlanVacunacion planes : agenda.getPlanes()) {
			DTPlanVacunacion plan = new DTPlanVacunacion(planes);
			plan.setEnfermedad(new DTEnfermedad(planes.getEnfermedad()));
			this.listDtPlanVacunacion.add(plan);
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getInicio() {
		return inicio;
	}

	public void setInicio(String inicio) {
		this.inicio = inicio;
	}

	public String getFin() {
		return fin;
	}

	public void setFin(String fin) {
		this.fin = fin;
	}

	public int getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio;
	}

	public int getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(int horaFin) {
		this.horaFin = horaFin;
	}
	
	public String getFechaAsignado() {
		return fechaAsignado;
	}

	public void setFechaAsignado(String fechaAsignado) {
		this.fechaAsignado = fechaAsignado;
	}

	@Override
	public String toString() {
		return "DTAgenda [id=" + id + ", inicio=" + inicio + ", fin=" + fin + ", horaInicio=" + horaInicio
				+ ", horaFin=" + horaFin + ", dtVacunatorio=" + dtVacunatorio + ", listDtPlanVacunacion="
				+ listDtPlanVacunacion + "]";
	}

	
}
