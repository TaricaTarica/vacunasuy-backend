package datos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entidades.Agenda;

/**
 * Session Bean implementation class AgendaDato
 */
@Stateless
@LocalBean
public class AgendaDato implements AgendaDatoLocal {

	@PersistenceContext(name = "comp-centPersistenceUnit")
	private EntityManager em;

	
    public AgendaDato() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public void agregarAgenda(Agenda agenda) {
    	em.persist(agenda);
    }
    
    @Override
    public List<Agenda> listarAgenda(){
		List <Agenda> lista = new ArrayList <Agenda>();
		for (Object obj : em.createQuery("Select a from Agenda a").getResultList()) {
			Agenda a = (Agenda) obj;
			lista.add(a);
		}
    	return lista;
    }

	@Override
	public Agenda obtenerAgendaPorId(Long id) {
		// TODO Auto-generated method stub
		return em.find(Agenda.class, id);
	}
	
	@Override
	public void editarAgenda(Agenda agenda) {
		em.merge(agenda);
	}

	@Override
	public void eliminarAgenda(Agenda agenda) {
		em.remove(agenda);
	}
	
	@Override
	public Boolean agendaSuperpuesta(Agenda agenda) {
		List<Agenda> listAgenda = em.createQuery("Select a from Agenda a where a.vacunatorio.id = :id",Agenda.class).setParameter("id",agenda.getVacunatorio().getId()).getResultList();
		for (Agenda ag : listAgenda) {
			if ((agenda.getInicio().isAfter(ag.getInicio()) && agenda.getInicio().isBefore(ag.getFin())) || 
					(agenda.getFin().isAfter(ag.getInicio()) && agenda.getFin().isBefore(ag.getFin())) || 
					(agenda.getInicio().isEqual(ag.getFin())) || (agenda.getFin().isEqual(ag.getInicio())) ||
					(agenda.getInicio().isBefore(ag.getInicio()) && agenda.getFin().isAfter(ag.getFin()))) {
				return true;
			}
		}
		return false;
	}
}
