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
public class AgendaDato implements AgendaDatoRemote, AgendaDatoLocal {

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
    
}
