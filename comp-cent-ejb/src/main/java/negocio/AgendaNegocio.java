package negocio;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import datatypes.DTAgenda;
import datos.AgendaDatoLocal;
import entidades.Agenda;

/**
 * Session Bean implementation class AgendaNegocio
 */
@Stateless
@LocalBean
public class AgendaNegocio implements AgendaNegocioRemote, AgendaNegocioLocal {

	@EJB
	private AgendaDatoLocal agendaLocal;
    /**
     * Default constructor. 
     */
    public AgendaNegocio() {
        // TODO Auto-generated constructor stub
    }

	public void agregarAgenda(DTAgenda dtAgenda) {
		Agenda agenda = new Agenda(dtAgenda);
		this.agendaLocal.agregarAgenda(agenda);
	}
	
	public List<DTAgenda> listarAgenda(){
		List <Agenda> agenda = (ArrayList<Agenda>)(this.agendaLocal.listarAgenda());
		List <DTAgenda> dtAgenda = new ArrayList<DTAgenda>();
		agenda.forEach((a)->{dtAgenda.add(new DTAgenda(a));});
		return dtAgenda;
	}
    
}
