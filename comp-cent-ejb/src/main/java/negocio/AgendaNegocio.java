package negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import datatypes.DTAgenda;
import datatypes.DTPlanVacunacion;
import datos.AgendaDatoLocal;
import datos.PlanVacunacionDatoLocal;
import datos.ReservaDatoLocal;
import datos.VacunatorioDatoLocal;
import entidades.Agenda;
import entidades.PlanVacunacion;
import entidades.Vacuna;
import entidades.Vacunatorio;

/**
 * Session Bean implementation class AgendaNegocio
 */
@Stateless
@LocalBean
public class AgendaNegocio implements AgendaNegocioLocal {

	@EJB
	private AgendaDatoLocal agendaLocal;
	@EJB
	private VacunatorioDatoLocal vacunatorioLocal;
	@EJB
	private PlanVacunacionDatoLocal planLocal;
	@EJB
	private ReservaDatoLocal reservaLocal;
    /**
     * Default constructor. 
     */
    public AgendaNegocio() {
        // TODO Auto-generated constructor stub
    }

	public void agregarAgenda(DTAgenda dtAgenda) throws Exception {
		Agenda agenda = new Agenda(dtAgenda);
		Vacunatorio vacunatorio = vacunatorioLocal.obtenerVacunatorio(dtAgenda.getDtVacunatorio().getId());
		agenda.setVacunatorio(vacunatorio);
		if (!agendaLocal.agendaSuperpuesta(agenda)) {
			List<DTPlanVacunacion> planes = dtAgenda.getListDtPlanVacunacion();
			List<PlanVacunacion> planesAux = new ArrayList<PlanVacunacion>();
			for (DTPlanVacunacion plan : planes) {
				PlanVacunacion planVac = planLocal.obtenerPlanVacunacion(plan.getNombre());
				planesAux.add(planVac);
			}
			agenda.setPlanes(planesAux);
			this.agendaLocal.agregarAgenda(agenda);
		} else {
			throw new Exception("\n No se puede crear agenda, se superponen las fechas con otra agenda para ese vacunatorio");
		}
	}
	
	public List<DTAgenda> listarAgenda(){
		List <Agenda> agenda = (ArrayList<Agenda>)(this.agendaLocal.listarAgenda());
		List <DTAgenda> dtAgenda = new ArrayList<DTAgenda>();
		if (agenda != null) {
			agenda.forEach((a)->{dtAgenda.add(new DTAgenda(a));});
		}
		return dtAgenda;
	}
	
	@Override
	/*Devuelve una lista con todas las agendas no vencidas*/
	public List<DTAgenda> listarAgendasActivas(){
		List <Agenda> agendas = (ArrayList<Agenda>)(this.agendaLocal.listarAgenda());
		List <DTAgenda> retorno = new ArrayList<DTAgenda>(); 
		if(!agendas.isEmpty()) {
			for(Agenda agenda: agendas) {
				if(agenda.getFin().isAfter(LocalDate.now())){
					retorno.add(new DTAgenda(agenda));
				}
			}
			return retorno;
		}
		else {
			return null;
		}
		
	}
	
	@Override
	public void editarAgenda (DTAgenda dtAgenda) throws Exception {
		Agenda agenda = agendaLocal.obtenerAgendaPorId(dtAgenda.getId());
		Agenda ag = new Agenda(dtAgenda);
		if (agenda != null) {
			Vacunatorio vac = vacunatorioLocal.obtenerVacunatorio(dtAgenda.getDtVacunatorio().getId());
			agenda.setVacunatorio(vac);
			ag.setVacunatorio(vac);
			if (!agendaLocal.agendaSuperpuesta(ag)) {
				agenda.setInicio(LocalDate.parse(dtAgenda.getInicio()));
				agenda.setFin(LocalDate.parse(dtAgenda.getFin()));
				agenda.setHoraInicio(dtAgenda.getHoraInicio());
				agenda.setHoraFin(agenda.getHoraFin());
	
				List<DTPlanVacunacion> dtPlan = dtAgenda.getListDtPlanVacunacion();
				List<PlanVacunacion> planes = new ArrayList<PlanVacunacion>();
				for (DTPlanVacunacion plan: dtPlan) {
					planes.add(planLocal.obtenerPlanVacunacionPorId(plan.getId()));
				}
				agenda.setPlanes(planes);
				agendaLocal.editarAgenda(agenda);
			} else {
				throw new Exception("\n No se puede modificar agenda, se superponen las fechas con otra agenda para ese vacunatorio");
			}
		} else {
			throw new Exception("\nNo se encontro una agenda con el id ingresado");
		}
	}
	
	@Override
	public void eliminarAgenda (DTAgenda dtAgenda) throws Exception {
		Agenda agenda = agendaLocal.obtenerAgendaPorId(dtAgenda.getId());
		if (agenda != null) {
			if (!reservaLocal.existeReserva(agenda.getId())) {
				agendaLocal.eliminarAgenda(agenda);
			} else {
				throw new Exception("\nNo se puede eliminar la agenda, porque tiene reservas asociadas");
			}
		} else {
			throw new Exception("\nNo se encontro un agenda con el id ingresado");
		}
	}
	
	@Override
	public Agenda obtenerAgendaActiva(long idVac, LocalDate fecha) {
		Agenda agenda = agendaLocal.obtenerAgendaActivaVacunatorio(idVac, fecha);
		return agenda;
	}
	
	@Override
	public int countAgendasActivasHoy(long vacunaId) {
		List<Agenda> agendas = agendaLocal.listarAgenda();
		int retorno = 0;
		LocalDate hoy = LocalDate.now();
		for(Agenda a: agendas) {
			if(
					(a.getInicio().equals(hoy) || a.getInicio().isBefore(hoy)) &&
					(a.getFin().equals(hoy) || a.getFin().isBefore(hoy))
			){
				List<PlanVacunacion> planes = a.getPlanes();
				for(PlanVacunacion pv: planes) {
					List<Vacuna> vacunas = pv.getVacunas();
					for(Vacuna v: vacunas) {
						if(v.getId() == vacunaId) {
							retorno++;
						}
					}
				}
			}
		}
		return retorno;
	}
}
