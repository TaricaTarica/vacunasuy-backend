package negocio;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import datatypes.DTAgenda;
import datatypes.DTPlanVacunacion;
import datos.AgendaDatoLocal;
import datos.PlanVacunacionDatoLocal;
import datos.VacunatorioDatoLocal;
import entidades.Agenda;
import entidades.PlanVacunacion;
import entidades.Vacunatorio;

/**
 * Session Bean implementation class AgendaNegocio
 */
@Stateless
@LocalBean
public class AgendaNegocio implements AgendaNegocioRemote, AgendaNegocioLocal {

	@EJB
	private AgendaDatoLocal agendaLocal;
	@EJB
	private VacunatorioDatoLocal vacunatorioLocal;
	@EJB
	private PlanVacunacionDatoLocal planLocal;
    /**
     * Default constructor. 
     */
    public AgendaNegocio() {
        // TODO Auto-generated constructor stub
    }

	public void agregarAgenda(DTAgenda dtAgenda) {
		Agenda agenda = new Agenda(dtAgenda);
		Vacunatorio vacunatorio = vacunatorioLocal.obtenerVacunatorio(dtAgenda.getDtVacunatorio().getId());
		agenda.setVacunatorio(vacunatorio);
		List<DTPlanVacunacion> planes = dtAgenda.getListDtPlanVacunacion();
		List<PlanVacunacion> planesAux = new ArrayList<PlanVacunacion>();
		for (DTPlanVacunacion plan : planes) {
			PlanVacunacion planVac = planLocal.obtenerPlanVacunacion(plan.getNombre());
			planesAux.add(planVac);
		}
		agenda.setPlanes(planesAux);
		this.agendaLocal.agregarAgenda(agenda);
	}
	
	public List<DTAgenda> listarAgenda(){
		List <Agenda> agenda = (ArrayList<Agenda>)(this.agendaLocal.listarAgenda());
		List <DTAgenda> dtAgenda = new ArrayList<DTAgenda>();
		if (agenda != null) {
			agenda.forEach((a)->{dtAgenda.add(new DTAgenda(a));});
		}
		return dtAgenda;
	}
    
}
