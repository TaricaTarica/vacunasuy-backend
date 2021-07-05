package datos;

import java.time.LocalDate;
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
	
	@Override
	public Boolean existeAgendaActiva(long idVac, LocalDate fecha) {
		Boolean existe = (em.createQuery("Select a from Agenda a where a.vacunatorio.id = :id and :fecha between a.inicio and a.fin")
				.setParameter("id",idVac)
				.setParameter("fecha",fecha).getResultList().size()> 0);	
		return existe;

	}

	@Override
	public Agenda obtenerAgendaActivaVacunatorio(long idVac, LocalDate fecha) {
		Agenda agenda = em.createQuery("Select a from Agenda a where a.vacunatorio.id = :id and :fecha between a.inicio and a.fin",Agenda.class)
				.setParameter("id",idVac)
				.setParameter("fecha",fecha).getSingleResult();
		return agenda;	
	}
	
	@Override
	public List<Agenda> obtenerAgendasFuturasVacunatorio(long idVac, LocalDate fecha) {
		return em.createQuery("Select a from Agenda a where a.vacunatorio.id = :id and a.inicio > :fecha",Agenda.class)
				.setParameter("id",idVac)
				.setParameter("fecha",fecha).getResultList();
		
	}
	
	@Override
	public List<Agenda> obtenerAgendasActivasYPasadasVacunatorio(long idVacunatorio){
		List<Agenda> agendas = this.listarAgenda();
		List<Agenda> retorno = new ArrayList<>();
		for(Agenda a: agendas){
			if(a.getInicio().isBefore(LocalDate.now()) || a.getInicio().equals(LocalDate.now())) {
				if(a.getVacunatorio().getId() == idVacunatorio) {
					retorno.add(a);
				}
			}
		}
		return retorno;
	}
	
	
}
